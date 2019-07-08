
package com.megajaen.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CategoriaEN {

	@Id
	@Column(name="cat_codigo")
	private int codigo;

	@NotNull
	@Column(name="cat_descripcion")
	private String descripcion;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CategoriaEN [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
}
