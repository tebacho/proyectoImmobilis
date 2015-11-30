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
	private ReservaVO reserva;
	private int cuotasPendientes;
	private int montoPendiente;
	private double descuento;
	private EmpleadoVO empleado;
	private Date fechaContrato;
	private ServicioVO servicio;
	private SeguroVO seguro;
	
	
	
	public int getMontoPendiente() {
		return montoPendiente;
	}
	public void setMontoPendiente(int montoPendiente) {
		this.montoPendiente = montoPendiente;
	}
	public int getCuotasPendientes() {
		return cuotasPendientes;
	}
	public void setCuotasPendientes(int cuotasPendientes) {
		this.cuotasPendientes = cuotasPendientes;
	}
	public SeguroVO getSeguro() {
		return seguro;
	}
	public void setSeguro(SeguroVO seguro) {
		this.seguro = seguro;
	}
	public ServicioVO getServicio() {
		return servicio;
	}
	public void setServicio(ServicioVO servicio) {
		this.servicio = servicio;
	}
	public ReservaVO getReserva() {
		return reserva;
	}
	public void setReserva(ReservaVO reserva) {
		this.reserva = reserva;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
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
	
	public EmpleadoVO getEmpleado() {
		return empleado;
	}
	public void setEmpleado(EmpleadoVO empleado) {
		this.empleado = empleado;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	
}//end ContratoVO