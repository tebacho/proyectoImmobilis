package com.immobilis.usuarioweb.manager;

import com.immobilis.conexiones.dao.ClienteDao;
import com.immobilis.conexiones.dao.impl.ClienteDaoImpl;
import com.immobilis.vo.ClienteVO;

public class UsuarioWebManager {

	public String registrarCliente(ClienteVO clienteVO){
		ClienteDao clienteDao = new ClienteDaoImpl();
		return clienteDao.addCliente(clienteVO);
	}
	
	public String actualizaCliente(ClienteVO clienteVO){
		ClienteDao clienteDao = new ClienteDaoImpl();
		return clienteDao.actualizarCliente(clienteVO);	
	}
	public ClienteVO buscarUsuarioWeb(ClienteVO ClienteBuscado){
		ClienteVO clienteEncontrado = null;
		ClienteDao clienteDao = new ClienteDaoImpl();
		clienteEncontrado = clienteDao.fetchClienteVO(ClienteBuscado);
		return clienteEncontrado;
	}
	public ClienteVO loginUsuario(ClienteVO ClienteBuscado){
		ClienteVO clienteEncontrado = null;
		ClienteDao clienteDao = new ClienteDaoImpl();
		clienteEncontrado = clienteDao.loginCliente(ClienteBuscado);
		return clienteEncontrado;
	}

}
