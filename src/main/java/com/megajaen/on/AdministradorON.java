package com.megajaen.on;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.dao.AdministradorDAO;
import com.megajaen.entidades.AdministradorEN;

@Stateless
public class AdministradorON {
	
	@Inject
	private AdministradorDAO daoAdmin;

	public AdministradorEN getUsuario(String usu, String pass) {
		return daoAdmin.usuario(usu, pass);
	}

}
