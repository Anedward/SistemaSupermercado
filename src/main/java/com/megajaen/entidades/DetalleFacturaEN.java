package com.megajaen.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DetalleFacturaEN {
	@Id
	@Column(name="detFac_codigo")
	private int codigo;
	
	@Column(name="detFac_cantidad")
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="det_producto")
	@JsonIgnore
	private ProductoEN producto;
	
	@OneToOne
	@JoinColumn(name="det_factura")
	@JsonIgnore
	private FacturaEN factura;
	
	@Transient
	private int idFacturaTemp;
	

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

	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}
	
}
