package com.immobilis.usuarioweb.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.usuarioweb.form.ContratosActivosForm;
import com.immobilis.usuarioweb.manager.ContratosActivosManager;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ContratoVO;

public class ContratosActivosAction extends DispatchAction{

	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(form instanceof ContratosActivosForm){
			ContratosActivosForm formulario = (ContratosActivosForm)form;
			ClienteVO cliente = clienteFromSession(request);
			ContratosActivosManager manager = new ContratosActivosManager();
//			Map<Integer,ContratoVO> contratos = manager.buscarContratosActivos(cliente);
//			formulario.setContratos(contratos);
			formulario.setContratos(new HashMap<Integer,ContratoVO>());
		}
		return mapping.findForward("contratosActivos");
	}
	public ClienteVO clienteFromSession(HttpServletRequest request){
		ClienteVO cliente = new ClienteVO();
		String idCliente = (String)request.getSession().getAttribute("rutUsuario");
		cliente.setRut(idCliente);
		return cliente;
	}
}
