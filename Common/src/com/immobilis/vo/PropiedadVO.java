package com.immobilis.vo;

import java.util.Map;

/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:36
 */
public abstract class PropiedadVO {
	
	private int idPropiedad;
	private ComunaVO comuna;
	private ConstructoraVO constructora;
	TipoPropiedad tipoPropiedad;
	private String descripcion;
	private TipoOperacion tipoOperacion;
	private String disponible;
	private String proyecto ;
	private int metrosCuadrados;
	private int precioUF;
	private String direccion;
	private PropietarioVO propietario;	
	private Map<String,String> urlImagenes;

	public int getIdPropiedad() {
		return idPropiedad;
	}
	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}
	public ComunaVO getComuna() {
		return comuna;
	}
	public void setComuna(ComunaVO comuna) {
		this.comuna = comuna;
	}
	public ConstructoraVO getConstructora() {
		return constructora;
	}
	public void setConstructora(ConstructoraVO constructora) {
		this.constructora = constructora;
	}
	public TipoPropiedad getTipoPropiedad() {
		return tipoPropiedad;
	}
	public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getDisponible() {
		return disponible;
	}
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}
	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	public int getPrecioUF() {
		return precioUF;
	}
	public void setPrecioUF(int precioUF) {
		this.precioUF = precioUF;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public PropietarioVO getPropietario() {
		return propietario;
	}
	public void setPropietario(PropietarioVO propietario) {
		this.propietario = propietario;
	}
	public Map<String, String> getUrlImagenes() {
		return urlImagenes;
	}
	public void setUrlImagenes(Map<String, String> urlImagenes) {
		this.urlImagenes = urlImagenes;
	}
	public enum TipoOperacion{
		ARRIENDO,VENTA;
	}
	public enum TipoPropiedad{
		CASA, DEPTO, BODEGA, ESTAC, OFICINA;
	}
	
}//end PropiedadVO