package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.internal.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.ComunaDao;
import com.immobilis.vo.ComunaVO;

public class ComunaDaoImpl implements ComunaDao {

	@Override
	public List<ComunaVO> listarComunas() {
		long t1 = System.currentTimeMillis();
		BigDecimal estado =null;
		String msgError = null;
		Connection con = null;
		ResultSet rs = null;
		List<ComunaVO> comunas = null;

		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_COMUNA.SP_LISTAR_COMUNAS(?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con.prepareCall(cifSpActEstadoMacQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			rs = (ResultSet)callableStatement.getObject(3);
			comunas = rsIntoComunas(rs);

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
		return comunas;
	}

	private List<ComunaVO> rsIntoComunas(ResultSet rs)
			throws SQLException {
		List<ComunaVO> comunas = new ArrayList();
		while (rs.next()) {
			ComunaVO comuna = new ComunaVO();
			comuna.setCodigoComuna(rs.getInt("ID_COMUNA"));
			comuna.setNombreComuna(rs.getString("NOMBRE_COMUNA"));
			comuna.setCodigoRegion(rs.getInt("ID_REGION"));
			comunas.add(comuna);
		}
		return comunas;
	}

	@Override
	public List<ComunaVO> fetchComunas(ComunaVO comuna) {
		long t1 = System.currentTimeMillis();
		BigDecimal estado =null;
		String msgError = null;
		Connection con = null;
		int codigoComuna=comuna.getCodigoComuna();
		int codigoRegion = comuna.getCodigoRegion();
		String nombreComuna = comuna.getNombreComuna();
		ResultSet rs = null;
		List<ComunaVO> comunas = null;

		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_COMUNA.SP_FILTRAR_COMUNAS(?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setInt(4, codigoComuna);
			callableStatement.setInt(5, codigoRegion);
			callableStatement.setString(6, nombreComuna);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			comunas = rsIntoComunas(rs);

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
		return comunas;
	}

	@Override
	public ComunaVO agregarComuna(ComunaVO comuna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComunaVO editarComuna(ComunaVO comuna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarComuna(ComunaVO comuna) {
		// TODO Auto-generated method stub
		return false;
	}

}
