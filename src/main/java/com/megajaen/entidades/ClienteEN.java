package com.megajaen.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTEEN")
public class ClienteEN {

	@Id
	@GeneratedValue
	@Column(name = "cli_codigo")
	private int codigo;

	@Column(name = "cli_nombre")
	private String nombre;
	
	@Column(name="cli_apellido")
	private String apellido;

	@Column(name = "cli_fechaRegistro")
	private String fechaRegistro;
	
	@Column(name="cli_sexo")
	private String sexo;
	
	@Column(name="cli_telefono")
	private String telefono;
	
	@Column(name="cli_direccion")
	private String direccion;
	

	@JoinColumn(name = "usr_codigo", unique = true)
	@OneToOne(cascade = CascadeType.ALL)
	private UsuarioEN usuario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaRegistro() {
		
	return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public UsuarioEN getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEN usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ClienteEN [codigo=" + codigo + ", nombre=" + nombre + ", fechaRegistro=" + fechaRegistro + ", usuario="
				+ usuario + "]";
	}

	public void agregarUsuario(UsuarioEN user) {
		if (usuario == null) {
			usuario = new UsuarioEN();
		}
		this.usuario = user;
	}

}


}
