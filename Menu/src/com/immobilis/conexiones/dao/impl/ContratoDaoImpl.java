package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.internal.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.ContratoDao;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.ContratoVO;
import com.immobilis.vo.PropiedadVO;

public class ContratoDaoImpl implements ContratoDao {

	@Override
	public Map<Integer, ContratoVO> ContratosActivos(ClienteVO cliente) {
		long t1 = System.currentTimeMillis();
		String rutCliente = cliente.getRut();
		BigDecimal estado = null;
		String msgError = null;
		Connection con = null;
		ResultSet rs = null;
		Map<Integer, ContratoVO> contratosVigentes = null;

		try {
			String cifSpContratosVigentesQuery = "{call IMMOBILIS.PKG_CONTRATOS.SP_CONTRATOS_ACTIVOS(?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con
					.prepareCall(cifSpContratosVigentesQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setString(4, rutCliente);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			contratosVigentes = rsToContracts(rs);

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
		return contratosVigentes;
	}

	private Map<Integer, ContratoVO> rsToContracts(ResultSet rs) throws SQLException {

		Map<Integer, ContratoVO> contratosVigentes = new HashMap<Integer, ContratoVO>();

		while (rs.next()) {
			PropiedadVO propiedad = null;
			new ContratoVO().getEmpleado();
			new ContratoVO().getFechaContrato();

		}
		return contratosVigentes;
	}

	@Override
	public ContratoVO grabarContrato(ContratoVO contrato) {
		long t1 = System.currentTimeMillis();
		int idReserva = contrato.getReserva().getIdReserva();
		double getDescuento = contrato.getDescuento();
		String rutCliente = contrato.getCliente().getRut();
		String rutEmpleado = contrato.getEmpleado().getRut();
		int idServicio = contrato.getServicio().getIdServicio();
		int idSeguro = contrato.getSeguro().getSeguro();
		int idPropiedad= contrato.getPropiedad().getIdPropiedad();
		String operacion = contrato.getPropiedad().getTipoOperacion().toString();
		Connection con = null;
		ResultSet rs = null;
		BigDecimal estado=new BigDecimal(1);
		String msgError;
		
		try {

			String cifSpGrabarContratoQuery = "{call IMMOBILIS.PKG_CONTRATO.SP_GRABAR_CONTRATO(?,?,?,?,?,?,?,?,?,?,?)}";
			con = ConnectionDAO.establecerConexion();
			CallableStatement callableStatement = con.prepareCall(cifSpGrabarContratoQuery);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.setInt(4, idReserva);
			callableStatement.setDouble(5, getDescuento);
			callableStatement.setString(6, rutCliente);
			callableStatement.setString(7, rutEmpleado);
			callableStatement.setInt(8, idServicio);
			callableStatement.setInt(9, idSeguro);
			callableStatement.setInt(10, idPropiedad);
			callableStatement.setString(11, operacion);
			callableStatement.execute();
			estado = callableStatement.getBigDecimal(1);
			msgError = callableStatement.getString(2);
			if(estado.intValue()!=0){
				contrato=null;
			}
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
		return contrato;
	}
	

}
