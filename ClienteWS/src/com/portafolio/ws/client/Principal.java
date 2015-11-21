package com.portafolio.ws.client;

import java.rmi.RemoteException;

import com.portafolio.ws.bean.BeanAseguradora;
import com.portafolio.ws.service.ImplAseguradora;
import com.portafolio.ws.service.ImplAseguradoraProxy;

public class Principal {

	public static void main(String[] args) {
		ImplAseguradora iface = new ImplAseguradoraProxy("http://localhost:8087/Aseguradora/services/ImplAseguradora");
		BeanAseguradora obj = new BeanAseguradora();
		obj.setNombre("Magallanes");
		obj.setMonto(50000);
		obj.setPlan("Muerte");
		try {
			obj = iface.validaAseguradora(obj);
			if(obj.getEstado()){
				System.out.println(obj.getDescripcion());
			}else{
				System.out.println(obj.getDescripcion());
			}
		} catch(RemoteException re){
			re.printStackTrace();
		}
		
	}

}
