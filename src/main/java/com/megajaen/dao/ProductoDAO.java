package com.megajaen.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.megajaen.entidades.ProductoEN;

@Stateless
public class ProductoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertarProducto (ProductoEN producto) {
		em.persist(producto);
	}

}
