package com.immobilis.conexiones.dao;

import java.util.Map;

import com.immobilis.vo.ClienteVO;



public interface ClienteDao {

	public ClienteVO addCliente(ClienteVO cliente);
	public ClienteVO actualizarCliente(ClienteVO clienteVO);
	public Map<String,ClienteVO> fetchClienteVO(ClienteVO clienteVO);
	public ClienteVO loginCliente(ClienteVO clienteVO);
	public ClienteVO deleteCliente(ClienteVO cliente);
	
}
