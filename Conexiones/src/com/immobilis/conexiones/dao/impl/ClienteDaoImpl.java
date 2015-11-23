package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.ClienteDao;
import com.immobilis.vo.ClienteVO;

public class ClienteDaoImpl implements ClienteDao {

	@Override
	public String addCliente(ClienteVO clienteVO) {

		long t1 = System.currentTimeMillis();
		String rut = clienteVO.getRut();
		String nombre = clienteVO.getNombre();
		String paterno = clienteVO.getPaterno();
		String materno = clienteVO.getMaterno();
		String sexo = clienteVO.getSexo();
		String direccion = clienteVO.getDireccion();
		java.sql.Date fechaNacimiento = null;
		String telefono = clienteVO.getTelefono();
		String eMail = clienteVO.geteMail();
		int comuna = clienteVO.getComuna().getCodigoComuna();
		String password = clienteVO.getPassword();

		BigDecimal estado = new BigDecimal(0);
		final String RESULTADO_CORRECTO = "Se ha creado correctamente la cuenta";
		final String RESULTADO_INCORRECTO = "Ha ocurrido un problema al crear la cuenta, por favor inténtelo mas tarde";

		Connection con = null;
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_CLIENTE.SP_INGRESA_NUEVO_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);

			callableStatement.setString(1, rut);
			callableStatement.setString(2, nombre);
			callableStatement.setString(3, paterno);
			callableStatement.setString(4, materno);
			callableStatement.setString(5, sexo);
			callableStatement.setString(6, direccion);
			callableStatement.setDate(7, fechaNacimiento);
			callableStatement.setString(8, telefono);
			callableStatement.setString(9, eMail);
			callableStatement.setInt(10, comuna);
			callableStatement.setString(11, password);

			callableStatement.registerOutParameter(12, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(13, java.sql.Types.VARCHAR);
			callableStatement.execute();
			String msgError = callableStatement.getString(13);
			estado = callableStatement.getBigDecimal(12);

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
		if (estado.intValue() == 0) {
			return RESULTADO_CORRECTO;
		}
		return RESULTADO_INCORRECTO;

	}

	public String actualizarCliente(ClienteVO clienteVO) {

		long t1 = System.currentTimeMillis();
		String rut = clienteVO.getRut();
		String nombre = clienteVO.getNombre();
		String paterno = clienteVO.getPaterno();
		String materno = clienteVO.getMaterno();
		String sexo = clienteVO.getSexo();
		String direccion = clienteVO.getDireccion();
		Date fechaNacimiento = (java.sql.Date) clienteVO.getFechaNacimiento();
		String telefono = clienteVO.getTelefono();
		String eMail = clienteVO.geteMail();
		int comuna = clienteVO.getComuna().getCodigoComuna();
		String password = clienteVO.getPassword();

		BigDecimal estado = new BigDecimal(0);
		final String RESULTADO_CORRECTO = "Se ha creado correctamente la cuenta";
		final String RESULTADO_INCORRECTO = "Ha ocurrido un problema al crear la cuenta, por favor inténtelo mas tarde";

		Connection con = null;
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_USUARIOWEB.SP_ACTUALIZA_USUARIO_WEB(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);
			callableStatement.setString(1, rut);
			callableStatement.setString(2, nombre);
			callableStatement.setString(3, paterno);
			callableStatement.setString(4, materno);
			callableStatement.setString(5, sexo);
			callableStatement.setString(6, direccion);
			callableStatement.setDate(7, fechaNacimiento);
			callableStatement.setString(8, telefono);
			callableStatement.setString(9, eMail);
			callableStatement.setInt(10, comuna);
			callableStatement.setString(11, password);
			callableStatement.registerOutParameter(12, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(13, java.sql.Types.VARCHAR);

			callableStatement.execute();
			String msg = callableStatement.getString(11);
			estado = callableStatement.getBigDecimal(10);

		} catch (SQLException sqle) {

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
		if (estado.intValue() == 0) {
			return RESULTADO_CORRECTO;
		}
		return RESULTADO_INCORRECTO;

	}

	public ClienteVO fetchClienteVO(ClienteVO clienteVO) {
		long t1 = System.currentTimeMillis();
		String rut = clienteVO.getRut();
		Connection con = null;
		ClienteVO clienteEncontrado = null;
		try {
			String cifSpActEstadoMacQuery = "{call PKG_USUARIOWEB.SP_BUSCAR_USUARIO_WEB(?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setString(4, rut);
			
			callableStatement.execute();
			String msg = callableStatement.getString(3);
			BigDecimal dm = callableStatement.getBigDecimal(2);

			if (dm.intValue() == 0) {
				ResultSet rsUsuarioWeb = (ResultSet) callableStatement
						.getObject(4);
				clienteEncontrado = lineIntoClienteVO(rsUsuarioWeb);
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
		return clienteEncontrado;
	}

	@Override
	public ClienteVO loginCliente(ClienteVO clienteVO) {
		long t1 = System.currentTimeMillis();
		String rut = clienteVO.getRut();
		String pass = clienteVO.getPassword();
		Connection con = null;
		ClienteVO clienteEncontrado = null;
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_CLIENTE.SP_VALIDAR_CLIENTE(?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setString(4, rut);
			callableStatement.setString(5, pass);
			
			callableStatement.execute();
			String msg = callableStatement.getString(4);
			BigDecimal dm = callableStatement.getBigDecimal(3);

			if (dm.intValue() == 0) {
				ResultSet rsUsuarioWeb = (ResultSet) callableStatement
						.getObject(5);
				clienteEncontrado = lineIntoClienteVO(rsUsuarioWeb);
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
		return clienteEncontrado;
	}

	private ClienteVO lineIntoClienteVO(ResultSet rsUsuarioWeb)
			throws SQLException {
		ClienteVO usuarioWeb = null;
		if (rsUsuarioWeb.next()) {
			{
				usuarioWeb = new ClienteVO();
				usuarioWeb.setNombre(rsUsuarioWeb.getString("nombre"));
			}
		}
		return usuarioWeb;
	}

	@Override
	public String deleteCliente(ClienteVO clienteVO) {

		long t1 = System.currentTimeMillis();
		String rut = clienteVO.getRut();
		
		BigDecimal estado = new BigDecimal(0);
		final String RESULTADO_CORRECTO = "Se ha creado Eliminado la cuenta";
		final String RESULTADO_INCORRECTO = "Ha ocurrido un problema al eliminar la cuenta, por favor inténtelo mas tarde";

		Connection con = null;
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_CLIENTE.SP_DELETE_CLIENTE(?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.setString(3, rut);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			String msgError = callableStatement.getString(2);
			

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
		if (estado.intValue() == 0) {
			return RESULTADO_CORRECTO;
		}
		return RESULTADO_INCORRECTO;
	}

}
