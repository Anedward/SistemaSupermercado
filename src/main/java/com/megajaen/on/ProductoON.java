package com.megajaen.on;

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
	

}
