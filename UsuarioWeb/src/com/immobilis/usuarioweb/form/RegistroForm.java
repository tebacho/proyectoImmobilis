package com.immobilis.usuarioweb.form;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:28
 */
public class RegistroForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8182759479674760309L;
	private String nombre;
	private String paterno;
	private String materno;	
	private Date fechaNacimiento;
	private String rut;
	private String sexo;
	private String eMail;
	private String password;
	private String telefono;
	private String comuna;
	private String region;
	private String passIngreso;
	private String rutIngreso;
	private Map regiones;
	private Map comunas;
	private List comunasList;
	
	public List getComunasList() {
		return comunasList;
	}
	public void setComunasList(List comunasList) {
		this.comunasList = comunasList;
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Map getRegiones() {
		return regiones;
	}
	public void setRegiones(Map regiones) {
		this.regiones = regiones;
	}
	public Map getComunas() {
		return comunas;
	}
	public void setComunas(Map comunas) {
		this.comunas = comunas;
	}
	public String getPassIngreso() {
		return passIngreso;
	}
	public void setPassIngreso(String passIngreso) {
		this.passIngreso = passIngreso;
	}
	public String getRutIngreso() {
		return rutIngreso;
	}
	public void setRutIngreso(String rutIngreso) {
		this.rutIngreso = rutIngreso;
	}
	
	
}//end ActualizaInformacionPersonalForm