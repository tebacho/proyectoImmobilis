package com.immobilis.usuarioweb.form;

import java.sql.Date;
import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.immobilis.vo.ContratoVO;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:28
 */
public class ContratosActivosForm extends ActionForm {

	private Map<Integer,ContratoVO> contratos;

	public Map<Integer, ContratoVO> getContratos() {
		return contratos;
	}

	public void setContratos(Map<Integer, ContratoVO> contratos) {
		this.contratos = contratos;
	}
	
}//end ActualizaInformacionPersonalForm