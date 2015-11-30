package com.immobilis.principal.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.immobilis.principal.form.FormularioReservaForm;
import com.immobilis.principal.form.PrincipalForm;
import com.immobilis.principal.manager.FormularioReservaManager;
import com.immobilis.vo.BodegaVO;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.DepartamentoVO;
import com.immobilis.vo.EstacionamientoVO;
import com.immobilis.vo.OficinaVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.RegionVO;
import com.immobilis.vo.ReservaVO;


public class FormularioReservaAction extends DispatchAction {

	public ActionForward mostrarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String idPropiedad = request.getParameter("idPropiedad");
		String username = request.getParameter("username");
		FormularioReservaManager manager = new FormularioReservaManager();
		
		
		
		if (form instanceof FormularioReservaForm) {
			FormularioReservaForm formulario = (FormularioReservaForm) form;
			
			ClienteVO clienteVO = (ClienteVO)request.getSession().getAttribute("cliente");
			formulario.setCliente(clienteVO);
			PropiedadVO propiedad = manager.findPropiedad(Integer.parseInt(idPropiedad));
			formulario.setPropiedad(propiedad);
			List<ComunaVO> comunas = manager.listarComunas();
			List<RegionVO> regiones = manager.listarRegiones();
			
			
		}

		return mapping.findForward("formularioReserva");
	}
//	private FormularioReservaForm initCombos(FormularioReservaForm form, ClienteVO cliente){
//		FormularioReservaManager manager = new FormularioReservaManager();
//		Map<Integer, ComunaVO> comunas = manager.listarComunas();
//		Map<Integer, RegionVO> regiones = manager.listarRegiones();
//		if(cliente.getComuna()!=null){
//			int idComuna = cliente.getComuna().getCodigoComuna();
//			int idREgion = cliente.getComuna().getCodigoRegion();
//			ComunaVO comuna = null;
//			RegionVO region = null;
//			for(Integer key : comunas.keySet()){
//				if(key.equals(idComuna)){
//					comuna= comunas.get(key);
//				}
//			}
//		}
//		
//	}
	private ReservaVO formToReserva(FormularioReservaForm formulario){
		ReservaVO reserva = new ReservaVO();
		reserva.setApellidoUsuario(reserva.getApellidoUsuario());
		reserva.setFechaCreacion(formulario.getFechaCreacion());
//		reserva.setIdPropiedad(formulario.getPropiedad().getIdPropiedad());
//		reserva.setMailContacto(formulario.getMailContacto());
//		reserva.setNombreUsuario(formulario.getNombreUsuario());
//		reserva.setNumeroContacto(reserva.getNumeroContacto());
//		reserva.setRutUsuario(formulario.getRutUsuario());
		return reserva;
	}
//	private FormularioReservaForm initCombos(FormularioReservaForm form, ClienteVO cliente){
//		FormularioReservaManager manager = new FormularioReservaManager();
//		Map<Integer, ComunaVO> comunas = manager.listarComunas();
//		Map<Integer, RegionVO> regiones = manager.listarRegiones();
//		form.setComboComunasCliente(comunas);
//		form.setComboRegionCliente(regiones);
//		ComunaVO comuna;
//		RegionVO region;
//		if(cliente!=null && cliente.getComuna()!=null){
//			int idComuna = cliente.getComuna().getCodigoComuna();
//			int idRegion = cliente.getComuna().getCodigoRegion();
//			for (Integer key : comunas.keySet()){
//				if (key.equals(idComuna)){
//					comuna=comunas.get(key);
//				}
//			}
//			for (Integer key : regiones.keySet()){
//				if (key.equals(idRegion)){
//					region=regiones.get(key);
//				}
//			}
//			if(comuna!=null){
//				comunas.
//			}
//		}
//		
//	}

	public ActionForward enviarFormulario(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		if (form instanceof FormularioReservaForm) {
			FormularioReservaForm formulario = (FormularioReservaForm) form;

		}

		return null;
	}


}
