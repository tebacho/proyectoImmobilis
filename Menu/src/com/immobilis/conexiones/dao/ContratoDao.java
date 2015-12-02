package com.immobilis.conexiones.dao;

import java.util.Map;

import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ContratoVO;

public interface ContratoDao {
	public Map<Integer,ContratoVO> ContratosActivos(ClienteVO cliente);

	public ContratoVO grabarContrato(ContratoVO contrato);
}
