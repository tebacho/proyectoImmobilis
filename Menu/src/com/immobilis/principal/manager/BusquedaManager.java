package com.immobilis.principal.manager;

import java.util.Map;

import com.immobilis.conexiones.dao.PropiedadesDao;
import com.immobilis.conexiones.dao.impl.PropiedadesDaoImpl;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.helper.PropiedadHelper;

public class BusquedaManager {

	public Map<Integer, PropiedadVO> fetchByFilter(String filtroTipoOperacion,
			String filtroTipoPropiedadBuscada, String filtroUbicacion) {
		PropiedadesDao propiedadesDao = new PropiedadesDaoImpl();
		Map<Integer, PropiedadVO> propiedades = propiedadesDao.fetchByFilter(
				filtroTipoOperacion, filtroTipoPropiedadBuscada,
				filtroUbicacion);

		return propiedades;
	}

	public PropiedadVO fetchPropiedadById(int idPropiedad) {
		PropiedadVO propiedad = PropiedadHelper.instanciaPropiedad(idPropiedad);
		PropiedadesDao dao = new PropiedadesDaoImpl();
		Map<Integer, PropiedadVO> mapPropiedades = dao
				.fetchPropiedad(propiedad);
		for (PropiedadVO value : mapPropiedades.values()) {
			if (value != null) {
				return value;
			} else {
				return null;
			}
		}
		return null;
	}
}
