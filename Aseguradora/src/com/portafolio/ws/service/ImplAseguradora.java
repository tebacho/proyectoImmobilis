package com.portafolio.ws.service;

import com.portafolio.ws.bean.BeanAseguradora;

public class ImplAseguradora implements IfaceAseguradora{

	@Override
	public BeanAseguradora validaAseguradora(BeanAseguradora obj) {
		BeanAseguradora bean = new BeanAseguradora();
		if(obj.getNombre().equals("Magallanes") && obj.getMonto()==50000 && obj.getPlan().equals("Muerte")){
			bean.setDescripcion("Seguro de muerte");
			bean.setEstado(true);
		}else{
			bean.setDescripcion("Seguro no contratado!!!");
			bean.setEstado(false);
		}
		return bean;
	}
}
