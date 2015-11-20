package com.immobilis.conexiones.dao;

import java.util.Map;

import com.immobilis.vo.ComunaVO;

public interface ComunaDao {
	public Map<Integer,ComunaVO> listarComunas();
	public Map<Integer,ComunaVO> fetchComunas(ComunaVO comuna);
	public Map<Integer,ComunaVO> agregarComuna(ComunaVO comuna);
	public Map<Integer,ComunaVO> editarComuna(ComunaVO comuna);
	public boolean eliminarComuna(ComunaVO comuna);
	
}
