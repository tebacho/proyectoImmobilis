package com.immobilis.ejecutivoarriendo.action;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.google.gson.Gson;
import com.immobilis.ejecutivoarriendo.form.GenerarContratoForm;
import com.immobilis.ejecutivoarriendo.manager.GenerarContratoManager;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ContratoVO;
import com.immobilis.vo.ConvenioVO;
import com.immobilis.vo.EmpleadoVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.ReservaVO;
import com.immobilis.vo.SeguroVO;
import com.immobilis.vo.ServicioVO;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:33
 */
public class GenerarContratoAction extends DispatchAction{

	public ActionForward mostrarFormulario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String rutCliente = request.getParameter("txtRut");
		String idReserva = request.getParameter("txtReserva");
		if (form instanceof GenerarContratoForm) {
			if(idReserva==null){
				return mapping.findForward("generarContrato");
			}
			ClienteVO cliente= new ClienteVO();
			GenerarContratoForm contratoForm = (GenerarContratoForm) form;
			GenerarContratoManager manager = new GenerarContratoManager();
			List<ReservaVO> listReserva = manager.fetchReservas(rutCliente,idReserva);
			contratoForm.setListReserva(listReserva);
			cliente.setRut(rutCliente);
			contratoForm.setCliente(cliente);
			if(listReserva.size()==1){
				ReservaVO reserva = listReserva.get(0);
				cliente = manager.fetchCliente(reserva.getRutUsuario());
				PropiedadVO propiedad = manager.fetchPropiedad(reserva.getIdPropiedad());
				List<ServicioVO> servicios = manager.fetchAllServicios();
				SeguroVO seguro = manager.fetchSeguro(reserva.getIdSeguro());
				List<ConvenioVO> convenios = manager.fetchAllConvenios();
				contratoForm.setCliente(cliente);
				contratoForm.setPropiedad(propiedad);
				contratoForm.setListServicios(servicios);
				contratoForm.setSeguro(seguro);
				contratoForm.setListConvenio(convenios);
			}
		}

		return mapping.findForward("generarContrato");
	}
	
	public ActionForward guardarContrato(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if (form instanceof GenerarContratoForm) {
			
			GenerarContratoForm contratoForm = (GenerarContratoForm) form;
			ContratoVO contrato = new ContratoVO();
			ClienteVO cliente = new ClienteVO();
			cliente.setRut(request.getParameter("rut"));
			contrato.setCliente(cliente);
			EmpleadoVO empleado= (EmpleadoVO)request.getSession().getAttribute("ejecutivo");
			contrato.setEmpleado(empleado);
			ReservaVO reserva = new ReservaVO();
			reserva.setIdReserva(Integer.parseInt(request.getParameter("txtReserva")));
			contrato.setReserva(reserva);
			double descuento = Double.parseDouble(request.getParameter("descuento"));
			contrato.setDescuento(descuento);
			SeguroVO seguro = new SeguroVO();
			seguro.setSeguro(Integer.parseInt(request.getParameter("txtIdSeguro")));
			contrato.setSeguro(seguro);
			ServicioVO servicio = new ServicioVO();
			servicio.setIdServicio(Integer.parseInt(request.getParameter("txtIdServicio")));
			contrato.setServicio(servicio);
			PropiedadVO propiedad = new CasaVO();
			propiedad.setIdPropiedad(Integer.parseInt(request.getParameter("txtIdPropiedad")));
			String tipoOperacion = request.getParameter("operacion");
			if(tipoOperacion.equalsIgnoreCase("ARRIENDO")){
				propiedad.setTipoOperacion(PropiedadVO.TipoOperacion.ARRIENDO);
			}else {
				propiedad.setTipoOperacion(PropiedadVO.TipoOperacion.VENTA);
			}
			contrato.setPropiedad(propiedad);
			GenerarContratoManager manager= new GenerarContratoManager();
			contrato = manager.grabarContrato(contrato);
			String resp = "";

			try {
				if (contrato != null) {
					
					resp="contrato guardado";

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
	

}//end EmitirContratoAction