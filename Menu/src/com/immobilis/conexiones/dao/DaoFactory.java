package com.immobilis.conexiones.dao;

import com.immobilis.conexiones.dao.impl.ClienteDaoImpl;
import com.immobilis.conexiones.dao.impl.ComunaDaoImpl;
import com.immobilis.conexiones.dao.impl.RegionDaoImpl;

public class DaoFactory {
	
	private static DaoFactory instance;
	
	public static DaoFactory getInstance(){
		if (instance== null){
			instance=new DaoFactory();
		}
		return instance;
	}

	private ClienteDao clienteDao;
	private ComunaDao comunaDao;
	private RegionDao regionDao;
	
	public  ClienteDao getClienteDao(){
		if(clienteDao==null)
		{
			clienteDao=new ClienteDaoImpl();
		}
		return clienteDao;
	}
	public  ComunaDao getComunaDao(){
		if(comunaDao==null)
		{
			comunaDao=new ComunaDaoImpl();
		}
		return comunaDao;
	}
	public  RegionDao getRegionDao(){
		if(regionDao==null)
		{
			regionDao=new RegionDaoImpl();
		}
		return regionDao;
	}
	
}
