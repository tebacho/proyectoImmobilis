package com.immobilis.usuarioweb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.usuarioweb.form.LoginForm;
import com.immobilis.usuarioweb.manager.UsuarioWebManager;
import com.immobilis.vo.ClienteVO;

public class LoginAction extends DispatchAction {
	
	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("login");
	}
	
	public ActionForward login(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (form instanceof LoginForm) {
			LoginForm formulario = (LoginForm)form;
			UsuarioWebManager manager = new UsuarioWebManager();
			ClienteVO cliente= recibirParametros(request);
			cliente= manager.loginUsuario(cliente);
		}

		return mapping.findForward("login");
	}
	
	
	public ClienteVO recibirParametros(HttpServletRequest request){
		 ClienteVO cliente = new ClienteVO();
		 String rut = request.getParameter("");
		 cliente.setRut(rut);
		 String password= request.getParameter("");
		 cliente.setPassword(password);
		 return cliente;
	}
	
	
	
}
