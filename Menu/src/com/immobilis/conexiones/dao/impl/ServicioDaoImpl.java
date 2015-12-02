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
import com.immobilis.conexiones.dao.ServicioDao;
import com.immobilis.vo.RegionVO;
import com.immobilis.vo.ServicioVO;

public class ServicioDaoImpl implements ServicioDao {

	@Override
	public List<ServicioVO> fetchAll() {
		long t1 = System.currentTimeMillis();
		BigDecimal estado =null;
		String msgError = null;
		Connection con = null;
		ResultSet rs = null;
		List<ServicioVO> regiones = null;

		try {
			String cifSpfetchAllServiciosMacQuery = "{call IMMOBILIS.PKG_SERVICIOS.SP_FETCH_ALL(?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpfetchAllServiciosMacQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			rs = (ResultSet)callableStatement.getObject(3);
			regiones = listarServicios(rs);

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

	private List<ServicioVO> listarServicios(ResultSet rs) throws SQLException {
		List<ServicioVO> servicios= new ArrayList<ServicioVO>();
		while(rs.next()){
			ServicioVO serv = new ServicioVO();
			serv.setIdServicio(rs.getInt("ID_SERVICIO"));
			serv.setDescripcion(rs.getString("DESCRIPCION"));
			serv.setFechaVIgencia(rs.getDate("FECHAVIGENCIA"));
			serv.setValorServicio(rs.getInt("VALOR"));
			servicios.add(serv);
		}
		
		return servicios;
	}

}
