package com.immobilis.usuarioweb.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.usuarioweb.form.InformacionPagosForm;
import com.immobilis.usuarioweb.manager.InformacionPagosManager;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.PagoVO;

public class InformacionPagos extends DispatchAction {

	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (form instanceof InformacionPagosForm) {
			InformacionPagosForm formulario = (InformacionPagosForm) form;
			ClienteVO cliente = clienteFromSession(request);
			InformacionPagosManager manager = new InformacionPagosManager();
			Map<Integer, PagoVO> pagos = manager.listadoPagos(cliente);
			formulario.setPagos(pagos);
		}
		return mapping.findForward("InformePagos");
	}

	public ClienteVO clienteFromSession(HttpServletRequest request) {
		ClienteVO cliente = new ClienteVO();
		String idCliente = (String) request.getSession().getAttribute(
				"rutUsuario");
		cliente.setRut(idCliente);
		return cliente;
	}
}
