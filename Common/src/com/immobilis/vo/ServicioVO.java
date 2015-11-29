package com.immobilis.vo;

import java.util.Date;

public class ServicioVO {

	int idServicio;
	String descripcion;
	Date fechaVIgencia;
	int valorServicio;
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaVIgencia() {
		return fechaVIgencia;
	}
	public void setFechaVIgencia(Date fechaVIgencia) {
		this.fechaVIgencia = fechaVIgencia;
	}
	public int getValorServicio() {
		return valorServicio;
	}
	public void setValorServicio(int valorServicio) {
		this.valorServicio = valorServicio;
	}
	
	
}
