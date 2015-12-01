package com.immobilis.usuarioweb.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
			ActualizarInformacionForm formulario = (ActualizarInformacionForm) form;
			ClienteVO cliente = (ClienteVO) request.getSession().getAttribute(
					"cliente");
			UsuarioWebManager manager = new UsuarioWebManager();
			formulario.setListComunas(manager.listarComunas());
			formulario.setListRegiones(manager.listarRegiones());
			formulario.setCliente(cliente);
			formulario.llenarDatos(cliente);

		}

		return mapping.findForward("actualizarInformacion");
	}

	public ActionForward actualizacionInformacionUsuario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ClienteVO clienteResult = null;
		if (form instanceof ActualizarInformacionForm) {
			ActualizarInformacionForm formulario = (ActualizarInformacionForm) form;
			String	passwordActual	=	request.getParameter("passwordActual");
			UsuarioWebManager manager = new UsuarioWebManager();
			ClienteVO clienteActualizar = recibirParametros(request);
			clienteResult = manager.actualizaCliente(clienteActualizar, passwordActual);
			formulario.llenarDatos(clienteResult);
		}

		return mapping.findForward("success");
	}

	public ClienteVO recibirParametros(HttpServletRequest request) {
		ClienteVO cliente = new ClienteVO();
		String passwordNuevo = request.getParameter("passwordNuevo");
		cliente.setPassword(passwordNuevo);
		String selSexo = request.getParameter("selSexo");
		cliente.setSexo(selSexo);
		String email = request.getParameter("email");
		cliente.seteMail(email);
		String materno = request.getParameter("materno");
		cliente.setMaterno(materno);
		String telefono = request.getParameter("telefono");
		cliente.setTelefono(telefono);
		String paterno = request.getParameter("paterno");
		cliente.setPaterno(paterno);
		String rut = request.getParameter("rut");
		cliente.setRut(rut);
		Date fechaNacimiento = stringIntoDate(request.getParameter("fechaNacimiento"));
		cliente.setFechaNacimiento(fechaNacimiento);
		int codigoComuna = Integer.parseInt(request.getParameter("comuna"));
		ComunaVO  comuna = new ComunaVO();
		comuna.setCodigoComuna(codigoComuna);
		int codigoRegion = Integer.parseInt(request.getParameter("region"));
		comuna.setCodigoRegion(codigoRegion);
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
