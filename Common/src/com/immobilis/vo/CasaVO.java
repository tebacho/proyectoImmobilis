package com.immobilis.vo;

/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:28
 */
public class CasaVO extends PropiedadVO {

	private String conjunto;
	private int metrosHabitables;
	private int bannos;
	private int dormitorios;
	public String getConjunto() {
		return conjunto;
	}
	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}
	public int getMetrosHabitables() {
		return metrosHabitables;
	}
	public void setMetrosHabitables(int metrosHabitables) {
		this.metrosHabitables = metrosHabitables;
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
	
}//end CasaVO