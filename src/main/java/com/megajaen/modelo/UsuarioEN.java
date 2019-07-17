package com.megajaen.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuarioEN")
public class UsuarioEN {

	@Id
	@Column(name = "usr_codigo")
	private int codigo;

	@NotNull
	@Column(name = "usr_email")
	private String email;

	@NotNull
	@Column(name = "usr_password")
	private String contrasenia;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cli_id", referencedColumnName = "id")
	private ClienteEN cliente;
	
	
	public ClienteEN getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEN cliente) {
		this.cliente = cliente;
	}

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

}
