package com.immobilis.usuarioweb.action;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.google.gson.Gson;
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
			
			UsuarioWebManager manager = new UsuarioWebManager();
			ClienteVO cliente= recibirParametros(request);
			cliente= manager.loginUsuario(cliente);
			String resp="";
			
			try{
			if ( cliente!=null ) {
			      HttpSession sesion = request.getSession();
			      sesion.setAttribute("cliente", cliente);
					resp = cliente.getNombre()+","+cliente.getPassword()+","+cliente.getRut();
					
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
		
		return  null;
	}
	
	
	public ClienteVO recibirParametros(HttpServletRequest request){
		 ClienteVO cliente = new ClienteVO();
		 String rut = request.getParameter("rut");
		 rut=rut.trim().replace(".", "").replace("-", "").toUpperCase();
		 cliente.setRut(rut);
		 String password= request.getParameter("password");
		 cliente.setPassword(password);
		 return cliente;
	}
	
	
	
}
