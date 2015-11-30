package com.immobilis.usuarioweb.manager;

import java.util.Map;

import com.immobilis.conexiones.dao.PagoDao;
import com.immobilis.conexiones.dao.impl.PagoDaoImpl;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.PagoVO;

public class InformacionPagosManager {
	
	public Map<Integer,PagoVO> listadoPagos(ClienteVO clienteVO){
		PagoDao pagoDao = new PagoDaoImpl();
		return pagoDao.fetchPagosPendientes(clienteVO);	
	}
	
}
