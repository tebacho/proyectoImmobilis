package com.immobilis.vo;

import java.util.Date;

public class ConversionVO {
	private int idConversion;
	private Date fechaCOnversion;
	private char monedaOrigen;
	private char monedaDestino;
	private double conversion;
	public int getIdConversion() {
		return idConversion;
	}
	public void setIdConversion(int idConversion) {
		this.idConversion = idConversion;
	}
	public Date getFechaCOnversion() {
		return fechaCOnversion;
	}
	public void setFechaCOnversion(Date fechaCOnversion) {
		this.fechaCOnversion = fechaCOnversion;
	}
	public char getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(char monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public char getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(char monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	public double getConversion() {
		return conversion;
	}
	public void setConversion(double conversion) {
		this.conversion = conversion;
	}
	
	
}
