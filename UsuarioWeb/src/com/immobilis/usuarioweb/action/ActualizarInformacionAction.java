package com.immobilis.usuarioweb.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.usuarioweb.form.ActualizaInformacionForm;
import com.immobilis.usuarioweb.manager.UsuarioWebManager;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.RegionVO;


public class ActualizarInformacionAction extends DispatchAction {
	
	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (form instanceof ActualizaInformacionForm) {
			ActualizaInformacionForm formulario = (ActualizaInformacionForm)form;
			UsuarioWebManager manager = new UsuarioWebManager();
			ClienteVO cliente= recibirParametros(request);
			cliente= manager.buscarUsuarioWeb(cliente);
			formulario.llenarDatos(cliente);
			Map<String, ComunaVO> comunas = manager.listarComunas();
			Map<String, RegionVO> regiones = manager.listarRegiones();
			
			
			if(comunas==null || regiones==null){
			formulario.setComunas(new HashMap<Integer, ComunaVO>() );
			formulario.setRegiones(new HashMap<Integer, RegionVO>());
			}else{
				formulario.setComunas(comunas);
				formulario.setRegiones(regiones);
			}
		
			
		}

		return mapping.findForward("actualizaInformacion");
	}
	
	public ActionForward actualizacionInformacionUsuario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String result="";
		if (form instanceof ActualizaInformacionForm) {
			ActualizaInformacionForm formulario = (ActualizaInformacionForm)form;
			UsuarioWebManager manager = new UsuarioWebManager();
			ClienteVO cliente= recibirParametros(request);
			result= manager.actualizaCliente(cliente);
			formulario.llenarDatos(cliente);
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
