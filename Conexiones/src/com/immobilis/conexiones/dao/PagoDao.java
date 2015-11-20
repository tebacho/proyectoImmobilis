package com.immobilis.conexiones.dao;

import java.util.Map;

import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.PagoVO;

public interface PagoDao {

	public Map<Integer,PagoVO> fetchPagosPendientes(ClienteVO cliente);
	
}
