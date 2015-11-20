package com.immobilis.principal.manager;

import com.immobilis.conexiones.dao.ClienteDao;
import com.immobilis.conexiones.dao.FormularioReservaDao;
import com.immobilis.conexiones.dao.PropiedadesDao;
import com.immobilis.conexiones.dao.impl.ClienteDaoImpl;
import com.immobilis.conexiones.dao.impl.FormularioReservaDaoImpl;
import com.immobilis.conexiones.dao.impl.PropiedadesDaoImpl;
import com.immobilis.principal.form.FormularioReservaForm;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.ReservaVO;

public class FormularioReservaManager {

	
	public ClienteVO findUser(String username){
		ClienteDao clienteDao = new ClienteDaoImpl();
		ClienteVO clienteVO =new ClienteVO();
		clienteVO.setNombre(username);
		clienteVO = clienteDao.fetchClienteVO(clienteVO);
		return clienteVO;
	}
	public PropiedadVO findPropiedad(String idPropiedad){
		PropiedadesDao PropiedadesDao = new PropiedadesDaoImpl();
		PropiedadVO propiedadVO= PropiedadesDao.fetchPropiedadById(idPropiedad);
		return propiedadVO;
	}
	public boolean sendForm(ReservaVO reserva){
		FormularioReservaDao formularioDAO = new FormularioReservaDaoImpl();
		formularioDAO.SendReserve(reserva);
		return true;
	}
	
}
