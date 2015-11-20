package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.CobroDao;
import com.immobilis.conexiones.dao.CobroManagerDao;
import com.immobilis.vo.PagoVO;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:30
 */
public class CobroDaoImpl implements CobroDao {

	@Override
	public Map<Integer, PagoVO> filtrarCobros(Date fechaInicio, Date fechaTermino) {
		long t1 = System.currentTimeMillis();
		Map<Integer, PagoVO> pagos = new HashMap<>();

		BigDecimal estado = new BigDecimal(0);
		final String RESULTADO_CORRECTO = "Se ha creado Eliminado la cuenta";
		final String RESULTADO_INCORRECTO = "Ha ocurrido un problema al eliminar la cuenta, por favor inténtelo mas tarde";

		Connection con = null;
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_CLIENTE.SP_DELETE_CLIENTE(?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setDate(4, (java.sql.Date) fechaInicio);
			callableStatement.setDate(5, (java.sql.Date) fechaTermino);

			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			String msgError = callableStatement.getString(2);
			ResultSet rs = (ResultSet) callableStatement.getObject(3);
			pagos = rsToPagos(rs);
		} catch (SQLException sqle) {
			estado = new BigDecimal(1);
			sqle.printStackTrace();
		} finally {
			long t2 = System.currentTimeMillis();
			System.out.println("[ingresarNuevoUsuario]TIEMPO EJECUCION "
					+ (t2 - t1) + " miliseg");
			if (con != null) {
				try {
					ConnectionDAO.closeConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		return pagos;

	}

	private Map<Integer, PagoVO> rsToPagos(ResultSet rs) throws SQLException {
		Map<Integer, PagoVO> pagos = new HashMap<Integer, PagoVO>();
		
		while (rs.next()) {
			PagoVO pago = new PagoVO();
			pago.setEstadoPago(rs.getString("estado_pago"));
			pago.setFechaVencimiento(rs.getDate("fecha_Vencimiento"));
			pago.setIdVencimiento(rs.getInt("id_vencimiento"));
			pago.setIdContrato(rs.getInt("id_contrato"));
			pago.setMontoCuota(rs.getDouble("monto_cuota"));
			pago.setNumeroCuota(rs.getInt("n_cuota"));
			pagos.put(pago.getIdVencimiento(), pago);
		}
		return pagos;
	}

}// end CobroManagerDaoImpl