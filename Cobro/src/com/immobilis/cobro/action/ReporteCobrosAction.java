package com.immobilis.cobro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.cobro.form.ReporteCobrosForm;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:36
 */
public class ReporteCobrosAction extends DispatchAction {

	public ActionForward mostrarFormulario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if (form instanceof ReporteCobrosForm) {
			ReporteCobrosForm contratoForm = (ReporteCobrosForm) form;

		}

		return mapping.findForward("reporteCobros");
	}
}//end PreArriendoAction