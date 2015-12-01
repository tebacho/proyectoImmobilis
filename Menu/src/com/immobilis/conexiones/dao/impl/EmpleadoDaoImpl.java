package com.immobilis.conexiones.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import com.immobilis.conexiones.connector.ConnectionDAO;
import com.immobilis.conexiones.dao.EmpleadoDao;
import com.immobilis.vo.EmpleadoVO;

public class EmpleadoDaoImpl implements EmpleadoDao {

	@Override
	public EmpleadoVO loginEmpleado(EmpleadoVO empleado) {
		long t1 = System.currentTimeMillis();
		String rut = empleado.getRut();
		String pass = empleado.getPassword();
		Connection con = null;
		EmpleadoVO empleadoEncontrado = null;
		try {
			String cifSpActEstadoMacQuery = "{call IMMOBILIS.PKG_EMPLEADO.SP_VALIDAR_EMPLEADO(?,?,?,?,?)}";
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
			empleadoEncontrado = rsIntoEmpleadoVO(rsUsuarioWeb);
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
		return empleadoEncontrado;
	}

	private EmpleadoVO rsIntoEmpleadoVO(ResultSet rsEmpleado)
			throws SQLException {
		EmpleadoVO empleado = null;
		if (rsEmpleado.next()) {
			{
				empleado = new EmpleadoVO();
				empleado.setRut(rsEmpleado.getString("RUT"));
				empleado.setNombre(rsEmpleado.getString("NOMBRE"));
				empleado.setPaterno(rsEmpleado.getString("PATERNO"));
				empleado.setMaterno(rsEmpleado.getString("MATERNO"));
				empleado.setTelefono(rsEmpleado.getString("TELEFONO"));
				empleado.setPassword(rsEmpleado.getString("PASSWORD"));				
			}
		}
		return empleado;
	}

}
