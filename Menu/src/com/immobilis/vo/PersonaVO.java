package com.immobilis.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class PersonaVO {

	private String rut;
	private String nombre;
	private String paterno;
	private String materno;
	private String sexo;
	private String direccion;
	private Date fechaNacimiento;
	private String telefono;
	private String eMail;
	private ComunaVO comuna;

	private Date fechaIngreso;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public ComunaVO getComuna() {
		return comuna;
	}

	public void setComuna(ComunaVO comuna) {
		this.comuna = comuna;
	}

	public String getFechaNacimientoString() {
		if (fechaNacimiento != null) {
			DateFormat df = new SimpleDateFormat("yyyy-DD-mm");
			return df.format(fechaNacimiento);
		} else
			return "";
	}

}
