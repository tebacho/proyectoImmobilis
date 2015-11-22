package com.immobilis.vo.helper;

import com.immobilis.vo.BodegaVO;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.DepartamentoVO;
import com.immobilis.vo.EstacionamientoVO;
import com.immobilis.vo.OficinaVO;
import com.immobilis.vo.PropiedadVO;

public class PropiedadHelper {

	public PropiedadVO instanciaPropiedad(String tipoPropiedad){
		PropiedadVO propiedad =null;
		if("bodega".equals(tipoPropiedad)){
			propiedad = new BodegaVO();
			return propiedad;
		}
		if("casa".equals(tipoPropiedad)){
			propiedad = new CasaVO();
			return propiedad;
		}
		if("oficina".equals(tipoPropiedad)){
			propiedad = new OficinaVO();
			return propiedad;
		}
		if("estacionamiento".equals(tipoPropiedad)){
			propiedad = new EstacionamientoVO();
			return propiedad;
		}
		if("departamento".equals(tipoPropiedad)){
			propiedad = new DepartamentoVO();
			return propiedad;
		}
		return null;
	}
}
