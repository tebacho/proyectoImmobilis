package com.immobilis.conexiones.dao;

import com.immobilis.vo.ClienteVO;



public interface ClienteDao {

	public String addCliente(ClienteVO cliente);
	public String actualizarCliente(ClienteVO clienteVO);
	public ClienteVO fetchClienteVO(ClienteVO clienteVO);
	public ClienteVO loginCliente(ClienteVO clienteVO);
	public String deleteCliente(ClienteVO cliente);
	
}
