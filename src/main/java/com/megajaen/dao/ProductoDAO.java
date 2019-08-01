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
public ProductoEN buscarFoto (int id) {
		ProductoEN foto = em.find(ProductoEN.class, id);
		return foto;
	}
public List<ProductoEN> listP(){
		String jpql = "SELECT cat FROM ProductoEN cat ";
		Query q = em.createQuery(jpql, ProductoEN.class);
		List<ProductoEN> productos = q.getResultList();
		
		return productos;
		
	}

	@SuppressWarnings("unchecked")
	public List<ProductoEN> listarFotos(){
		String jpql = "SELECT f FROM ProductoEN f";
		Query query = em.createQuery(jpql, ProductoEN.class);
		List<ProductoEN> lfotos= query.getResultList();		
		return lfotos;
	}
	
	public ProductoEN buscarProducto (int id) {
		ProductoEN producto = em.find(ProductoEN.class, id);
		return producto;
	}
}
