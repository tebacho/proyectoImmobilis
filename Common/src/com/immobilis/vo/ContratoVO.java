package com.immobilis.vo;

import java.util.Date;


/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:31
 */
public class ContratoVO {

	private int numeroContrato;
	private ClienteVO cliente;
	private PropiedadVO propiedad;
	private EjecutivoVO ejecutivo;
	private Date fechaContrato;
	
	public int getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	public PropiedadVO getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(PropiedadVO propiedad) {
		this.propiedad = propiedad;
	}
	public EjecutivoVO getEjecutivo() {
		return ejecutivo;
	}
	public void setEjecutivo(EjecutivoVO ejecutivo) {
		this.ejecutivo = ejecutivo;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	
	

}//end ContratoVO