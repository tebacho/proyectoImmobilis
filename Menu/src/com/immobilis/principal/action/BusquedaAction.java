package com.immobilis.principal.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.conexiones.dao.ReservaManagerDao;
import com.immobilis.conexiones.dao.impl.ReservaManagerDaoImpl;
import com.immobilis.principal.form.BusquedaForm;
import com.immobilis.principal.manager.BusquedaManager;
import com.immobilis.principal.manager.FormularioReservaManager;
import com.immobilis.vo.BodegaVO;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.ConstructoraVO;
import com.immobilis.vo.DepartamentoVO;
import com.immobilis.vo.EstacionamientoVO;
import com.immobilis.vo.OficinaVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.PropiedadVO.TipoPropiedad;
import com.immobilis.vo.ReservaVO;
import com.immobilis.vo.helper.PropiedadHelper;

public class BusquedaAction extends DispatchAction {

	public ActionForward iniciarPagina(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (form instanceof BusquedaForm) {
			initCombos((BusquedaForm)form);
		}

		return mapping.findForward("busqueda");
	}

	public ActionForward filterPropiedades(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		if (form instanceof BusquedaForm) {
			BusquedaForm busquedaForm = (BusquedaForm) form;
			
			String filtroTipoOperacion;
			String filtroTipoPropiedad;
			String filtroUbicacion;
			
			filtroTipoOperacion = request.getParameter("filtroTipoOperacion");
			filtroTipoPropiedad = request.getParameter("filtroTipoPropiedad");
			filtroUbicacion = request.getParameter("filtroUbicacion");
			
			BusquedaManager busquedaManager = new BusquedaManager();
			
			Map<Integer, PropiedadVO> listadoPropiedades = busquedaManager
					.fetchByFilter(filtroTipoOperacion,
							filtroTipoPropiedad, filtroUbicacion);
			
			busquedaForm.setPropiedades(listadoPropiedades);
			busquedaForm.setFiltroTipoOperacion(filtroTipoOperacion);
			busquedaForm.setFiltroTipoPropiedadBuscada(filtroTipoPropiedad);
			busquedaForm.setFiltroTipoOperacion(filtroUbicacion);
			busquedaForm = initCombos(busquedaForm);
		}

		return mapping.findForward("busqueda");
	}
	public ActionForward reserve(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		if (form instanceof BusquedaForm) {
			BusquedaForm busquedaForm = (BusquedaForm) form;
			ReservaVO reserva = formToReserva(request);
			FormularioReservaManager manager = new FormularioReservaManager();
			manager.sendForm(reserva);
			
		}
		return mapping.findForward("reservaOK");
	}
	private ReservaVO formToReserva(HttpServletRequest request){
		
		ReservaVO reserva = new ReservaVO();
		reserva.setApellidoUsuario(request.getParameter("apellido"));
		reserva.setFechaCreacion(new Date());
		reserva.setIdReserva(0);
		reserva.setMailContacto(request.getParameter("MailContacto"));
		reserva.setNombreUsuario(request.getParameter("nombre"));
		reserva.setNumeroContacto(request.getParameter("numeroContacto"));
		int idPropiedad = Integer.parseInt(request.getParameter("idPropiedad"));
		ReservaManagerDao manager = new ReservaManagerDaoImpl();
//		propiedad = manager.
//		reserva.setPropiedad();
		reserva.setRutUsuario(request.getParameter("rutUsuario"));
		return reserva;
	
	}
	

	private BusquedaForm initCombos(BusquedaForm formulario) {
		formulario = inicializaListOperacion(formulario);
		formulario = inicializaListPropiedades(formulario);
		return formulario;
	}

	private BusquedaForm inicializaListOperacion(BusquedaForm formulario) {
		Map<String, String> tipoBusqueda = new HashMap<String, String>();
		tipoBusqueda.put("", "Seleccione Operación");

		for (PropiedadVO.TipoOperacion tipo : PropiedadVO.TipoOperacion
				.values()) {
			tipoBusqueda.put(tipo.name(), tipo.name());
		}

		formulario.setTipoBusqueda(tipoBusqueda);
		return formulario;
	}

	private BusquedaForm inicializaListPropiedades(BusquedaForm formulario) {
		Map<String, String> tipoPropiedad = new HashMap<String, String>();
		tipoPropiedad.put("", "Seleccione tipo Propiedad");
		for (PropiedadVO.TipoPropiedad tipo : PropiedadVO.TipoPropiedad
				.values()) {
			tipoPropiedad.put(tipo.name(), tipo.name());
		}
		formulario.setTipoPropiedad(tipoPropiedad);
		return formulario;
	}
}
