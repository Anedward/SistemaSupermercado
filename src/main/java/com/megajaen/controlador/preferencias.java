package com.megajaen.controlador;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.megajaen.entidades.AdministradorEN;




@Named
@SessionScoped
public class preferencias implements Serializable{
	
	
private AdministradorEN usuario;

public AdministradorEN getUsuario() {
	return usuario;
}

public void setUsuario(AdministradorEN usuario) {
	this.usuario = usuario;
}

	

	
}
