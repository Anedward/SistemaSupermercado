package com.megajaen.entidades;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetalleFacturaEN {
	@Id
	@Column(name="detFac_codigo")
	private int codigo;
	
	@Column(name="detFac_cantidad")
	private int cantidad;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name="fac_codigo", unique = true)
	private FacturaEN factura;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name="prod_codigo", unique = true)
	private ProductoEN producto = new ProductoEN();

	
	
	public FacturaEN getFactura() {
		return factura;
	}

	public void setFactura(FacturaEN factura) {
		this.factura = factura;
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

	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}

	public DetalleFacturaEN(ProductoEN producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public DetalleFacturaEN() {
		
	}

	
	
	
	
	

	

}
