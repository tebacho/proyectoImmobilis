package com.immobilis.conexiones.dao;

import java.util.List;
import java.util.Map;

import com.immobilis.vo.ComunaVO;

public interface ComunaDao {
	public List<ComunaVO> listarComunas();
	public List<ComunaVO> fetchComunas(ComunaVO comuna);
	public ComunaVO agregarComuna(ComunaVO comuna);
	public ComunaVO editarComuna(ComunaVO comuna);
	public boolean eliminarComuna(ComunaVO comuna);
	
}
