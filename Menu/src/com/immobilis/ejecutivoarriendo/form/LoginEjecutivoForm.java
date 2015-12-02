package com.immobilis.ejecutivoarriendo.form;

import org.apache.struts.action.ActionForm;

import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.EmpleadoVO;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:28
 */
public class LoginEjecutivoForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4865726777173726304L;
	/**
	 * 
	 */

	private EmpleadoVO ejecutivo;
	public EmpleadoVO getEjecutivo() {
		return ejecutivo;
	}
	public void setEjecutivo(EmpleadoVO ejecutivo) {
		this.ejecutivo = ejecutivo;
	}
	
	
}