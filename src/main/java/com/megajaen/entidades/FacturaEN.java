package com.megajaen.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class FacturaEN {
	@Id
	@GeneratedValue
	@Column(name = "fac_codigo")
	private int codigo;

	@Column(name = "fac_numeroFact")
	private String numFact;

	@Column(name = "fac_fechaEmision")
	private String fechaEmision;

	@Column(name = "fac_iva")
	private double iva;
	
	@Column(name = "fac_Total")
	private double total;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="det_factura")
	@JsonIgnore
	private List<DetalleFacturaEN> detalle;

	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DetalleFacturaEN> listaDetalles;


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumFact() {
		return numFact;
	}

	public void setNumFact(String numFact) {
		this.numFact = numFact;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<DetalleFacturaEN> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<DetalleFacturaEN> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public List<DetalleFacturaEN> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleFacturaEN> detalle) {
		this.detalle = detalle;
	}
	
	public void addDetalles(DetalleFacturaEN det) {
		if(detalle==null) {
			detalle = new ArrayList<>();
		}
		this.detalle.add(det);
	}

	@Override
	public String toString() {
		return "FacturaEN [codigo=" + codigo + ", numFact=" + numFact + ", fechaEmision=" + fechaEmision + ", iva="
				+ iva + ", total=" + total + ", detalle=" + detalle + ", listaDetalles=" + listaDetalles + "]";
	}

	

	

}