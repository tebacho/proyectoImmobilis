package com.immobilis.vo;

import java.util.Date;

/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:29
 */
public class ClienteVO extends PersonaVO {

	private String rut;
	private String password;
	private Date fechaIngreso;
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	

}//end ClienteVO