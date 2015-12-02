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
import com.immobilis.conexiones.dao.PropiedadesDao;
import com.immobilis.vo.BodegaVO;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.ConstructoraVO;
import com.immobilis.vo.DepartamentoVO;
import com.immobilis.vo.EstacionamientoVO;
import com.immobilis.vo.OficinaVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.PropietarioVO;
import com.immobilis.vo.PropiedadVO.TipoOperacion;
import com.immobilis.vo.PropiedadVO.TipoPropiedad;
import com.immobilis.vo.RegionVO;

public class PropiedadesDaoImpl implements PropiedadesDao {

	@Override
	public Map<Integer, PropiedadVO> fetchByFilter(String filtroTipoOperacion,
		String filtroTipoPropiedadBuscada, String filtroUbicacion) {
		
		long t1 = System.currentTimeMillis();
		Map<Integer, PropiedadVO> listadoPropiedades = null;
		Connection con = null;

		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_PROPIEDADES.SP_FILTER_PROPIEDADES(?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con.prepareCall(cifSpActEstadoMacQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			
			callableStatement.setString(4, filtroTipoOperacion.trim().equals("")?null:filtroTipoOperacion);
			callableStatement.setString(5,
					filtroTipoPropiedadBuscada.trim().equals("")?null:filtroTipoPropiedadBuscada);
			callableStatement.setString(6, filtroUbicacion.trim().equals("")?null:filtroUbicacion);
			callableStatement.execute();
			BigDecimal dm = callableStatement.getBigDecimal(1);

			if (dm.intValue() == 0) {
				ResultSet rsPropiedades = (ResultSet) callableStatement
						.getObject(3);
				listadoPropiedades = rsIntoPropiedades(rsPropiedades);

			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} finally {
			long t2 = System.currentTimeMillis();
			System.out.println("[filtrarPorpiedades]TIEMPO EJECUCION "
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

	private Map<Integer, PropiedadVO> rsIntoPropiedades(ResultSet rsPropiedad)
			throws SQLException {
		Map<Integer, PropiedadVO> propiedades = new HashMap<Integer, PropiedadVO>();
		
		while (rsPropiedad.next()) {
			if (rsPropiedad != null) {
				String tipoPropiedad = rsPropiedad.getString("TIPO_PROPIEDAD");
				PropiedadVO propiedad = null;
				switch (tipoPropiedad) {
				case "BODEGA":
					BodegaVO bodega = new BodegaVO();
					bodega.setAltura(rsPropiedad.getDouble("ALTURA"));
					bodega.setTipoPropiedad(TipoPropiedad.BODEGA);
					propiedad = bodega;
					break;
				case "OFICINA":
					OficinaVO oficina = new OficinaVO();
					oficina.setPatenteComercial(rsPropiedad.getInt("PATENTECOMERCIAL"));
					oficina.setTipoPropiedad(TipoPropiedad.OFICINA);
					propiedad = oficina;
					break;
				case "ESTACIONAMIENTO":
					EstacionamientoVO estacionamiento = new EstacionamientoVO();
					estacionamiento.setNivel(rsPropiedad.getInt("NIVEL"));
					estacionamiento.setTipoPropiedad(TipoPropiedad.ESTAC);
					propiedad = estacionamiento;
					break;
				case "DEPARTAMENTO":
					DepartamentoVO departamento = new DepartamentoVO();
					departamento.setBannos(rsPropiedad.getInt("BANO_DPTO"));
					departamento.setEdificio("EDIFICIO");
					departamento.setDormitorios(rsPropiedad.getInt("DORMITORIO"));
					departamento.setTipoPropiedad(TipoPropiedad.DEPTO);
					propiedad = departamento;
					break;
				case "CASA":
					CasaVO casa = new CasaVO();
					casa.setBannos(rsPropiedad.getInt("BANO_CASA"));
					casa.setDormitorios(rsPropiedad.getInt("DORMITORIO_CASA"));
					casa.setConjunto(rsPropiedad.getString("CONJUNTO"));
					casa.setMetrosHabitables(rsPropiedad.getInt("METROSCUADRADOSHABITABLES"));
					casa.setTipoPropiedad(TipoPropiedad.CASA);
					propiedad = casa;
					break;
				default:
				}
				propiedad.setIdPropiedad(rsPropiedad.getInt("ID_PROPIEDAD"));
				ComunaVO comuna = new ComunaVO();
				comuna.setCodigoComuna(rsPropiedad.getInt("ID_COMUNA"));
				comuna.setCodigoRegion(rsPropiedad.getInt("ID_REGION"));
				comuna.setNombreComuna(rsPropiedad.getString("NOMBRE_COMUNA"));
				propiedad.setComuna(comuna);
				RegionVO region = new RegionVO();
				region.setCodigoRegion(rsPropiedad.getInt("ID_REGION"));
				region.setNombreRegion(rsPropiedad.getString("NOMBRE_REGION"));
				propiedad.setRegion(region);
				ConstructoraVO constructora= new ConstructoraVO();
				constructora.setIdConstructora(rsPropiedad.getInt("ID_CONSTRUCTORA"));
				constructora.setNombre(rsPropiedad.getString("NOMBRE_CONSTRUCTORA"));
				propiedad.setConstructora(constructora);
				propiedad.setDescripcion(rsPropiedad.getString("DESCRIPCION"));
				String tipoOperacion = rsPropiedad.getString("OPERACION");
				if(tipoOperacion.equalsIgnoreCase("ARRIENDO")){
					propiedad.setTipoOperacion(TipoOperacion.ARRIENDO);
				}else {
					propiedad.setTipoOperacion(TipoOperacion.VENTA);
				}
				propiedad.setDisponible(rsPropiedad.getString("DISPONIBLE").equalsIgnoreCase("S")?"Disponible":"No Disponible");
				propiedad.setProyecto(rsPropiedad.getString("PROYECTO"));
				propiedad.setMetrosCuadrados(rsPropiedad.getInt("METROS_CUADRADOS"));
				propiedad.setPrecioUF(rsPropiedad.getInt("PRECIO_UF"));
				propiedad.setDireccion(rsPropiedad.getString("DIRECCION"));
				PropietarioVO propietario = new PropietarioVO();
				propietario.setRut(rsPropiedad.getString("RUT_PROPIETARIO"));
				propiedad.setPropietario(propietario);
				Map<String,String> urlImagenes= new HashMap<String, String>();
				urlImagenes.put("principal", rsPropiedad.getString("URL_IMAGEN"));
				propiedad.setUrlImagenes(urlImagenes);
				propiedades.put(propiedad.getIdPropiedad(), propiedad);
			}
			
		}
		return propiedades;
	}

	private PropiedadVO rsIntoPropiedad(ResultSet rsPropiedad)
			throws SQLException {

		String tipoPropiedad = rsPropiedad.getString("tipo_propiedad");
		PropiedadVO propiedad = null;
		switch (tipoPropiedad) {
		case "BODEGA":
			BodegaVO bodega = new BodegaVO();
			bodega.setAltura(rsPropiedad.getDouble("altura"));
			bodega.setTipoPropiedad(TipoPropiedad.BODEGA);
			propiedad = bodega;
			break;
		case "OFICINA":
			OficinaVO oficina = new OficinaVO();
			oficina.setPatenteComercial(rsPropiedad.getInt("patentecomercial"));
			oficina.setTipoPropiedad(TipoPropiedad.OFICINA);
			propiedad = oficina;
			break;
		case "ESTACIONAMIENTO":
			EstacionamientoVO estacionamiento = new EstacionamientoVO();
			estacionamiento.setNivel(rsPropiedad.getInt("nivel"));
			estacionamiento.setTipoPropiedad(TipoPropiedad.ESTAC);
			propiedad = estacionamiento;
			break;
		case "DEPARTAMENTO":
			DepartamentoVO departamento = new DepartamentoVO();
			departamento.setBannos(rsPropiedad.getInt("bano"));
			departamento.setEdificio("Edificio");
			departamento.setDormitorios(rsPropiedad.getInt("dormitorio"));
			departamento.setTipoPropiedad(TipoPropiedad.DEPTO);
			propiedad = departamento;
			break;
		case "CASA":
			CasaVO casa = new CasaVO();
			casa.setBannos(rsPropiedad.getInt("bano"));
			casa.setDormitorios(rsPropiedad.getInt("dormitorio"));
			casa.setConjunto(rsPropiedad.getString("conjunto"));
			casa.setMetrosHabitables(rsPropiedad.getInt("metroscuadradoshabitables"));
			casa.setTipoPropiedad(TipoPropiedad.CASA);
			propiedad = casa;
			break;
		default:
		}
		propiedad.setIdPropiedad(rsPropiedad.getInt("ID_PROPIEDAD"));
		ComunaVO comuna = new ComunaVO();
		comuna.setCodigoComuna(rsPropiedad.getInt("ID_COMUNA"));
		comuna.setCodigoRegion(rsPropiedad.getInt("ID_REGION"));
		comuna.setNombreComuna(rsPropiedad.getString("nombre_comuna"));
		propiedad.setComuna(comuna);
		ConstructoraVO constructora= new ConstructoraVO();
		constructora.setIdConstructora(rsPropiedad.getInt("ID_CONSTRUCTORA"));
		constructora.setNombre(rsPropiedad.getString("NOMBRE_CONSTRUCTORA"));
		propiedad.setConstructora(constructora);
		String descripcion = rsPropiedad.getString("descripcion");
		String tipoOperacion = rsPropiedad.getString("operacion");
		if(tipoOperacion.equalsIgnoreCase("VENTA")){
			propiedad.setTipoOperacion(TipoOperacion.VENTA);
		}else if(tipoOperacion.equalsIgnoreCase("ARRIENDO")){
			propiedad.setTipoOperacion(TipoOperacion.ARRIENDO);
		}
		String disponible = rsPropiedad.getString("DISPONIBLE").equalsIgnoreCase("S")?"Disponible":"No Disponible";
		String proyecto = rsPropiedad.getString("PROYECTO");
		int metrosCuadrados = rsPropiedad.getInt("metros_cuadrados");
		int precioUF = rsPropiedad.getInt("precio_UF");
		String direccion = rsPropiedad.getString("DIRECCION");
		PropietarioVO propietario = new PropietarioVO();
		propietario.setRut(rsPropiedad.getString("rut_propietario"));
		propietario.setNombre(rsPropiedad.getString("nombre_propietario"));
		propietario.setPaterno(rsPropiedad.getString("paterno_propietario"));
		propietario.setMaterno(rsPropiedad.getString("materno_propietario"));
		propietario.setSexo(rsPropiedad.getString("sexo_propietario").equalsIgnoreCase("M")?"Mujer":"Hombre");
		propiedad.setPropietario(propietario);
		Map<String,String> urlImagenes= new HashMap<String, String>();
		urlImagenes.put("principal", rsPropiedad.getString("urlPrincipal"));
		return propiedad;
	
	}

	@Override
	public Map<Integer, PropiedadVO> fetchPropiedad(PropiedadVO propiedad) {
		long t1 = System.currentTimeMillis();
		Map<Integer, PropiedadVO> listadoPropiedades = null;
		Connection con = null;
		int idPropiedad = propiedad.getIdPropiedad();
		int idComuna = propiedad.getComuna().getCodigoComuna();
		int idRegion = propiedad.getComuna().getCodigoRegion();
		int  idConstructora = propiedad.getConstructora().getIdConstructora();
		int metrosCuadrados = propiedad.getMetrosCuadrados();
		int precioUF = propiedad.getPrecioUF();
		String tipoPropiedad = propiedad.getTipoPropiedad().toString();
		String descripcion = propiedad.getDescripcion();
		String tipoOperacion = propiedad.getTipoOperacion().toString();
		String disponible = propiedad.getDisponible().equals("Disponible")?"S":"N";
		String proyecto = propiedad.getProyecto();
		String direccion = propiedad.getDireccion();
		String rutPropietario = propiedad.getPropietario().getRut();	
		
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_PROPIEDADES.SP_FETCH_PROPIEDADES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setInt(4,idPropiedad);
			callableStatement.setInt(5,idComuna);
			callableStatement.setInt(6,idRegion);
			callableStatement.setInt(7,idConstructora);
			callableStatement.setInt(8,metrosCuadrados);
			callableStatement.setInt(9,precioUF);
			callableStatement.setString(10,tipoPropiedad);
			callableStatement.setString(11,descripcion);
			callableStatement.setString(12,tipoOperacion);
			callableStatement.setString(13,disponible);
			callableStatement.setString(14,proyecto);
			callableStatement.setString(15,direccion);
			callableStatement.setString(16,rutPropietario);
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
			System.out.println("[fetchPropiedades]TIEMPO EJECUCION "
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
	@Override
	public PropiedadVO fetchPropiedadById(PropiedadVO propiedad) {
		long t1 = System.currentTimeMillis();
		Map<Integer, PropiedadVO> listadoPropiedades = null;
		Connection con = null;
		int idPropiedad = propiedad.getIdPropiedad();
			
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_PROPIEDADES.SP_FETCH_BY_ID(?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setInt(4,idPropiedad);
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
			System.out.println("[fetchPropiedades]TIEMPO EJECUCION "
					+ (t2 - t1) + " miliseg");
			if (con != null) {
				try {
					ConnectionDAO.closeConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for(PropiedadVO pro : listadoPropiedades.values()){
			return pro;
		}
		return null;
	}


	@Override
	public PropiedadVO addPropiedad(PropiedadVO propiedad) {
		long t1 = System.currentTimeMillis();
		PropiedadVO encontrada = null;
		Connection con = null;
			int idPropiedad = propiedad.getIdPropiedad();
			int idComuna = propiedad.getComuna().getCodigoComuna();
			int idRegion = propiedad.getComuna().getCodigoRegion();
			int  idConstructora = propiedad.getConstructora().getIdConstructora();
			int metrosCuadrados = propiedad.getMetrosCuadrados();
			int precioUF = propiedad.getPrecioUF();
			String tipoPropiedad = propiedad.getTipoPropiedad().toString();
			String descripcion = propiedad.getDescripcion();
			String tipoOperacion = propiedad.getTipoOperacion().toString();
			String disponible = propiedad.getDisponible().equals("Disponible")?"S":"N";
			String proyecto = propiedad.getProyecto();
			String direccion = propiedad.getDireccion();
			String rutPropietario = propiedad.getPropietario().getRut();	

		try {
			String spAddPropiedadQuery = "{call IMMOBILIS.PKG_PROPIEDADES.SP_ADD_PROPIEDAD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(spAddPropiedadQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setInt(4,idPropiedad);
			callableStatement.setInt(5,idComuna);
			callableStatement.setInt(6,idRegion);
			callableStatement.setInt(7,idConstructora);
			callableStatement.setInt(8,metrosCuadrados);
			callableStatement.setInt(9,precioUF);
			callableStatement.setString(10,tipoPropiedad);
			callableStatement.setString(11,descripcion);
			callableStatement.setString(12,tipoOperacion);
			callableStatement.setString(13,disponible);
			callableStatement.setString(14,proyecto);
			callableStatement.setString(15,direccion);
			callableStatement.setString(16,rutPropietario);
			callableStatement.execute();
			BigDecimal dm = callableStatement.getBigDecimal(1);

			if (dm.intValue() == 0) {
				encontrada=propiedad;
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

		return encontrada;
	}

	@Override
	public PropiedadVO updatePropiedad(PropiedadVO propiedad) {
		long t1 = System.currentTimeMillis();
		Map<Integer, PropiedadVO> listadoPropiedades = null;
		Connection con = null;
		int idPropiedad = propiedad.getIdPropiedad();
		int idComuna = propiedad.getComuna().getCodigoComuna();
		int idRegion = propiedad.getComuna().getCodigoRegion();
		int  idConstructora = propiedad.getConstructora().getIdConstructora();
		int metrosCuadrados = propiedad.getMetrosCuadrados();
		int precioUF = propiedad.getPrecioUF();
		String tipoPropiedad = propiedad.getTipoPropiedad().toString();
		String descripcion = propiedad.getDescripcion();
		String tipoOperacion = propiedad.getTipoOperacion().toString();
		String disponible = propiedad.getDisponible().equals("Disponible")?"S":"N";
		String proyecto = propiedad.getProyecto();
		String direccion = propiedad.getDireccion();
		String rutPropietario = propiedad.getPropietario().getRut();	

		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_PROPIEDADES.SP_FILTRO_PROPIEDADES(?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setInt(4,idPropiedad);
			callableStatement.setInt(5,idComuna);
			callableStatement.setInt(6,idRegion);
			callableStatement.setInt(7,idConstructora);
			callableStatement.setInt(8,metrosCuadrados);
			callableStatement.setInt(9,precioUF);
			callableStatement.setString(10,tipoPropiedad);
			callableStatement.setString(11,descripcion);
			callableStatement.setString(12,tipoOperacion);
			callableStatement.setString(13,disponible);
			callableStatement.setString(14,proyecto);
			callableStatement.setString(15,direccion);
			callableStatement.setString(16,rutPropietario);
			callableStatement.execute();
			BigDecimal dm = callableStatement.getBigDecimal(1);

			if (dm.intValue() == 0) {
				ResultSet rsPropiedades = (ResultSet) callableStatement
						.getObject(3);
				propiedad = rsIntoPropiedad(rsPropiedades);

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
		return propiedad;
	}

}
