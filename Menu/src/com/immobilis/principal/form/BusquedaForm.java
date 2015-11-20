package com.immobilis.principal.form;

import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.immobilis.vo.PropiedadVO;

public class BusquedaForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4898282656252301496L;
	
	Map<String,PropiedadVO> propiedades;
	private Map<String,String> tipoBusqueda;
	private Map<String,String> tipoPropiedad;
	String filtroTipoOperacion;
	String filtroTipoPropiedadBuscada;
	String filtroUbicacion;
	
	public Map<String, PropiedadVO> getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(Map<String, PropiedadVO> propiedades) {
		this.propiedades = propiedades;
	}
	public String getFiltroTipoOperacion() {
		return filtroTipoOperacion;
	}
	public void setFiltroTipoOperacion(String filtroTipoOperacion) {
		this.filtroTipoOperacion = filtroTipoOperacion;
	}
	public String getFiltroTipoPropiedadBuscada() {
		return filtroTipoPropiedadBuscada;
	}
	public void setFiltroTipoPropiedadBuscada(String filtroTipoPropiedadBuscada) {
		this.filtroTipoPropiedadBuscada = filtroTipoPropiedadBuscada;
	}
	public String getFiltroUbicacion() {
		return filtroUbicacion;
	}
	public void setFiltroUbicacion(String filtroUbicacion) {
		this.filtroUbicacion = filtroUbicacion;
	}
	public Map<String, String> getTipoBusqueda() {
		return tipoBusqueda;
	}
	public void setTipoBusqueda(Map<String, String> tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}
	public Map<String, String> getTipoPropiedad() {
		return tipoPropiedad;
	}
	public void setTipoPropiedad(Map<String, String> tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}
	
	
}
