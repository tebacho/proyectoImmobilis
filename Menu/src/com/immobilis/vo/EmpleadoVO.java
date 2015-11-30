package com.immobilis.vo;

import java.util.Date;

/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:33
 */
public class EmpleadoVO extends PersonaVO{

	private int rolEmpleado;
	private Date fechaContrato;
	
	public int getRolEmpleado() {
		return rolEmpleado;
	}
	public void setRolEmpleado(int rolEmpleado) {
		this.rolEmpleado = rolEmpleado;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	
}//end EjecutivoVO