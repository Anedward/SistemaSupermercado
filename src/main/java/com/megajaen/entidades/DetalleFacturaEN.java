package com.megajaen.entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@OneToOne
	@JoinColumn(name="det_factura")
	@JsonIgnore
	private FacturaEN factura;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="detalle_producto",joinColumns=@JoinColumn(name="detalle_id"),inverseJoinColumns=@JoinColumn(name="producto_id"))
	private List<ProductoEN> productoLista = new ArrayList<>();
	
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

	public List<ProductoEN> getProductoLista() {
		return productoLista;
	}

	public void setProductoLista(List<ProductoEN> productoLista) {
		this.productoLista = productoLista;
	}

	public int getIdFacturaTemp() {
		return idFacturaTemp;
	}

	public void setIdFacturaTemp(int idFacturaTemp) {
		this.idFacturaTemp = idFacturaTemp;
	}
	
	
}
