package com.immobilis.ejecutivoarriendo.manager;

import java.util.List;
import java.util.Map;

import com.immobilis.conexiones.dao.ContratoDao;
import com.immobilis.conexiones.dao.ConvenioDao;
import com.immobilis.conexiones.dao.DaoFactory;
import com.immobilis.conexiones.dao.ReservaDao;
import com.immobilis.conexiones.dao.SeguroDao;
import com.immobilis.conexiones.dao.ServicioDao;
import com.immobilis.conexiones.dao.impl.ContratoDaoImpl;
import com.immobilis.conexiones.dao.impl.ConvenioDaoImpl;
import com.immobilis.conexiones.dao.impl.SeguroDaoImpl;
import com.immobilis.conexiones.dao.impl.ServicioDaoImpl;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ContratoVO;
import com.immobilis.vo.ConvenioVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.ReservaVO;
import com.immobilis.vo.SeguroVO;
import com.immobilis.vo.ServicioVO;

public class GenerarContratoManager {

	public List<ReservaVO> fetchReservas(String rutCliente, String idReserva) {
		ReservaDao dao = DaoFactory.getInstance().getReservaDao();
		List<ReservaVO> listReserva = dao.fetchReservas(rutCliente,idReserva);
		return listReserva;
	}

	public PropiedadVO fetchPropiedad(int idPropiedad) {
		PropiedadVO propiedad = new CasaVO();
		propiedad.setIdPropiedad(idPropiedad);
		propiedad =	DaoFactory.getInstance().getPropiedadDao().fetchPropiedadById(propiedad);
		return propiedad;
	}

	public ClienteVO fetchCliente(String rutUsuario) {
		ClienteVO cliente = new ClienteVO();
		cliente.setRut(rutUsuario);
		Map<String,ClienteVO> clientes = DaoFactory.getInstance().getClienteDao().fetchClienteVO(cliente);
		for(ClienteVO cli : clientes.values() ){
			return cli;
		}
		return null;
	}

	public List<ServicioVO> fetchAllServicios() {
		ServicioDao servicioDao = new ServicioDaoImpl();
		List<ServicioVO> servicios = servicioDao.fetchAll(); 
		return servicios;
	}

	public SeguroVO fetchSeguro(int idSeguro) {
		SeguroDao seguroDao = new SeguroDaoImpl();
		return seguroDao.fetchSeguro(idSeguro);
	}

	public List<ConvenioVO> fetchAllConvenios() {
		ConvenioDao convenio = new ConvenioDaoImpl();
		return convenio.fetchAll();
	}

	public ContratoVO grabarContrato(ContratoVO contrato) {
		ContratoDao cdao = new ContratoDaoImpl();
		
		return cdao.grabarContrato(contrato);
	}
	

	
}