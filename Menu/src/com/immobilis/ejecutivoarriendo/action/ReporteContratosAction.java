package com.immobilis.ejecutivoarriendo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.ejecutivoarriendo.form.GenerarContratoForm;
import com.immobilis.ejecutivoarriendo.form.ReporteContratosForm;

/**
 * @author Rodo
 * @version 1.0
 * @created 20-sep.-2015 20:13:28
 */
public class ReporteContratosAction extends DispatchAction {

	public ActionForward mostrarFormulario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if (form instanceof ReporteContratosForm) {
			ReporteContratosForm formulario = (ReporteContratosForm) form;

		}

		return mapping.findForward("reporteContratos");
	}
}//end ArriendoAction