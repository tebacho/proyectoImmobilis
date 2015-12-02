package com.immobilis.principal.action;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sun.rmi.transport.proxy.HttpReceiveSocket;

import com.google.gson.Gson;
import com.immobilis.principal.form.FormularioReservaForm;
import com.immobilis.principal.manager.FormularioReservaManager;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.RegionVO;
import com.immobilis.vo.ReservaVO;

public class FormularioReservaAction extends DispatchAction {

	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String idPropiedad = request.getParameter("idPropiedad");
		FormularioReservaManager manager = new FormularioReservaManager();

		if (form instanceof FormularioReservaForm) {
			FormularioReservaForm formulario = (FormularioReservaForm) form;
			ClienteVO clienteVO = (ClienteVO) request.getSession()
					.getAttribute("cliente");
			if (clienteVO != null) {
				formulario.setCliente(clienteVO);
				PropiedadVO propiedad = manager.findPropiedad(Integer
						.parseInt(idPropiedad));
				formulario.setPropiedad(propiedad);

				
			} else {
				return mapping.findForward("login");
			}
		}
		return mapping.findForward("formularioReserva");
	}

	private ReservaVO createReserva(HttpServletRequest request) {
		ReservaVO reserva = new ReservaVO();
		ClienteVO cliente = (ClienteVO)request.getSession().getAttribute("cliente");
		reserva.setApellidoUsuario(cliente.getPaterno());
		reserva.setFechaCreacion(new Date());
		 reserva.setIdPropiedad(Integer.parseInt(request.getParameter("txtIdPropiedad")));
		 reserva.setTipoReserva(request.getParameter("txtOperacion").equalsIgnoreCase("COMPRA")?0:1);
		 reserva.setMailContacto(cliente.geteMail());
		 reserva.setNombreUsuario(cliente.getNombre());
		 reserva.setNumeroContacto(cliente.getTelefono());
		 reserva.setRutUsuario(cliente.getRut());
		return reserva;
	}

	public ActionForward reservar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		if (form instanceof FormularioReservaForm) {
			ReservaVO reserva = createReserva(request);
			FormularioReservaManager manager = new FormularioReservaManager();
			String resp;
			try {
				if (manager.sendForm(reserva)) {
					
					resp = "Reserva Realizada con éxito";

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

}
