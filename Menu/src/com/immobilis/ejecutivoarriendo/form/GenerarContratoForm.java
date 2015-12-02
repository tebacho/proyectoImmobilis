package com.immobilis.ejecutivoarriendo.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.immobilis.vo.CasaVO;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ConvenioVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.ReservaVO;
import com.immobilis.vo.SeguroVO;
import com.immobilis.vo.ServicioVO;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:33
 */
public class GenerarContratoForm extends ActionForm{

private ReservaVO reserva;
private ClienteVO cliente;
private PropiedadVO propiedad;
private SeguroVO seguro;
private List<ServicioVO> listServicios;
private List<ReservaVO> listReserva;
private List<ConvenioVO> listConvenio;

public List<ConvenioVO> getListConvenio() {
	if(listConvenio==null)
		return new ArrayList<ConvenioVO>();
	return listConvenio;
}
public void setListConvenio(List<ConvenioVO> listConvenio) {
	this.listConvenio = listConvenio;
}
public List<ReservaVO> getListReserva() {
	if(listReserva==null){
		listReserva=new ArrayList<ReservaVO>();
	}
	return listReserva;
}
public void setListReserva(List<ReservaVO> listReserva) {
	this.listReserva = listReserva;
}
public ReservaVO getReserva() {
	return reserva;
}
public void setReserva(ReservaVO reserva) {
	this.reserva = reserva;
}
public ClienteVO getCliente() {
	if(cliente==null){
		cliente=new ClienteVO();
	}
	return cliente;
}
public void setCliente(ClienteVO cliente) {
	this.cliente = cliente;
}
public PropiedadVO getPropiedad() {
	if(propiedad==null){
		propiedad = new CasaVO(); 
	}
	return propiedad;
}
public void setPropiedad(PropiedadVO propiedad) {
	this.propiedad = propiedad;
}
public SeguroVO getSeguro() {
	if(seguro==null){
		seguro = new SeguroVO();
	}
	return seguro;
}
public void setSeguro(SeguroVO seguro) {
	this.seguro = seguro;
}
public List<ServicioVO> getListServicios() {
	if(listServicios==null){
		return new ArrayList<ServicioVO>();
	}
	return listServicios;
}
public void setListServicios(List<ServicioVO> listServicios) {
	this.listServicios = listServicios;
}


}