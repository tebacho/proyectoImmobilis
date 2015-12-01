package com.immobilis.usuarioweb.form;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.RegionVO;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:28
 */
public class ActualizarInformacionForm extends ActionForm {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7845965486514105909L;
	private ClienteVO cliente;
	private List<RegionVO> listRegiones;
	private List<ComunaVO> listComunas;
	private Map<String,String> listSexo;

	
	public Map<String, String> getListSexo() {
		return listSexo;
	}

	public void setListSexo(Map<String, String> listSexo) {
		this.listSexo = listSexo;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public List<RegionVO> getListRegiones() {
		return listRegiones;
	}

	public void setListRegiones(List<RegionVO> listRegiones) {
		this.listRegiones = listRegiones;
	}

	public List<ComunaVO> getListComunas() {
		return listComunas;
	}

	public void setListComunas(List<ComunaVO> listComunas) {
		this.listComunas = listComunas;
	}

	public void llenarDatos(ClienteVO cliente){
		try{
			ComunaVO comuna = cliente.getComuna();
			RegionVO region = null;
			int codigoComuna = comuna.getCodigoComuna();
			int codigoRegion = comuna.getCodigoRegion();
			for (ComunaVO com: listComunas){
				if(com.getCodigoComuna()==codigoComuna){
					comuna=listComunas.remove(listComunas.indexOf(com));
					break;
				}
			}
			for (RegionVO reg : listRegiones){
				if(reg.getCodigoRegion()==codigoRegion){
					region=listRegiones.remove(listRegiones.indexOf(reg));
					break;
				}
			}
			listComunas.add(0, comuna);
			listRegiones.add(0, region);
			if(cliente.getSexo().equalsIgnoreCase("H")){
				listSexo.put("H","HOMBRE");
				listSexo.put("M","MUJER");
			}else{
				listSexo.put("M","MUJER");
				listSexo.put("H","HOMBRE");
			}

		}catch(Exception ex){
			
		}
	}
	

}//end ActualizaInformacionPersonalForm