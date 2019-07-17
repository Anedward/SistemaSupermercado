package com.megajaen.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class EmpresaEN {
	
	@Id
	@Column(name="emp_codigo")
	private int codigo;
	
	@Column(name="emp_razonsocial")
	@NotNull
	private String razonSocial;
	
	@Column(name="emp_ruc")
	@NotNull
	private String ruc;
	
	@Column(name="emp_direccion")
	@NotNull
	private String direccion;
	
	@Column(name="emp_anioCreacion")
	private String anioCreacion;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getAnioCreacion() {
		return anioCreacion;
	}

	public void setAnioCreacion(String anioCreacion) {
		this.anioCreacion = anioCreacion;
	}

	@Override
	public String toString() {
		return "EmpresaEN [codigo=" + codigo + ", razonSocial=" + razonSocial + ", ruc=" + ruc + ", direccion="
				+ direccion + ", anioCreacion=" + anioCreacion + "]";
	}
}
