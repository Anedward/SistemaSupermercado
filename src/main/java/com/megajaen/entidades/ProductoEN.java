package com.megajaen.entidades;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductoEN {
	
	@Id
	@Column(name="prod_codigo")
	private int codigo;
	
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
	
	@Column(name="prod_calificacion")
	private int calificacion;
	
	@Column(name="prod_imagen")
	@Lob
	private Byte[] imagen;
	
	
	@OneToOne
	@JoinColumn(name="cat_producto")
	@JsonIgnore
	private CategoriaEN categoria;
	
	@OneToOne
	@JoinColumn(name="prove_producto")
	//@JsonIgnore
	private ProveedorEN proveedor;

	@Transient
	private int idCategoriaTemp;
	
	@Transient
	private int idProveedorTemp;
	
	@Transient
	private String nomCategoriaTemp;

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
	

	public int getIdCategoriaTemp() {
		return idCategoriaTemp;
	}

	public void setIdCategoriaTemp(int idCategoriaTemp) {
		this.idCategoriaTemp = idCategoriaTemp;
	}
	
	

	public int getIdProveedorTemp() {
		return idProveedorTemp;
	}


	public void setIdProveedorTemp(int idProveedorTemp) {
		this.idProveedorTemp = idProveedorTemp;
	}


	public String getNomCategoriaTemp() {
		return nomCategoriaTemp;
	}


	public void setNomCategoriaTemp(String nomCategoriaTemp) {
		this.nomCategoriaTemp = nomCategoriaTemp;
	}
	
	public Byte[] getImagen() {
		return imagen;
	}

	public void setImagen(Byte[] imagen) {
		this.imagen = imagen;
	}
	

	public ProveedorEN getProveedor() {
		return proveedor;
	}


	public void setProveedor(ProveedorEN proveedor) {
		this.proveedor = proveedor;
	}


	@Override
	public String toString() {
		return "ProductoEN [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", stock=" + stock
				+ ", calificacion=" + calificacion + ", imagen=" + Arrays.toString(imagen) + ", categoria=" + categoria
				+ ", proveedor=" + proveedor + ", idCategoriaTemp=" + idCategoriaTemp + ", idProveedorTemp="
				+ idProveedorTemp + ", nomCategoriaTemp=" + nomCategoriaTemp + "]";
	}







	
	

}
