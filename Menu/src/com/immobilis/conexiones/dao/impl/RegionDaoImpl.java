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
import com.immobilis.conexiones.dao.RegionDao;
import com.immobilis.vo.RegionVO;


public class RegionDaoImpl implements RegionDao {

	@Override
	public List<RegionVO> listaRegiones() {

		long t1 = System.currentTimeMillis();
		BigDecimal estado =null;
		String msgError = null;
		Connection con = null;
		ResultSet rs = null;
		List<RegionVO> regiones = null;

		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_REGION.SP_LISTAR_REGIONES(?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			rs = (ResultSet)callableStatement.getObject(3);
			regiones = listarRegiones(rs);

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
		return regiones;
	}
	private List<RegionVO> listarRegiones(ResultSet rs)
			throws SQLException {
		List<RegionVO> regiones= new ArrayList();
		while (rs.next()) {
			RegionVO region = new RegionVO();
			region.setCodigoRegion(rs.getInt("ID_REGION"));
			region.setNombreRegion(rs.getString("NOMBRE_REGION"));
			regiones.add(region);
		}
		return regiones;
	}
	
}
