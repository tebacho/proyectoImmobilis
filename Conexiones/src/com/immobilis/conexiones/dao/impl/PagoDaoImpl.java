package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import oracle.jdbc.internal.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.PagoDao;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ContratoVO;
import com.immobilis.vo.PagoVO;

public class PagoDaoImpl implements PagoDao {

	@Override
	public Map<Integer, PagoVO> fetchPagosPendientes(ClienteVO cliente) {
		long t1 = System.currentTimeMillis();
		String rutCliente = cliente.getRut();
		BigDecimal estado = null;
		String msgError = null;
		Connection con = null;
		ResultSet rs = null;
		Map<Integer, PagoVO> listadoPagos = null;

		try {
			String cifSpContratosVigentesQuery = "{call IMMOBILIS.PKG_PAGOS.SP_CONTRATOS_ACTIVOS(?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpContratosVigentesQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setString(4, rutCliente);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			listadoPagos = rsToPagos(rs);

		} catch (SQLException sqle) {
			estado = new BigDecimal(1);
			sqle.printStackTrace();
		} finally {
			long t2 = System.currentTimeMillis();
			System.out.println("[listarComunas] TIEMPO EJECUCION " + (t2 - t1)
					+ " miliseg");
			if (con != null) {
				try {
					ConnectionDAO.closeConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return listadoPagos;
	}
	private Map<Integer, PagoVO> rsToPagos(ResultSet rs){
		
		return null;
	}
	

}
