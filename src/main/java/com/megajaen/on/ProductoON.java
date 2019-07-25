package com.megajaen.on;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.megajaen.dao.CategoriaDAO;
import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;



@Stateless
public class ProductoON {
	
	@Inject
	private CategoriaDAO daoCategoria;
	
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

}
