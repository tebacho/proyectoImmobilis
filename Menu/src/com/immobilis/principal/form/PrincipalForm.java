package com.immobilis.principal.form;

import java.util.Map;

import org.apache.struts.action.ActionForm;

public class PrincipalForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6881104790041239291L;
	
	private Map<String,String> tipoBusqueda;
	private Map<String,String> tipoPropiedad;
	
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
