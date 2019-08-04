package com.megajaen.entidades;


import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Typed;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductoEN {
	
	@Id
	@Column(name="prod_codigo")
	private int codigo;
	
	@Column(name="prod_codBarra")
	@NotNull
	private String codBarra;
	
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
	@Typed
	private byte[] imagen;
    
	@OneToOne
	@JoinColumn(name="cat_producto")
	@JsonIgnore
	private CategoriaEN categoria;
	
	@OneToOne
	@JoinColumn(name="prove_producto")
	@JsonIgnore
	private ProveedorEN proveedor;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="det_producto")
	@JsonIgnore
	private List<DetalleFacturaEN> detalleFactura;
	
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

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public CategoriaEN getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEN categoria) {
		this.categoria = categoria;
	}

	public ProveedorEN getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEN proveedor) {
		this.proveedor = proveedor;
	}


	public List<DetalleFacturaEN> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFacturaEN> detalleFactura) {
		this.detalleFactura = detalleFactura;
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

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

	@Override
	public String toString() {
		return "ProductoEN [codigo=" + codigo + ", codBarra=" + codBarra + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", stock=" + stock
				+ ", calificacion=" + calificacion + ", imagen=" + Arrays.toString(imagen) + ", categoria=" + categoria
				+ ", proveedor=" + proveedor + ", detalleFactura=" + detalleFactura + ", idCategoriaTemp="
				+ idCategoriaTemp + ", idProveedorTemp=" + idProveedorTemp + ", nomCategoriaTemp=" + nomCategoriaTemp
				+ "]";
	}

}
