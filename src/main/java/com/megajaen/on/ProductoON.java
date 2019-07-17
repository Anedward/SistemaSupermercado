package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.dao.ProductoDAO;
import com.megajaen.entidades.ProductoEN;

@Stateless
public class ProductoON {
	
	@Inject
	private ProductoDAO prodao;

	public void guardar(ProductoEN prod) throws Exception {
		if (prod.getNombre().length() < 5)
			throw new Exception("Dimension corta");
		prodao.save(prod);
	}

	public List<ProductoEN> listaProductos() {
		return prodao.listaProducto();
	}

	public void borrar(String codigo) throws Exception {
		try {
			prodao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al eliminar producto " + e.getMessage());
		}
	}

	public ProductoEN getProducto(String codigo) {
		ProductoEN auxpro = prodao.read(codigo);
		return auxpro;
	}

}
