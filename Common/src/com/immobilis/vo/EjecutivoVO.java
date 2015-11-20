package com.immobilis.vo;

import java.util.Date;

/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:33
 */
public class EjecutivoVO extends PersonaVO{

	private int rolEmpleado;
	private Date fechaContrato;
	private ProvinciaVO zona;
	
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
	public ProvinciaVO getZona() {
		return zona;
	}
	public void setZona(ProvinciaVO zona) {
		this.zona = zona;
	}
	
	
	
}//end EjecutivoVO