package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.SeguroDao;
import com.immobilis.vo.SeguroVO;
import com.immobilis.vo.ServicioVO;

public class SeguroDaoImpl implements SeguroDao {

	@Override
	public SeguroVO fetchSeguro(int idSeguro) {
		long t1 = System.currentTimeMillis();
		BigDecimal estado =null;
		String msgError = null;
		Connection con = null;
		ResultSet rs = null;
		SeguroVO seguro = null;

		try {
			String cifSpfetchSeguroMacQuery = "{call IMMOBILIS.PKG_SERVICIOS.SP_FETCH_SEGURO(?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpfetchSeguroMacQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setInt(4, idSeguro);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			rs = (ResultSet)callableStatement.getObject(3);
			seguro = getSeguro(rs);

		} catch (SQLException sqle) {
			estado = new BigDecimal(1);
			sqle.printStackTrace();
		} finally {
			long t2 = System.currentTimeMillis();
			System.out.println("[listarRegiones] TIEMPO EJECUCION " + (t2 - t1)
					+ " miliseg");
			if (con != null) {
				try {
					ConnectionDAO.closeConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return seguro;
	}

	private SeguroVO getSeguro(ResultSet rs) throws SQLException {
		SeguroVO seg = new SeguroVO();
		while(rs.next()){
			
			seg.setSeguro(rs.getInt("ID_SEGURO"));
			seg.setCompania(rs.getString("COMPANIA"));
			seg.setMonto(rs.getInt("MONTO"));
			seg.setGlosa(rs.getString("GLOSA"));
		}
		
		return seg;
	}

}
