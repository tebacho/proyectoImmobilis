package com.immobilis.principal.manager;

import java.util.List;
import java.util.Map;

import com.immobilis.conexiones.dao.ClienteDao;
import com.immobilis.conexiones.dao.ComunaDao;
import com.immobilis.conexiones.dao.FormularioReservaDao;
import com.immobilis.conexiones.dao.PropiedadesDao;
import com.immobilis.conexiones.dao.RegionDao;
import com.immobilis.conexiones.dao.impl.ClienteDaoImpl;
import com.immobilis.conexiones.dao.impl.ComunaDaoImpl;
import com.immobilis.conexiones.dao.impl.FormularioReservaDaoImpl;
import com.immobilis.conexiones.dao.impl.PropiedadesDaoImpl;
import com.immobilis.conexiones.dao.impl.RegionDaoImpl;
import com.immobilis.principal.form.FormularioReservaForm;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.RegionVO;
import com.immobilis.vo.ReservaVO;

public class FormularioReservaManager {

	
	public ClienteVO findUser(String username){
		ClienteDao clienteDao = new ClienteDaoImpl();
		ClienteVO clienteVO =new ClienteVO();
		clienteVO.setNombre(username);
		Map<String,ClienteVO> clientes = clienteDao.fetchClienteVO(clienteVO);
		for(ClienteVO cl : clientes.values()){
			return cl;
		}
		return null;
	}
	public PropiedadVO findPropiedad(int idPropiedad){
		PropiedadesDao PropiedadesDao = new PropiedadesDaoImpl();
		PropiedadVO propiedad = new CasaVO();
		propiedad.setIdPropiedad(idPropiedad);
		propiedad= PropiedadesDao.fetchPropiedadById(propiedad);
		return propiedad;
	}
	public boolean sendForm(ReservaVO reserva){
		FormularioReservaDao formularioDAO = new FormularioReservaDaoImpl();
		formularioDAO.SendReserve(reserva);
		return true;
	}
	public List<ComunaVO> listarComunas(){
		ComunaDao comunaDao = new ComunaDaoImpl();
		return comunaDao.listarComunas();
	}
	public List<RegionVO> listarRegiones(){
		RegionDao regionDao = new RegionDaoImpl();
		return regionDao.listaRegiones();
	}
	
}
