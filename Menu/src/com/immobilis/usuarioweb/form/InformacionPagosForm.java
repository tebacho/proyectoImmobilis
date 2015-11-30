package com.immobilis.usuarioweb.form;

import java.sql.Date;
import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.immobilis.vo.PagoVO;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:28
 */
public class InformacionPagosForm extends ActionForm {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1181637411853712141L;
	Map <Integer, PagoVO> pagos;
	public Map<Integer, PagoVO> getPagos() {
		return pagos;
	}
	public void setPagos(Map<Integer, PagoVO> pagos) {
		this.pagos = pagos;
	}
	
	
	
	
	
}//end ActualizaInformacionPersonalForm