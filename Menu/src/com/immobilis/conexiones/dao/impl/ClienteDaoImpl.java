package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.ClienteDao;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;

public class ClienteDaoImpl implements ClienteDao {

	@Override
	public ClienteVO addCliente(ClienteVO clienteVO) {

		long t1 = System.currentTimeMillis();
		String rut = clienteVO.getRut();
		String nombre = clienteVO.getNombre();
		String paterno = clienteVO.getPaterno();
		String materno = clienteVO.getMaterno();
		String sexo = clienteVO.getSexo();
		String direccion = "";
		java.sql.Date fechaNacimiento = new java.sql.Date(clienteVO.getFechaNacimiento().getTime());
		String telefono = clienteVO.getTelefono();
		String eMail = clienteVO.geteMail();
		int comuna = clienteVO.getComuna().getCodigoComuna();
		String password = clienteVO.getPassword();


		BigDecimal estado = new BigDecimal(0);

		Connection con = null;
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_CLIENTE.SP_INGRESA_NUEVO_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);	
			callableStatement.setString(4, rut);
			callableStatement.setString(5, nombre);
			callableStatement.setString(6, paterno);
			callableStatement.setString(7, materno);
			callableStatement.setString(8, sexo);
			callableStatement.setString(9, direccion);
			callableStatement.setDate(10, fechaNacimiento);
			callableStatement.setString(11, telefono);
			callableStatement.setString(12, eMail);
			callableStatement.setInt(13, comuna);
			callableStatement.setString(14, password);
			
			
			callableStatement.execute();
			String msgError = callableStatement.getString(2);
			estado = callableStatement.getBigDecimal(1);

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
		return clienteVO;
	}

	public ClienteVO actualizarCliente(ClienteVO clienteVO) {

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

		Connection con = null;
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_CLIENTE.SP_ACTUALIZA_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpActEstadoMacQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);	
			callableStatement.setString(4, rut);
			callableStatement.setString(5, nombre);
			callableStatement.setString(6, paterno);
			callableStatement.setString(7, materno);
			callableStatement.setString(8, sexo);
			callableStatement.setString(9, direccion);
			callableStatement.setDate(10, fechaNacimiento);
			callableStatement.setString(11, telefono);
			callableStatement.setString(12, eMail);
			callableStatement.setInt(13, comuna);
			callableStatement.setString(14, password);
			callableStatement.execute();
			String msg = callableStatement.getString(11);

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
			return null;
		}
		return clienteVO;
	}

	@Override
	public Map<String,ClienteVO> fetchClienteVO(ClienteVO clienteVO) {
		long t1 = System.currentTimeMillis();
		String rut = clienteVO.getRut();
		Connection con = null;
		Map<String,ClienteVO> clientes = null;
		try {
			String cifSpActEstadoMacQuery = "{call PKG_CLIENTE.SP_BUSCAR_USUARIO_WEB(?,?,?,?)}";
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
				ResultSet rsClientes = (ResultSet) callableStatement
						.getObject(4);
				clientes = rsIntoMapClienteVO(rsClientes);
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
		return clientes;
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
			String msg = callableStatement.getString(2);
			BigDecimal dm = callableStatement.getBigDecimal(1);

			
				ResultSet rsUsuarioWeb = (ResultSet) callableStatement
						.getObject(3);
			clienteEncontrado = rsIntoClienteVO(rsUsuarioWeb);
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} finally {
			long t2 = System.currentTimeMillis();
			System.out.println("[Login]TIEMPO EJECUCION "
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

	private ClienteVO rsIntoClienteVO(ResultSet rsUsuarioWeb)
			throws SQLException {
		ClienteVO cliente = null;
		if (rsUsuarioWeb.next()) {
			{
				cliente = new ClienteVO();
				ComunaVO comuna = new ComunaVO();
				comuna.setCodigoComuna(rsUsuarioWeb.getInt("ID_COMUNA"));
				comuna.setCodigoRegion(rsUsuarioWeb.getInt("ID_REGION"));
				cliente.setComuna(comuna);
				cliente.setRut(rsUsuarioWeb.getString("RUT"));
				cliente.setNombre(rsUsuarioWeb.getString("NOMBRE"));
				cliente.setPaterno(rsUsuarioWeb.getString("PATERNO"));
				cliente.setMaterno(rsUsuarioWeb.getString("MATERNO"));
				cliente.setSexo(rsUsuarioWeb.getString("SEXO"));
				cliente.setDireccion(rsUsuarioWeb.getString("DIRECCION"));
				cliente.setFechaNacimiento(rsUsuarioWeb.getDate("FECHA_NACIMIENTO"));
				cliente.seteMail(rsUsuarioWeb.getString("MAIL"));
				cliente.setFechaIngreso(rsUsuarioWeb.getDate("FECHA_INGRESO"));
				cliente.setTelefono(rsUsuarioWeb.getString("TELEFONO"));
				cliente.setPassword(rsUsuarioWeb.getString("PASSWORD"));				
			}
		}
		return cliente;
	}

	@Override
	public ClienteVO deleteCliente(ClienteVO clienteVO) {

		long t1 = System.currentTimeMillis();
		String rut = clienteVO.getRut();
		
		BigDecimal estado = new BigDecimal(0);
	
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
			return null;
		}
		return clienteVO;
	}
	private Map<String,ClienteVO> rsIntoMapClienteVO(ResultSet rsUsuarioWeb)
			throws SQLException {
		Map<String,ClienteVO> clientes = new HashMap<String, ClienteVO>();
		while (rsUsuarioWeb.next()) {
			{
				ClienteVO cliente = new ClienteVO();
				cliente = new ClienteVO();
				ComunaVO comuna = new ComunaVO();
				comuna.setCodigoComuna(rsUsuarioWeb.getInt("ID_COMUNA"));
				comuna.setCodigoRegion(rsUsuarioWeb.getInt("ID_REGION"));
				cliente.setComuna(comuna);
				cliente.setRut(rsUsuarioWeb.getString("RUT"));
				cliente.setNombre(rsUsuarioWeb.getString("NOMBRE"));
				cliente.setPaterno(rsUsuarioWeb.getString("PATERNO"));
				cliente.setMaterno(rsUsuarioWeb.getString("MATERNO"));
				cliente.setSexo(rsUsuarioWeb.getString("SEXO"));
				cliente.setDireccion(rsUsuarioWeb.getString("DIRECCION"));
				cliente.setFechaNacimiento(rsUsuarioWeb.getDate("FECHA_NACIMIENTO"));
				cliente.seteMail(rsUsuarioWeb.getString("MAIL"));
				cliente.setFechaIngreso(rsUsuarioWeb.getDate("FECHA_INGRESO"));
				cliente.setTelefono(rsUsuarioWeb.getString("TELEFONO"));
				cliente.setPassword(rsUsuarioWeb.getString("PASSWORD"));		
			}
		}
		return clientes;
	}

}
