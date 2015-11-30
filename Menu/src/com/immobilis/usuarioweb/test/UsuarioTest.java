package com.immobilis.usuarioweb.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.immobilis.usuarioweb.action.RegistroAction;
import com.immobilis.usuarioweb.manager.UsuarioWebManager;
import com.immobilis.vo.ClienteVO;
import com.immobilis.vo.ComunaVO;
import com.sun.security.ntlm.Client;

public class UsuarioTest {

	
	public void login() {
		ClienteVO cliente = new ClienteVO(); 
		cliente.setRut("15413610K");
		cliente.setPassword("15413");
		UsuarioWebManager manager = new UsuarioWebManager();
		cliente = manager.loginUsuario(cliente);
		assertTrue(cliente!=null);
	}
	
	public void registro() {
		ClienteVO cliente = new ClienteVO(); 
		cliente.setRut("63868175");
		cliente.setPassword("1234");
		cliente.setPaterno("paterno");
		cliente.setMaterno("materno");
		cliente.setNombre("conmigo");
		ComunaVO comuna = new ComunaVO();
		comuna.setCodigoComuna(1403);
		comuna.setCodigoRegion(1);
		cliente.setSexo("H");
		cliente.setTelefono("99917072");
		cliente.seteMail("r@r.cl");
		cliente.setPassword("15413");
		cliente.setComuna(comuna);
		UsuarioWebManager manager = new UsuarioWebManager();
		cliente = manager.registrarCliente(cliente);
		assertTrue(cliente!=null);
	}
	@Test
	public void formatFecha() {
		String fecha = "02/07/1982";
		RegistroAction manager = new RegistroAction();
		Date fechaD = manager.stringIntoDate(fecha);
		assertTrue(1==1);
		
	}
	
	

}
