package com.immobilis.usuarioweb.manager;

import java.util.Map;

import com.immobilis.conexiones.dao.ContratoDao;
import com.immobilis.conexiones.dao.impl.ContratoDaoImpl;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ContratoVO;

public class ContratosActivosManager {
	
	public Map<Integer,ContratoVO> buscarContratosActivos(ClienteVO clienteVO){
		ContratoDao contratoDao = new ContratoDaoImpl();
		return contratoDao.ContratosActivos(clienteVO);	
	}
	
}
