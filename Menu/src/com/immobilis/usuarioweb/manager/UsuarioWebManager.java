package com.immobilis.usuarioweb.manager;

import java.util.List;
import java.util.Map;

import com.immobilis.conexiones.dao.ClienteDao;
import com.immobilis.conexiones.dao.ComunaDao;
import com.immobilis.conexiones.dao.DaoFactory;
import com.immobilis.conexiones.dao.RegionDao;
import com.immobilis.conexiones.dao.impl.ClienteDaoImpl;
import com.immobilis.conexiones.dao.impl.ComunaDaoImpl;
import com.immobilis.conexiones.dao.impl.RegionDaoImpl;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.ConvenioVO;
import com.immobilis.vo.RegionVO;

public class UsuarioWebManager {

	public ClienteVO registrarCliente(ClienteVO clienteVO){
		ClienteDao clienteDao = new ClienteDaoImpl();
		return clienteDao.addCliente(clienteVO);
	}
	
	public ClienteVO actualizaCliente(ClienteVO clienteVO){
		ClienteDao clienteDao = new ClienteDaoImpl();
		return clienteDao.actualizarCliente(clienteVO);	
	}
	public ClienteVO buscarCliente(ClienteVO ClienteBuscado){
		Map<String, ClienteVO> clienteEncontrado = null;
		ClienteDao clienteDao = new ClienteDaoImpl();
		clienteEncontrado = clienteDao.fetchClienteVO(ClienteBuscado);
		for (ClienteVO cliente : clienteEncontrado.values()){
			return cliente;
		}
		return null;
	}
	public Map<String, ClienteVO> buscarClientes(ClienteVO ClienteBuscado){
		Map<String, ClienteVO> clienteEncontrado = null;
		ClienteDao clienteDao = new ClienteDaoImpl();
		clienteEncontrado = clienteDao.fetchClienteVO(ClienteBuscado);
		return clienteEncontrado;
	}

	public ClienteVO loginUsuario(ClienteVO clienteVO){

		return  DaoFactory.getInstance().getClienteDao().loginCliente(clienteVO);
	}
	public List<ComunaVO> listarComunas(){
		
		return DaoFactory.getInstance().getComunaDao().listarComunas();
	}
	public List<RegionVO> listarRegiones(){
		
		return DaoFactory.getInstance().getRegionDao().listaRegiones();
	}

}
