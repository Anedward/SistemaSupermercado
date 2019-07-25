package com.megajaen.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class CategoriaEN {
	
	@Id
	@Column(name="cat_codigo")
	private int codigo;

	@NotNull
	@Column(name="cat_descripcion")
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cat_producto")
	@JsonIgnore
	private List<ProductoEN> producto;

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

	public List<ProductoEN> getProducto() {
		return producto;
	}

	public void setProducto(List<ProductoEN> producto) {
		this.producto = producto;
	}
	
	@Override
	public String toString() {
		return "CategoriaEN [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

	public void addProducto(ProductoEN prod) {
		if(producto==null) {
			producto = new ArrayList<>();
		}
		this.producto.add(prod);
	}
	
}