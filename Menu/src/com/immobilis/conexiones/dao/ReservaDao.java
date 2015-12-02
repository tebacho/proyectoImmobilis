package com.immobilis.conexiones.dao;

import java.util.List;

import com.immobilis.vo.ReservaVO;

public interface ReservaDao {

	public List<ReservaVO> fetchReservas(String rutCliente, String idReserva);
	
}
