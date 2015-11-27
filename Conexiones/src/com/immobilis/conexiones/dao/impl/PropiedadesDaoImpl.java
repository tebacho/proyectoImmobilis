package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.PropiedadesDao;
import com.immobilis.vo.BodegaVO;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.DepartamentoVO;
import com.immobilis.vo.EstacionamientoVO;
import com.immobilis.vo.OficinaVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.PropiedadVO.TipoPropiedad;


public class PropiedadesDaoImpl implements PropiedadesDao {

	@Override
	public Map<String, PropiedadVO> fetchByFilter(String filtroTipoOperacion,
			String filtroTipoPropiedadBuscada,
			String filtroUbicacion) {
		long t1 = System.currentTimeMillis();
		Map<String, PropiedadVO> listadoPropiedades = null;
		Connection con = null;

		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_PROPIEDADES.SP_FILTRO_PROPIEDADES(?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setString(4, filtroTipoOperacion);
			callableStatement.setString(5,filtroTipoPropiedadBuscada.toString());
			callableStatement.setString(6, filtroUbicacion);
			callableStatement.execute();
			BigDecimal dm = callableStatement.getBigDecimal(1);

			if (dm.intValue() == 0) {
				ResultSet rsPropiedades = (ResultSet) callableStatement
						.getObject(3);
				listadoPropiedades = rsIntoPropiedades(rsPropiedades);

			}
		} catch (SQLException sqle) {

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
		return listadoPropiedades;
	}
	

	private Map<String, PropiedadVO> rsIntoPropiedades(ResultSet rsPropiedades)
			throws SQLException {
		Map<String, PropiedadVO> propiedades = null;
		if (rsPropiedades.next()) {
			if (propiedades == null) {
				propiedades = new HashMap<String, PropiedadVO>();
			}
			propiedades.put("", new CasaVO());
		}
		return propiedades;
	}


	@Override
	public PropiedadVO fetchPropiedadById(String idPropiedad) {
		long t1 = System.currentTimeMillis();
		PropiedadVO propiedad= null;
		Connection con = null;

		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_PROPIEDADES.SP_FETCH_PROPIEDAD(?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con.prepareCall(cifSpActEstadoMacQuery);
			
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setString(4, idPropiedad);
			callableStatement.execute();

			BigDecimal dm = callableStatement.getBigDecimal(2);

			if (dm.intValue() == 0) {
				ResultSet rsPropiedades = (ResultSet) callableStatement.getObject(3);
				propiedad = rsIntoPropiedad(rsPropiedades);

			}
		} catch (SQLException sqle) {
			
		} finally {
			long t2 = System.currentTimeMillis();
			System.out.println("[fetchPropiedadById]TIEMPO EJECUCION "
					+ (t2 - t1) + " miliseg");
			if (con != null) {
				try {
					ConnectionDAO.closeConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return propiedad;
	}
	
	private PropiedadVO rsIntoPropiedad(ResultSet rsPropiedad) throws SQLException{
		String tipoPropiedad = rsPropiedad.getString("tipoPropiedad");
		
		PropiedadVO propiedad = null;
		switch (tipoPropiedad) {
		case "BODEGA":
		propiedad = new BodegaVO();
			
			break;
		case "OFICINA":
		propiedad = new OficinaVO();	
			break;	
		case "ESTACIONAMIENTO":
		propiedad = new EstacionamientoVO();			
					break;	
		case "DEPARTAMENTO":
		propiedad = new DepartamentoVO();	
			break;	
		case "CASA":
		propiedad = new CasaVO();
			break;		
		default:
			
		}
		return propiedad;
	}
	

}
