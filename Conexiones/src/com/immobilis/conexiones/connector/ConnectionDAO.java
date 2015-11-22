package com.immobilis.conexiones.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class ConnectionDAO {

	private static Connection con = null;
	//private static String BD_NO_TURBINE = "jdbc:oracle:thin:@10.110.1.54:1523:ORALDES1";
	private static String BD_NO_TURBINE = "jdbc:oracle:thin:@localhost:1521:xe";
	public static Map<String, Object> getConection() throws Exception {
//		boolean turbine = getUseTurbine();
		Map<String, Object> resp = new HashMap<String, Object>();
//		if (con != null) {
//			resp.put("no.turbine", con);
//			return resp;
//		} else {
//			if (false) {
//
//				DBConnection dbconn = null;
//				dbconn = TurbineDB.getConnection(BD_TURBINE);
//				// con = dbconn.getConnection();
//				resp.put("turbine", dbconn);
//				return resp;
//			} else {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(BD_NO_TURBINE, "immobilis",
						"immobilis");
				resp.put("no.turbine", con);
				return resp;
//			}
//		}

	}

	public static Connection establecerConexion() {
		try {
//			DBConnection dbconn = null;
			Map<String, Object> cxs = ConnectionDAO.getConection();

//			if (cxs.containsKey("turbine")) {
//				dbconn = (DBConnection) cxs.get("turbine");
//				con = dbconn.getConnection();
//			} else if (cxs.containsKey("no.turbine")) {
				con = (Connection) cxs.get("no.turbine");
//			}
			return con;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	private static boolean getUseTurbine() {
//	/*	Logger logger = new Logger();
//		// logger.log("----- getUseTurbine -------");
//		ResourceBundle rb = ResourceBundle
//				.getBundle("com.bice.seguimientogarantia.util.paramSistema");
//		// logger.log("----- "+rb+" -------");
//		boolean turb = false;
//		if (rb != null) {
//			String turbine = rb
//					.getString("com.bice.seguimientogarantia.conexion.turbine");
//			if (turbine.equalsIgnoreCase("true")) {
//				turb = true;
//			}
//			// logger.log("-----Turbine["+turbine+"]------");
//			logger.log("-----TurbineBool[" + turb + "]------");
//		}
//
//		return turb;*/
//	 return true; 
//	}

	public static void closeConnection(Connection conn)
			throws Exception {
		//Logger logger = new Logger();
//		boolean turbine = getUseTurbine();
//		Logger.log("-----Close Conecction : Turbine[" + turbine + "]------");

//		if (turbine) {
//			if (dbconn != null) {
//				// logger.log("-----dbconn ditinto a nulo------");
//				TurbineDB.releaseConnection(dbconn);
//			}
//		} else {
//			if (conn != null) {
//				// logger.log("-----conn ditinto a nulo------");
				conn.close();
//			}
//		}

		conn = null;
		con = null;
	}
}
