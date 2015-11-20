package com.immobilis.conexiones.dao;

import java.util.Map;

import com.immobilis.vo.RegionVO;

public interface RegionDao {

	public Map<Integer,RegionVO> listaRegiones();
	
}
