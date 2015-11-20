package com.immobilis.conexiones.dao;

import java.util.Date;
import java.util.Map;

import com.immobilis.vo.PagoVO;

/**
 * @author Rodolfo
 * @version 1.0
 * @created 20-sep.-2015 20:13:30
 */
public interface CobroDao {

	public Map<Integer,PagoVO> filtrarCobros(Date fechaInicio, Date fechaTermino);
	
}