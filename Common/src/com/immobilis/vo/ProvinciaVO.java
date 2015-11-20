package com.immobilis.vo;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:38
 */
public class ProvinciaVO {


	private int codigoProvincia;
	private String nombreProvincia;
	private RegionVO region;
	
	public int getCodigoProvincia() {
		return codigoProvincia;
	}
	public void setCodigoProvincia(int codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	public RegionVO getRegion() {
		return region;
	}
	public void setRegion(RegionVO region) {
		this.region = region;
	}
	
	
}//end ZonaVO