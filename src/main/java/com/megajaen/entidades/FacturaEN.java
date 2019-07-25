package com.megajaen.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FacturaEN {
	@Id
	@Column(name = "fac_codigo")
	private int codigo;

	@Column(name = "fac_numeroFact")
	private String numFact;

	@Column(name = "fac_fechaEmision")
	private String fechaEmision;

	@Column(name = "fac_Total")
	private double total;

	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DetalleFacturaEN> items;

	public List<DetalleFacturaEN> getItems() {
		return items;
	}

	public void setItems(List<DetalleFacturaEN> items) {
		this.items = items;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumFact() {
		/*if (numFact == null) {
			this.numFact = "S0000001";
		} else {
			char r1 = numFact.charAt(4);
			char r2 = numFact.charAt(5);
			char r3 = numFact.charAt(6);
			char r4 = numFact.charAt(7);
			String juntar = "" + r1 + r2 + r3 + r4;
			int j = Integer.parseInt(juntar);
			GenerarCodigo gnum = new GenerarCodigo();
			gnum.GenerarCodigoProd(j);
			this.numFact= gnum.serie();

		}*/
		return numFact;
	}

	public void setNumFact(String numFact) {

		this.numFact = numFact;
	}

	public String getFechaEmision() {
		return new SimpleDateFormat("dd-MMMM-yyyy").format(new Date());
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void addItems(DetalleFacturaEN it) {
		if (items == null) {
			items = new ArrayList<>();
		}
		this.items.add(it);
	}

}

