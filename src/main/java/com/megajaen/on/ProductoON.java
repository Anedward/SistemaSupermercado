package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.megajaen.dao.CategoriaDAO;
import com.megajaen.dao.ProveedorDAO;
import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.entidades.ProveedorEN;



@Stateless
public class ProductoON {
	
	@Inject
	private CategoriaDAO daoCategoria;
	
	@Inject
	private ProveedorDAO daoProveedor;
	
	@Inject
	private EntityManager em;
	
	public void guardarProducto(ProductoEN producto) {
		em.persist(producto);
	}
	
	
	public CategoriaEN consultaCategoria(int codigoCategoria) throws Exception {
		
		
		CategoriaEN cat = daoCategoria.read(codigoCategoria);
		if(cat==null)
			throw new Exception("Categoria  no existe");
		
		return cat;
	}
	
public ProveedorEN consultaProveedor(int codigoProveedor) throws Exception {
		
		
		ProveedorEN prov = daoProveedor.read(codigoProveedor);
		if(prov==null)
			throw new Exception("Proveedor  no existe");
		
		return prov;
	}

public List<ProductoEN> getListadoProductos() {
	return daoCategoria.getProductos2();

}

public ProductoEN getProducto(int codigo) {

	ProductoEN aux = daoCategoria.read33(codigo);

	return aux;
}

public void borrar(int codigo) throws Exception {
	try {
		daoCategoria.deletePro(codigo);
	} catch (Exception e) {
		throw new Exception("error al borrar " + e.getMessage());
	}

}

public List<ProductoEN> getListadoNombre(ProductoEN prod) {
	return daoCategoria.getProductosPorNombre(prod.getNombre());
}



	

}
