package com.immobilis.vo;

/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:32
 */
public class DepartamentoVO extends PropiedadVO {

	private String edificio;
	private int bannos;
	private int dormitorios;

	
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	public int getBannos() {
		return bannos;
	}
	public void setBannos(int bannos) {
		this.bannos = bannos;
	}
	public int getDormitorios() {
		return dormitorios;
	}
	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}
	
	
	
}//end DepartamentoVO