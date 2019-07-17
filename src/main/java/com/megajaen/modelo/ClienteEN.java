package com.megajaen.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clienteEN")
public class ClienteEN{

	@Id
	@Column(name="cli_codigo")
	private int codigo;
	
	@Column(name="cli_cedula")
	private String cedula;
	
	@Column(name="cli_nombre")
	private String nombre;
	
	@Column(name="cli_apellido")
	private String apellido;
	
	@Column(name="cli_fechaNacimiento")
	private Date fechaNacimiento;
	
	@Column(name="cli_fechaRegistro")
	private Date fechaRegistro;
		
	@Column(name="cli_telefono")
	private String telefono;
	
	@Column(name="cli_direccion")
	private String direccion;
	
	@Column(name="cli_sexo")
	private String sexo;
	
	@OneToOne(mappedBy = )
	private UsuarioEN user;

	public ClienteEN() {

	}

	public UsuarioEN getUser() {
		return user;
	}


	public void setUser(UsuarioEN user) {
		this.user = user;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
