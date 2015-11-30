package com.immobilis.usuarioweb.form;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.ConvenioVO;
import com.immobilis.vo.RegionVO;

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
	private String passIngreso;
	private String rutIngreso;
	private List<RegionVO> listRegiones;
	private List<ComunaVO> listComunas;
	private String convenio;
	private int regionSelect;
	private int comunaSelect;
	private Map convenios;
	
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
	public List<RegionVO> getListRegiones() {
		if(listRegiones==null)
			listRegiones= new ArrayList<RegionVO>();
		return listRegiones;
	}
	public void setListRegiones(List<RegionVO> listRegiones) {
		this.listRegiones = listRegiones;
	}
	public List<ComunaVO> getListComunas() {
		if(listComunas==null)
			listComunas=new ArrayList<ComunaVO>();
		return listComunas;
	}
	public void setListComunas(List<ComunaVO> listComunas) {
		this.listComunas = listComunas;
	}
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	public int getRegionSelect() {
		return regionSelect;
	}
	public void setRegionSelect(int regionSelect) {
		this.regionSelect = regionSelect;
	}
	public int getComunaSelect() {
		return comunaSelect;
	}
	public void setComunaSelect(int comunaSelect) {
		this.comunaSelect = comunaSelect;
	}
	public Map getConvenios() {
		return convenios;
	}
	public void setConvenios(Map convenios) {
		this.convenios = convenios;
	}
	
	
	
	
}