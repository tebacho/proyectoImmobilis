package com.immobilis.principal.manager;

import java.util.Map;

import com.immobilis.conexiones.dao.PropiedadesDao;
import com.immobilis.conexiones.dao.impl.PropiedadesDaoImpl;
import com.immobilis.vo.PropiedadVO;

public class BusquedaManager {

	public Map<String,PropiedadVO> fetchByFilter(String filtroTipoOperacion,	
											String filtroTipoPropiedadBuscada,
											String filtroUbicacion){
		PropiedadesDao propiedadesDao = new PropiedadesDaoImpl();
		Map<String,PropiedadVO> propiedades = propiedadesDao.fetchByFilter(filtroTipoOperacion, filtroTipoPropiedadBuscada, filtroUbicacion);
		
		return propiedades;
	}
}
