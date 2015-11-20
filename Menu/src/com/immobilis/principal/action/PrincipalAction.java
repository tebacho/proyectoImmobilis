package com.immobilis.principal.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.immobilis.principal.form.PrincipalForm;

public class PrincipalAction extends DispatchAction {

	public ActionForward iniciarPagina(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (form instanceof PrincipalForm) {
			PrincipalForm formulario = (PrincipalForm) form;
			formulario= initCombos(formulario);
		}

		return mapping.findForward("principal");
	}

	private PrincipalForm initCombos(PrincipalForm formulario) {
		formulario = inicializaListOperacion(formulario);
		formulario = inicializaListPropiedades(formulario);
		return formulario;
	}

	private PrincipalForm inicializaListOperacion(PrincipalForm formulario) {
		Map<String, String> tipoBusqueda = new HashMap<String, String>();
		tipoBusqueda.put("", "Seleccione Operación");
		tipoBusqueda.put("ARRIENDO", "ARRIENDO");
		tipoBusqueda.put("COMPRA", "COMPRA");
		formulario.setTipoBusqueda(tipoBusqueda);
		return formulario;
	}

	private PrincipalForm inicializaListPropiedades(PrincipalForm formulario) {
		Map<String, String> tipoPropiedad = new HashMap<String, String>();
		tipoPropiedad.put("", "Seleccione tipo Propiedad");
		tipoPropiedad.put("CASA", "CASA");
		tipoPropiedad.put("DEPARTAMENTO", "DEPARTAMENTO");
		tipoPropiedad.put("OFICINA", "OFICINA");
		tipoPropiedad.put("BODEGA", "BODEGA");
		tipoPropiedad.put("ESTACIONAMIENTO", "ESTACIONAMIENTO");
		formulario.setTipoPropiedad(tipoPropiedad);
		return formulario;
	}

}
