package com.immobilis.principal.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.principal.form.FormularioReservaForm;
import com.immobilis.principal.manager.FormularioReservaManager;
import com.immobilis.vo.BodegaVO;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.DepartamentoVO;
import com.immobilis.vo.EstacionamientoVO;
import com.immobilis.vo.OficinaVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.ReservaVO;


public class FormularioReservaAction extends DispatchAction {

	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String idPropiedad = request.getParameter("idPropiedad");
		String username = request.getParameter("username");
		FormularioReservaManager manager = new FormularioReservaManager();
		
		if (form instanceof FormularioReservaForm) {
//			FormularioReservaForm formulario = (FormularioReservaForm) form;
//			ClienteVO clienteVO = manager.findUser(username);
//			PropiedadVO propiedad = manager.findPropiedad(idPropiedad);
//			formulario.setApellidoUsuario(clienteVO.getPaterno());
//			formulario.setFechaCreacion(new Date());
//			formulario.setMailContacto(clienteVO.geteMail());
//			formulario.setNombreUsuario(clienteVO.getNombre());
//			formulario.setNumeroContacto(clienteVO.getTelefono());
//			formulario.setPropiedad(propiedad);
//			formulario.setRutUsuario(clienteVO.getRut());
//			ReservaVO reserva = formToReserva(formulario);
//			manager.sendForm(reserva);
		}

		return mapping.findForward("formularioReserva");
	}
	private ReservaVO formToReserva(FormularioReservaForm formulario){
		ReservaVO reserva = new ReservaVO();
		reserva.setApellidoUsuario(reserva.getApellidoUsuario());
		reserva.setFechaCreacion(formulario.getFechaCreacion());
		reserva.setIdPropiedad(formulario.getPropiedad().getIdPropiedad());
		reserva.setMailContacto(formulario.getMailContacto());
		reserva.setNombreUsuario(formulario.getNombreUsuario());
		reserva.setNumeroContacto(reserva.getNumeroContacto());
		reserva.setRutUsuario(formulario.getRutUsuario());
		return reserva;
	}

	public ActionForward enviarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		if (form instanceof FormularioReservaForm) {
			FormularioReservaForm formulario = (FormularioReservaForm) form;

		}

		return null;
	}


}
