package com.immobilis.vo;

import java.util.Map;

/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:36
 */
public abstract class PropiedadVO {
	
	private String idPropiedad;
	private PropietarioVO propietario;
	private String descripcion;
	private String identificacion ;
	private TipoPropiedad tipoPropiedad;
	private DireccionVO direccion;
	private TipoOperacion tipoOperacion;
	private Map<String,String> urlImagenes;
	private InmobiliariaVO inmobiliaria;
	
	
	public InmobiliariaVO getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(InmobiliariaVO inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(String idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public void setUrlImagenes(Map<String, String> urlImagenes) {
		this.urlImagenes = urlImagenes;
	}

	public Map<String, String> getUrlImagenes() {
		return urlImagenes;
	}

	public void setUrlDetalles(Map<String, String> urlImagenes) {
		this.urlImagenes = urlImagenes;
	}

	public PropietarioVO getPropietario() {
		return propietario;
	}

	public void setPropietario(PropietarioVO propietario) {
		this.propietario = propietario;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public DireccionVO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionVO direccion) {
		this.direccion = direccion;
	}
	
	public TipoPropiedad getTipoPropiedad() {
		return tipoPropiedad;
	}

	public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}
	
	
	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}



	public enum TipoOperacion{
		ARRIENDO,VENTA;
	}
	public enum TipoPropiedad{
		CASA, DEPARTAMENTO, BODEGA, ESTACIONAMIENTO, OFICINA;
	}
	
}//end PropiedadVO