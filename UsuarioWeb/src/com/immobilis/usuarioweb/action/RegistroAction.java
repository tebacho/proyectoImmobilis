package com.immobilis.usuarioweb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.usuarioweb.form.RegistroForm;
import com.immobilis.usuarioweb.manager.UsuarioWebManager;
import com.immobilis.vo.ClienteVO;

public class RegistroAction extends DispatchAction {
	
	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("registroUsuario");
	}
	
	public ActionForward registroUsuario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String result="";
		if (form instanceof RegistroForm) {
			RegistroForm formulario = (RegistroForm)form;
			UsuarioWebManager manager = new UsuarioWebManager();
			ClienteVO cliente= recibirParametros(request);
			result= manager.registrarCliente(cliente);
			
		}

		return mapping.findForward("success");
	}
	public ClienteVO recibirParametros(HttpServletRequest request){
		 ClienteVO cliente = new ClienteVO();
		 String nombre = request.getParameter("");
		 cliente.setNombre(nombre);
		 String paterno= request.getParameter("");
		 cliente.setPaterno(paterno);
		 String materno= request.getParameter("");
		 cliente.setMaterno(materno);
//		 Date fechaNacimiento= Date.parse(request.getParameter(""));
		 String rut= request.getParameter("");
		 cliente.setRut(rut);
		 String sexo= request.getParameter("");
		 cliente.setSexo(sexo);
		 String eMail= request.getParameter("");
		 cliente.seteMail(eMail);
		 String password= request.getParameter("");
		 cliente.setPassword(password);
		 String telefono= request.getParameter("");
		 cliente.setTelefono(telefono);
		 String comuna= request.getParameter("");
//		 cliente.setComuna(comuna);
		 String region= request.getParameter("");
		 String passIngreso= request.getParameter("");
		 String rutIngreso= request.getParameter("");

		 return cliente;
	}
	
	
	
}
