package com.immobilis.principal.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.RegionVO;
import com.immobilis.vo.SeguroVO;

public class FormularioReservaForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 36707113462283808L;
	
	private ClienteVO cliente;
	private Date fechaCreacion;
	private PropiedadVO propiedad;
	private List<RegionVO> listRegiones;
	private RegionVO regionSelect; 
	private List<ComunaVO> listComunas;
	private ComunaVO comunaSelect;
	private List<SeguroVO> listSeguros;
	
	
	public List<SeguroVO> getListSeguros() {
		return listSeguros;
	}
	public void setListSeguros(List<SeguroVO> listSeguros) {
		this.listSeguros = listSeguros;
	}
	public List<ComunaVO> getListComunas() {
		if(listComunas==null){
			listComunas=new ArrayList<ComunaVO>();
		}
		return listComunas;
	}
	public void setListComunas(List<ComunaVO> listComunas) {
		this.listComunas = listComunas;
	}
	public ComunaVO getComunaSelect() {
		if(comunaSelect == null){
			comunaSelect= new ComunaVO();
		}
		return comunaSelect;
	}
	public void setComunaSelect(ComunaVO comunaSelect) {
		this.comunaSelect = comunaSelect;
	}
	public List<RegionVO> getListRegiones() {
		if(listRegiones==null){
			listRegiones=new ArrayList<RegionVO>();
		}
		return listRegiones;
	}
	public void setListRegiones(List<RegionVO> listRegiones) {
		this.listRegiones = listRegiones;
	}
	public RegionVO getRegionSelect() {
		if(regionSelect==null){
			regionSelect=new RegionVO();
		}
		return regionSelect;
	}
	public void setRegionSelect(RegionVO regionSelect) {
		this.regionSelect = regionSelect;
	}
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public PropiedadVO getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(PropiedadVO propiedad) {
		this.propiedad = propiedad;
	}
	
	
	
}
