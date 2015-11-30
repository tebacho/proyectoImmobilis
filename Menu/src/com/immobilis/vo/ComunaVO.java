package com.immobilis.vo;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:31
 */

public class ComunaVO {

	private String nombreComuna;
	private int codigoComuna;
	private int codigoRegion;
	
	
	public int getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(int codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public String getNombreComuna() {
		return nombreComuna;
	}

	public void setNombreComuna(String nombreComuna) {
		this.nombreComuna = nombreComuna;
	}

	public int getCodigoComuna() {
		return codigoComuna;
	}

	public void setCodigoComuna(int codigoComuna) {
		this.codigoComuna = codigoComuna;
	}

	
}//end ComunaVO