package com.megajaen.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CLIENTEEN")
public class ClienteEN {
	@Id
	@GeneratedValue
	@Column(name = "cli_codigo")
	private int codigo;

	@Column(name = "cli_nombre")
	private String nombre;

	@Column(name = "cli_apellido")
	private String apellido;

	@Column(name = "cli_fechaRegistro")
	private String fechaRegistro;

	@Column(name = "cli_sexo")
	private String sexo;

	@Column(name = "cli_telefono")
	private String telefono;

	@Column(name = "cli_direccion")
	private String direccion;

	@Column(name = "cli_email")
	@NotNull
	private String email;

	@Column(name = "cli_pass")
	@NotNull
	private String pass;

	// Relacion con la entidad Factura
	@ManyToOne
	@JoinColumn(name = "cli_factura")
	@JsonIgnore
	private FacturaEN factura;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaRegistro() {
		
		return  new SimpleDateFormat("dd-MMMM-yyyy").format(new Date());
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public FacturaEN getFactura() {
		return factura;
	}

	public void setFactura(FacturaEN factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "ClienteEN [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaRegistro="
				+ fechaRegistro + ", sexo=" + sexo + ", telefono=" + telefono + ", direccion=" + direccion + ", email="
				+ email + ", pass=" + pass + ", factura=" + factura + "]";
	}
	

}
