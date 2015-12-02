package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.FormularioReservaDao;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.ReservaVO;

public class FormularioReservaDaoImpl implements FormularioReservaDao {

	@Override
	public boolean SendReserve(ReservaVO reserva) {
		long t1 = System.currentTimeMillis();
		int idPropiedad=reserva.getIdPropiedad();
		int tipoReserva = reserva.getTipoReserva();
		int idSeguro = reserva.getIdSeguro();
		String rut = reserva.getRutUsuario();
		boolean correcto = false;
		Connection con = null;

		try {
			String cifSpEnviaReserva = "{call IMMOBILIS.PKG_PROPIEDADES.SP_RESERVA_PROPIEDAD(?,?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpEnviaReserva);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setInt(4, idPropiedad);
			callableStatement.setInt(5, tipoReserva);
			callableStatement.setInt(6, idSeguro);
			callableStatement.setString(7, rut);
			
			callableStatement.execute();
			String msg = callableStatement.getString(2);
			BigDecimal dm = callableStatement.getBigDecimal(1);
			if(dm.intValue()==0){
				correcto=true;
			}

		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} finally {
			long t2 = System.currentTimeMillis();
			System.out.println("[buscarUsuarioWeb]TIEMPO EJECUCION "
					+ (t2 - t1) + " miliseg");
			if (con != null) {
				try {
					ConnectionDAO.closeConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return correcto;
	}

}
