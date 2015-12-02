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
import com.immobilis.conexiones.dao.ReservaDao;
import com.immobilis.vo.ReservaVO;

public class ReservaDaoImpl implements ReservaDao {

	@Override
	public List<ReservaVO> fetchReservas(String rutCliente, String idReserva) {
		long t1 = System.currentTimeMillis();
		BigDecimal estado = null;
		String msgError = null;
		Connection con = null;
		ResultSet rs = null;
		List<ReservaVO> reservas = null;
		int idRes;
		String rut;
		try {
			if (idReserva != null) {
				idRes = Integer.parseInt(idReserva.trim().equals("")?"-1":idReserva);
			}else{
				idRes=-1;
			}
			rut = rutCliente.trim().equals("") ? null : rutCliente;
			String cifSpfetchResQuery = "{call IMMOBILIS.PKG_PROPIEDADES.SP_FETCH_RESERVAS(?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpfetchResQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setInt(4, idRes);
			callableStatement.setString(5, rut);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			rs = (ResultSet) callableStatement.getObject(3);
			reservas = rsToList(rs);

		} catch (SQLException sqle) {
			estado = new BigDecimal(1);
			sqle.printStackTrace();
		} finally {
			long t2 = System.currentTimeMillis();
			System.out.println("[fetchReservas] TIEMPO EJECUCION " + (t2 - t1)
					+ " miliseg");
			if (con != null) {
				try {
					ConnectionDAO.closeConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return reservas;
	}

	private List<ReservaVO> rsToList(ResultSet rs) throws SQLException {
		List<ReservaVO> reservas = new ArrayList<ReservaVO>();
		while (rs.next()) {
			ReservaVO res = new ReservaVO();
			res.setIdReserva(rs.getInt("ID_RESERVA"));
			res.setRutUsuario(rs.getString("RUT"));
			res.setIdSeguro(rs.getInt("ID_SEGURO"));
			res.setIdPropiedad(rs.getInt("ID_PROPIEDAD"));
			res.setRutUsuario(rs.getString("RUT"));
			reservas.add(res);
		}
		return reservas;
	}

}
