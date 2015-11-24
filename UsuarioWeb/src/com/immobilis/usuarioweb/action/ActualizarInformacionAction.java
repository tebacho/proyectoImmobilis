package com.immobilis.usuarioweb.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.usuarioweb.form.ActualizarInformacionForm;
import com.immobilis.usuarioweb.manager.UsuarioWebManager;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.RegionVO;


public class ActualizarInformacionAction extends DispatchAction {
	
	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (form instanceof ActualizarInformacionForm) {
			ActualizarInformacionForm formulario = (ActualizarInformacionForm)form;
			UsuarioWebManager manager = new UsuarioWebManager();
			ClienteVO cliente= recibirParametros(request);
			cliente= manager.buscarUsuarioWeb(cliente);
			//formulario.llenarDatos(cliente);
			Map<String, ComunaVO> comunas = manager.listarComunas();
			Map<String, RegionVO> regiones = manager.listarRegiones();
			
			if(comunas==null || regiones==null){
			formulario.setComunas(new HashMap<Integer, ComunaVO>() );
			formulario.setRegiones(new HashMap<Integer, RegionVO>());
			}else{
				formulario.setComunas(comunas);
				formulario.setRegiones(regiones);
			}
			if(cliente==null){
				cliente=new ClienteVO();
				ComunaVO comuna= new ComunaVO();
				comuna.setCodigoComuna(1);
				comuna.setNombreComuna("alfo0");
				comuna.setCodigoRegion(2);
				formulario.llenarDatos(cliente);
			}
		
			
		}

		return mapping.findForward("actualizarInformacion");
	}
	
	public ActionForward actualizacionInformacionUsuario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String result="";
		if (form instanceof ActualizarInformacionForm) {
			ActualizarInformacionForm formulario = (ActualizarInformacionForm)form;
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
