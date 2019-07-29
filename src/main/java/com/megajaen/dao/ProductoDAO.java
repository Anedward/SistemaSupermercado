package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.ProductoEN;

@Stateless
public class ProductoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertarProducto (ProductoEN producto) {
		em.persist(producto);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductoEN> ListarFotos(){
		String jpql = "SELECT f FROM ProductoEN f";
		Query query = em.createQuery(jpql, ProductoEN.class);
		List<ProductoEN> lfotos= query.getResultList();		
		return lfotos;
	}

}
