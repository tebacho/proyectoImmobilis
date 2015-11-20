package com.immobilis.conexiones.dao;

import java.util.Map;

import com.immobilis.vo.PropiedadVO;

public interface PropiedadesDao {

	public Map<String, PropiedadVO> fetchByFilter(String filtroTipoOperacion,	
			String filtroTipoPropiedadBuscada,
			String filtroUbicacion);
	public PropiedadVO fetchPropiedadById(String idPropiedad);
}
