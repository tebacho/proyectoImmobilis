package com.immobilis.vo;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:32
 */
public class DireccionVO {
	
	private int id;
	private ComunaVO comuna;
	private int numeracion;
	private String calle;
	private int piso;

	public ComunaVO getComuna() {
		return comuna;
	}
	public void setComuna(ComunaVO comuna) {
		this.comuna = comuna;
	}
	public int getNumeracion() {
		return numeracion;
	}
	public void setNumeracion(int numeracion) {
		this.numeracion = numeracion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String toString(){
		return getCalle()+" n° "+ getNumeracion()+" piso"+getPiso()+" , "+getComuna().getNombreComuna();
	}
	
	
	
}//end DireccionVO