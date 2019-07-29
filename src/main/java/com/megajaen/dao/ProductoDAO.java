package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;

@Stateless
public class ProductoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertarProducto (ProductoEN producto) {
		em.persist(producto);
	}
	
	public List<ProductoEN> listP(){
		String jpql = "SELECT cat FROM ProductoEN cat ";
		Query q = em.createQuery(jpql, ProductoEN.class);
		List<ProductoEN> categorias = q.getResultList();
		return categorias;
		
	}

}
