package com.immobilis.vo;

import java.util.Date;

public class PagoVO {
	private String estadoPago;
	private Date fechaVencimiento;
	private int idVencimiento;
	private int idContrato;
	private double montoCuota;
	private int numeroCuota;
	private ConversionVO conversion;
	private double Comision;
	private Date fechaPagada;
	public String getEstadoPago() {
		return estadoPago;
	}
	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public int getIdVencimiento() {
		return idVencimiento;
	}
	public void setIdVencimiento(int idVencimiento) {
		this.idVencimiento = idVencimiento;
	}
	public int getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}
	public double getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(double montoCuota) {
		this.montoCuota = montoCuota;
	}
	public int getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	public ConversionVO getConversion() {
		return conversion;
	}
	public void setConversion(ConversionVO conversion) {
		this.conversion = conversion;
	}
	public double getComision() {
		return Comision;
	}
	public void setComision(double comision) {
		Comision = comision;
	}
	public Date getFechaPagada() {
		return fechaPagada;
	}
	public void setFechaPagada(Date fechaPagada) {
		this.fechaPagada = fechaPagada;
	}
	
	
	
}
