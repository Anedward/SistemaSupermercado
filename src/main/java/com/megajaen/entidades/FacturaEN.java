package com.megajaen.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class FacturaEN {
	@Id
	private String codigo;
	private Date fechaEmision;
	private double iva;
	private double total;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
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

}
