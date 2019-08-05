package com.megajaen.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AdministradorEN {
	
	@Id
	@GeneratedValue
	private int idUsuario;
	@NotNull
	private String usuario;
	
	@NotNull
	private String password;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdministradorEN [usuario=" + usuario + ", password=" + password + "]";
	}
	
}
