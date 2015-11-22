package com.immobilis.usuarioweb.manager;

import java.util.Map;

import com.immobilis.conexiones.dao.ClienteDao;
import com.immobilis.conexiones.dao.ComunaDao;
import com.immobilis.conexiones.dao.RegionDao;
import com.immobilis.conexiones.dao.impl.ClienteDaoImpl;
import com.immobilis.conexiones.dao.impl.ComunaDaoImpl;
import com.immobilis.conexiones.dao.impl.RegionDaoImpl;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.RegionVO;

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
	public Map<String, ComunaVO> listarComunas(){
		ComunaDao comunaDao = new ComunaDaoImpl();
		return comunaDao.listarComunas();
	}
	public Map<String, RegionVO> listarRegiones(){
		RegionDao regionDao = new RegionDaoImpl();
		return regionDao.listaRegiones();
	}

}
