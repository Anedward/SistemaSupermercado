package com.megajaen.modelo;

public class EmpresaEN {

	private int codigo;
	private String razonSocial;
	private String ruc;
	private String direccion;

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

	public int getAnioCreacion() {
		return anioCreacion;
	}

	public void setAnioCreacion(int anioCreacion) {
		this.anioCreacion = anioCreacion;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	private int anioCreacion;
	private String logo;

}
