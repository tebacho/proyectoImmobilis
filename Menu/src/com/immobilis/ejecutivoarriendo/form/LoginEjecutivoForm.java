package com.immobilis.ejecutivoarriendo.form;

import org.apache.struts.action.ActionForm;

import com.immobilis.vo.ClienteVO;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:28
 */
public class LoginEjecutivoForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8533308518165349116L;
	private ClienteVO cliente;
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	
}