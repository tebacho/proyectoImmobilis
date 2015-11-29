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
	private String proyecto ;
	private TipoPropiedad tipoPropiedad;
	private String direccion;
	private TipoOperacion tipoOperacion;
	private Map<String,String> urlImagenes;
	private ConstructoraVO constructora;
	private int metrosCuadrados;
	private int precioUF;
	
	
	
	public int getPrecioUF() {
		return precioUF;
	}

	public void setPrecioUF(int precioUF) {
		this.precioUF = precioUF;
	}

	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public ConstructoraVO getConstructora() {
		return constructora;
	}

	public void setConstructora(ConstructoraVO constructora) {
		this.constructora = constructora;
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

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto= proyecto;
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

	public String getNombreConstructora(){
		return constructora.getNombreConstructora();
	}

	public enum TipoOperacion{
		ARRIENDO,VENTA;
	}
	public enum TipoPropiedad{
		CASA, DEPTO, BODEGA, ESTAC, OFICINA;
	}
	
}//end PropiedadVO