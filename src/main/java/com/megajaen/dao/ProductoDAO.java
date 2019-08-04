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

	public List<ProductoEN> listP(){
		String jpql = "SELECT cat FROM ProductoEN cat ";
		Query q = em.createQuery(jpql, ProductoEN.class);
		List<ProductoEN> productos = q.getResultList();
		
		return productos;
		
	}

	/*@SuppressWarnings("unchecked")
	public List<ProductoEN> listarFotos(){
		String jpql = "SELECT f FROM ProductoEN f";
		Query query = em.createQuery(jpql, ProductoEN.class);
		List<ProductoEN> lfotos= query.getResultList();		
		return lfotos;
	}*/
	
	public ProductoEN buscarProducto (int id) {
		ProductoEN producto = em.find(ProductoEN.class, id);
		return producto;
	}
	
	
	
	public ProductoEN read(int id) {
		return em.find(ProductoEN.class, id);
	}
	
	 public ProductoEN obtenerProducto(String codBarra) {
	        String jpql = "SELECT prod FROM ProductoEN prod WHERE prod.codBarra = :codBarra";
	        Query q = em.createQuery(jpql, ProductoEN.class);
	        q.setParameter("codBarra", codBarra);
	        ProductoEN prod = (ProductoEN) q.getSingleResult();
	       return prod;
	    }
	

}
