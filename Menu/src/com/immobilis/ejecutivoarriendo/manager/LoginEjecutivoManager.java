package com.immobilis.ejecutivoarriendo.manager;

import com.immobilis.conexiones.dao.EmpleadoDao;
import com.immobilis.conexiones.dao.impl.EmpleadoDaoImpl;
import com.immobilis.vo.EmpleadoVO;

public class LoginEjecutivoManager  {

	public EmpleadoVO loginEmpleado(EmpleadoVO empleado){
		EmpleadoDao dao = new EmpleadoDaoImpl();
		return dao.loginEmpleado(empleado);
		
	}
	
}
