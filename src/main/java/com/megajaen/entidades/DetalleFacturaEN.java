package com.megajaen.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DetalleFacturaEN {
	@Id
	@GeneratedValue
	@Column(name="detFac_codigo")
	private int codigo;
	
	@Column(name="detFac_cantidad")
	private int cantidad;
	
	@Column(name="detFac_precioVenta")
	private double precioVenta;
	
	@Column(name="detFac_preTot")
	private double precioTotal;
	
	//Relacion con la entidad Producto
	@ManyToOne
	@JoinColumn(name="det_producto")
	@JsonIgnore
	private ProductoEN producto;
	
	//Relacion con la entidad Factura
	@ManyToOne
	@JoinColumn(name="det_factura")
	@JsonIgnore
	private FacturaEN factura;
	
	@Transient
	private int idFacturaTemp;
	
	@Transient
	private int idProductoTemp;

	//Constructor
	public DetalleFacturaEN() {
		super();
	}
    
  //Constructor
	public DetalleFacturaEN(ProductoEN producto) {
	super();
	this.producto = producto;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}

	public FacturaEN getFactura() {
		return factura;
	}

	public void setFactura(FacturaEN factura) {
		this.factura = factura;
	}

	public int getIdFacturaTemp() {
		return idFacturaTemp;
	}

	public void setIdFacturaTemp(int idFacturaTemp) {
		this.idFacturaTemp = idFacturaTemp;
	}

	public int getIdProductoTemp() {
		return idProductoTemp;
	}

	public void setIdProductoTemp(int idProductoTemp) {
		this.idProductoTemp = idProductoTemp;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	@Override
	public String toString() {
		return "DetalleFacturaEN [codigo=" + codigo + ", codigoBarras=" 
				+ ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", precioTotal=" + precioTotal
				+ ", producto=" + producto + ", factura=" + factura + ", idFacturaTemp=" + idFacturaTemp
				+ ", idProductoTemp=" + idProductoTemp + "]";
	}

	

	

}
