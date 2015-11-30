package com.immobilis.vo.helper;

import com.immobilis.vo.BodegaVO;
import com.immobilis.vo.CasaVO;
import com.immobilis.vo.DepartamentoVO;
import com.immobilis.vo.EstacionamientoVO;
import com.immobilis.vo.OficinaVO;
import com.immobilis.vo.PropiedadVO;
import com.immobilis.vo.PropiedadVO.TipoPropiedad;

public class PropiedadHelper {

	public static PropiedadVO instanciaPropiedad(TipoPropiedad tipoPropiedad){
		PropiedadVO propiedad =null;
		if(TipoPropiedad.BODEGA.equals(tipoPropiedad)){

			BodegaVO bodega = new BodegaVO();
			bodega.setAltura(2.00);
			bodega.setTipoPropiedad(tipoPropiedad);
			return bodega;
		}
		if(TipoPropiedad.CASA.equals(tipoPropiedad)){
			CasaVO casa = new CasaVO();
			casa.setTipoPropiedad(tipoPropiedad);
			casa.setMetrosCuadrados(200);
			casa.setMetrosHabitables(100);
			return casa;
		}
		if(TipoPropiedad.OFICINA.equals(tipoPropiedad)){
			propiedad = new OficinaVO();
			propiedad.setTipoPropiedad(tipoPropiedad);			
			return propiedad;
		}
		if(TipoPropiedad.ESTAC.equals(tipoPropiedad)){
			propiedad = new EstacionamientoVO();
			propiedad.setTipoPropiedad(tipoPropiedad);			
			return propiedad;
		}
		if(TipoPropiedad.DEPTO.equals(tipoPropiedad)){
			propiedad = new DepartamentoVO();
			propiedad.setTipoPropiedad(tipoPropiedad);			
			return propiedad;
		}
		return null;
	}

	public static PropiedadVO instanciaPropiedad(int idPropiedad){
		PropiedadVO propiedad = new CasaVO();
		propiedad.setIdPropiedad(idPropiedad);
		return propiedad;
	}

}
