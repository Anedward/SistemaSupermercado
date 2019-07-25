package com.megajaen.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProveedorEN {
	@Id
	@Column(name="prov_codigo")
	private int codigo;
	@Column(name="prov_razon")
	private String razonSocial;
	@Column(name="prov_ruc")
	private String ruc;
	@Column(name="prov_direccion")
	private String direccion;
	@Column(name="prov_telefono")
	private String telefono;
	@Column(name="prov_email")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="prove_producto")
	@JsonIgnore
	private List<ProductoEN> producto;
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ProductoEN> getProducto() {
		return producto;
	}

	public void setProducto(List<ProductoEN> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "ProveedorEN [codigo=" + codigo + ", razonSocial=" + razonSocial + ", ruc=" + ruc + ", direccion="
				+ direccion + ", telefono=" + telefono + ", email=" + email + ", producto=" + producto + "]";
	}

	public void addProducto(ProductoEN prod) {
		if(producto==null) {
			producto = new ArrayList<>();
		}
		this.producto.add(prod);
	}
	

	
	
}
