package com.immobilis.vo;

import java.util.Date;

public class ReservaVO {

	private String idReserva;
	private String rutUsuario;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String numeroContacto;
	private String mailContacto;
	private Date fechaCreacion;
	private PropiedadVO propiedad;

	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getRutUsuario() {
		return rutUsuario;
	}
	public void setRutUsuario(String rutUsuario) {
		this.rutUsuario = rutUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
	public String getNumeroContacto() {
		return numeroContacto;
	}
	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}
	public String getMailContacto() {
		return mailContacto;
	}
	public void setMailContacto(String mailContacto) {
		this.mailContacto = mailContacto;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public PropiedadVO getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(PropiedadVO propiedad) {
		this.propiedad = propiedad;
	}
	
	
}
