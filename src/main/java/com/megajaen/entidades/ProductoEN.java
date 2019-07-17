package com.megajaen.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductoEN {
	
	@Id
	@Column(name="prod_codigo")
	private String codigo;
	
	@Column(name="prod_nombre")
	@NotNull
	private String nombre;
	
	@Column(name="prod_descripcion")
	private String descripcion;
	
	@Column(name="prod_precioCompra")
	@NotNull
	private double precioCompra;
	
	@Column(name="prod_precioVenta")
	@NotNull
	private double precioVenta;
	
	@Column(name="prod_stock")
	@NotNull
	private int stock;
	
	@Column(name="prod_estado")
	@NotNull
	private String estado;
	
	@Column(name="prod_calificacion")
	private int calificacion;
	
	
	@OneToOne
	@JoinColumn(name="cat_producto")
	//@JsonIgnore
	private CategoriaEN categoria;
	
	@Transient
	//@JsonIgnore
	private String cod;
	
	@Transient
	//@JsonIgnore
	private String idCategoriaTemp;
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public CategoriaEN getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEN categoria) {
		this.categoria = categoria;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getIdCategoriaTemp() {
		return idCategoriaTemp;
	}

	public void setIdCategoriaTemp(String idCategoriaTemp) {
		this.idCategoriaTemp = idCategoriaTemp;
	}

	@Override
	public String toString() {
		return "ProductoEN [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", stock=" + stock + ", estado="
				+ estado + ", calificacion=" + calificacion + ", categoria=" + categoria + ", cod=" + cod
				+ ", idCategoriaTemp=" + idCategoriaTemp + "]";
	}

}
