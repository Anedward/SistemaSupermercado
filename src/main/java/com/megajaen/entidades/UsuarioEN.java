package com.megajaen.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USUARIOEN")
public class UsuarioEN {

	@Id
	@GeneratedValue
	@Column(name="usr_codigo")
	private int codigo;

	@NotNull
	@Column(name = "usr_email")
	private String email;

	@NotNull
	@Column(name = "usr_password")
	private String contrasenia;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "UsuarioEN [codigo=" + codigo + ", email=" + email + ", contrasenia=" + contrasenia  + "]";
	}

}
