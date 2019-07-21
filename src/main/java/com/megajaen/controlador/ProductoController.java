package com.megajaen.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.megajaen.entidades.ProductoEN;
import com.megajaen.on.ProductoON;

@ManagedBean
@ViewScoped
public class ProductoController {
	
	private ProductoEN producto = new ProductoEN();

	private String id;

	private List<ProductoEN> listaProductos;

	@Inject
	private FacesContext fc;

	@Inject
	private ProductoON prodON;

	@PostConstruct
	public void init() {
		System.out.println("init " + producto);
		listaProductos = prodON.listaProductos();
	}

	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ProductoEN> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoEN> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String cargarDatos() {
		try {
			prodON.guardar(producto);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void loadData() {
		if (id == " ")
			return;
		System.out.println("codigo editar " + this.id);
		producto = prodON.getProducto(this.id);
		if (producto == null) {
			producto = new ProductoEN();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "El Registro no Existe", "Información");
			fc.addMessage(null, msg);
		}
		System.out.println(producto);
	}

	public String editar(String codigo) {
		return "productos?faces-redirect=true&id=" + codigo;
	}

	public String borrar(String codigo) {
		System.out.println("Codigo borrar " + codigo);
		try {
			prodON.borrar(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public String nuevo() {
		producto = new ProductoEN();
		return "productos";
	}

	public String listado() {
		return "listaProductos";
	}


}
