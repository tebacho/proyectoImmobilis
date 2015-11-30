package com.immobilis.conexiones.dao;

import java.util.Map;

import com.immobilis.vo.PropiedadVO;

public interface PropiedadesDao {

	public Map<Integer, PropiedadVO> fetchByFilter(String filtroTipoOperacion,	
			String filtroTipoPropiedadBuscada,
			String filtroUbicacion);
	public Map<Integer, PropiedadVO> fetchPropiedad(PropiedadVO propiedad);
	public PropiedadVO fetchPropiedadById(PropiedadVO propiedad);
	public Map<Integer, PropiedadVO> addPropiedad(PropiedadVO propiedad);
	public PropiedadVO updatePropiedad(PropiedadVO propiedad);
}
