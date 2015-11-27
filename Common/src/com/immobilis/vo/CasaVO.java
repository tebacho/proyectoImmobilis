package com.immobilis.vo;

/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:28
 */
public class CasaVO extends ViviendaVO {

	private String conjunto;
	private int metroshabitables;
	private int metrosPatio;

	public String getConjunto() {
		return conjunto;
	}
	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}
	public int getMetroshabitables() {
		return metroshabitables;
	}
	public void setMetroshabitables(int metroshabitables) {
		this.metroshabitables = metroshabitables;
	}
	public int getMetrosPatio() {
		return metrosPatio;
	}
	public void setMetrosPatio(int metrosPatio) {
		this.metrosPatio = metrosPatio;
	}
	public String getMetrosTotal(){
		return getMetroshabitables()+"/"+getMetrosCuadrados();
	}
	
	
}//end CasaVO