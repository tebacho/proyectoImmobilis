package com.immobilis.usuarioweb.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.google.gson.Gson;
import com.immobilis.usuarioweb.form.RegistroForm;
import com.immobilis.usuarioweb.manager.UsuarioWebManager;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.RegionVO;


public class RegistroAction extends DispatchAction {

	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (form instanceof RegistroForm) {
			RegistroForm formulario = (RegistroForm)form;
			UsuarioWebManager manager = new UsuarioWebManager();
			List<ComunaVO> comunas = manager.listarComunas();
			List<RegionVO> regiones = manager.listarRegiones();
				formulario.setComunaSelect(comunas.get(0).getCodigoComuna());
				formulario.setRegionSelect(regiones.get(0).getCodigoRegion());
				formulario.setListComunas(comunas);
				formulario.setListRegiones(regiones);
				
			
		}

		return mapping.findForward("registro");
	}

	public ActionForward registroUsuario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("aaaa");
		if (form instanceof RegistroForm) {
			RegistroForm formulario = (RegistroForm) form;
			UsuarioWebManager manager = new UsuarioWebManager();
			ClienteVO cliente = recibirParametros(request);
			cliente = manager.registrarCliente(cliente);
			String resp;
			try{
				if ( cliente!=null ) {
				      
						resp = "cliente "+cliente.getNombre()+" agregado satisfactoriamente";
						
				    } else {
				      resp = "";
				    }
				    }catch(Exception e){
				      resp = "";
				    }
				    try {
				    response.setContentType( "application/json" );
				    ServletOutputStream o = response.getOutputStream();
				        
				      String json = ( new Gson() ).toJson( resp );
				      o.print( json.toString() );
				    }
				    catch ( Exception e ) {

				      e.printStackTrace();
				    }
			
			
		}

		return null;
	}

	public ClienteVO recibirParametros(HttpServletRequest request) {
		ClienteVO cliente = new ClienteVO();
		
		String nombre = request.getParameter("nombre");
		cliente.setNombre(nombre);
		String paterno = request.getParameter("apellidoPaterno");
		cliente.setPaterno(paterno);
		String materno = request.getParameter("apellidoMaterno");
		cliente.setMaterno(materno);
		Date fechaNacimiento = stringIntoDate(request.getParameter("fechaNacimiento"));
		cliente.setFechaNacimiento(fechaNacimiento);
		String rut = request.getParameter("rut");
		cliente.setRut(rut);
		String sexo = request.getParameter("sexo");
		cliente.setSexo(sexo);
		String eMail = request.getParameter("email");
		cliente.seteMail(eMail);
		String password = request.getParameter("password");
		cliente.setPassword(password);
		String telefono = request.getParameter("telefono");
		cliente.setTelefono(telefono);
		int codigoComuna = Integer.parseInt(request.getParameter("comuna"));
		ComunaVO comuna = new ComunaVO();
		comuna.setCodigoComuna(codigoComuna);
		comuna.setCodigoRegion(Integer.parseInt(request
				.getParameter("region")));
		cliente.setComuna(comuna);
		return cliente;
	}

	public Date stringIntoDate(String stringDate) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = format.parse(stringDate);

		} catch (ParseException e) {
			
		}
		return fecha;
	}

}
