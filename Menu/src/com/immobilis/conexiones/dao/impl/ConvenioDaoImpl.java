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
import com.immobilis.conexiones.dao.ConvenioDao;
import com.immobilis.vo.ConvenioVO;
import com.immobilis.vo.SeguroVO;

public class ConvenioDaoImpl implements ConvenioDao {

	@Override
	public List<ConvenioVO> fetchAll() {
		long t1 = System.currentTimeMillis();
		BigDecimal estado =null;
		String msgError = null;
		Connection con = null;
		ResultSet rs = null;
		List<ConvenioVO> convenios = null;

		try {
			String cifSpfetchConveniosQuery = "{call IMMOBILIS.PKG_SERVICIOS.SP_FETCH_ALL_CONVENIOS(?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpfetchConveniosQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			rs = (ResultSet)callableStatement.getObject(3);
			convenios = getConvenios(rs);

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
		return convenios;
	}

	private List<ConvenioVO> getConvenios(ResultSet rs) throws SQLException {
		List<ConvenioVO> convenios = new ArrayList<ConvenioVO>();
		while(rs.next()){
			ConvenioVO convevio = new ConvenioVO();
			convevio.setId(rs.getString("ID"));
			convevio.setDescripcion(rs.getString("DESCRIPCION"));
			convevio.setDescuento(rs.getInt("DESCUENTO"));
			convevio.setFechaVigencia(rs.getDate("FECHA_VIGENCIA"));
			convenios.add(convevio);
		}
		
		return convenios;
	}
	
}
