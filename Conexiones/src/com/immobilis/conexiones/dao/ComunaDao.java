package com.immobilis.conexiones.dao;

import java.util.Map;

import com.immobilis.vo.ComunaVO;

public interface ComunaDao {
	public Map<String,ComunaVO> listarComunas();
	public Map<String,ComunaVO> fetchComunas(ComunaVO comuna);
	public Map<Integer,ComunaVO> agregarComuna(ComunaVO comuna);
	public Map<Integer,ComunaVO> editarComuna(ComunaVO comuna);
	public boolean eliminarComuna(ComunaVO comuna);
	
}
