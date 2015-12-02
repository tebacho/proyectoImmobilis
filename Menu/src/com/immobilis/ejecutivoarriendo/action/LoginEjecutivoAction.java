package com.immobilis.ejecutivoarriendo.action;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.google.gson.Gson;
import com.immobilis.ejecutivoarriendo.form.LoginEjecutivoForm;
import com.immobilis.ejecutivoarriendo.manager.LoginEjecutivoManager;
import com.immobilis.usuarioweb.form.LoginForm;
import com.immobilis.vo.EmpleadoVO;

public class LoginEjecutivoAction extends DispatchAction {

	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("login");
	}

	public ActionForward loginEjecutivo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (form instanceof LoginEjecutivoForm) {

			LoginEjecutivoManager manager = new LoginEjecutivoManager();
			EmpleadoVO ejecutivo = recibirParametros(request);
			ejecutivo = manager.loginEmpleado(ejecutivo);
			String resp = "";

			try {
				if (ejecutivo != null) {
					
					HttpSession sesion = request.getSession();
					sesion.setAttribute("ejecutivo", ejecutivo);
					resp = ejecutivo.getNombre() + "," + ejecutivo.getPassword()
							+ "," + ejecutivo.getRut();

				} else {
					resp = "";
				}
			} catch (Exception e) {
				resp = "";
			}
			try {
				response.setContentType("application/json");
				ServletOutputStream o = response.getOutputStream();

				String json = (new Gson()).toJson(resp);
				o.print(json.toString());
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return null;
	}

	public EmpleadoVO recibirParametros(HttpServletRequest request) {
		EmpleadoVO empleado = new EmpleadoVO();
		String rut = request.getParameter("rut");
		rut = rut.trim().replace(".", "").replace("-", "").toUpperCase();
		empleado.setRut(rut);
		String password = request.getParameter("password");
		empleado.setPassword(password);
		return empleado;
	}

	public ActionForward cerrarSession(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		
		
		String resp;

		try {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("ejecutivo",null);
			 resp = "Session Cerrada";
		} catch (Exception e) {
			resp = "";
		}
		try {
			response.setContentType("application/json");
			ServletOutputStream o = response.getOutputStream();

			String json = (new Gson()).toJson(resp);
			o.print(json.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}


	return null;
	}

	}

