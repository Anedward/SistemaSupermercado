package com.megajaen.controlador;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.megajaen.entidades.DetalleFacturaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.on.ProductoON;

@ManagedBean(name = "shopcartMB")
@SessionScoped
public class CarritoController {

	private ProductoEN producto = new ProductoEN();
	private List<DetalleFacturaEN> cart = new ArrayList<>();

	private List<ProductoEN> listadoProducto;

	private int id;

	@Inject
	private ProductoON pON;

	
	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}

	public List<DetalleFacturaEN> getCart() {
		return cart;
	}

	public void setCart(List<DetalleFacturaEN> cart) {
		this.cart = cart;
	}

	public List<ProductoEN> getListadoProducto() {
		return listadoProducto;
	}

	public void setListadoProducto(List<ProductoEN> listadoProducto) {
		this.listadoProducto = listadoProducto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@PostConstruct
	public void init() {
		producto = new ProductoEN();
		// producto.agregarUsuario(new UsuarioEN());
		listadoProducto = pON.getListadoProductos();
	}

	public void loadData() {
		System.out.println("codigo editar " + id);
		if (id == 0)
			return;
		producto = pON.getProducto(id);
		System.out.println(producto.getCodigo() + " " + producto.getNombre());

	}

	public String cargarDatos() {
		try {
			pON.guardarProducto(producto);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String editar(int codigo) {

		return "Productos?faces-redirect=true&id=" + codigo;

	}

	public String borrar(int codigo) {
		System.out.println("codigo borrar " + codigo);

		try {
			pON.borrar(codigo);
			init();
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
			e.printStackTrace();
		}

		return null;

	}

	public String nuevo() {
		producto = new ProductoEN();
		return "productos";

	}

	public String listado() {
		return "listarProductos";

	}

	public String buscar() {
		pON.getListadoNombre(producto);
		return null;
	}

	public int getCartCount() {
		return listadoProducto.size();
	}

	private int isExisting(ProductoEN p) {
		for (int i = 0; i < this.cart.size(); i++)
			if (this.cart.get(i).getProducto().getCodigo() == p.getCodigo())
				return i;
		return -1;

	}

	public void delete(DetalleFacturaEN it) {
		this.cart.remove(it);
	}

	public long sum() {
		long s = 0;
		for (DetalleFacturaEN it : this.cart)
			s += it.getCantidad() * it.getProducto().getPrecioVenta();
		return s;
	}

	public String orderBy(ProductoEN p) {
		int index = isExisting(p);
		if (index == -1)
			this.cart.add(new DetalleFacturaEN(p,1));
		else {
			int cantidad = this.cart.get(index).getCantidad() + 1;
			this.cart.get(index).setCantidad(cantidad);
		}
		return "cart?face-redirect=true ";
	}
}
