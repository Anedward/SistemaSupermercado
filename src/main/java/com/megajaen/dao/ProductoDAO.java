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
	
	public void save(ProductoEN prod) {
		if (this.read(prod.getCodigo()) != null)
			this.update(prod);
		else
			this.create(prod);
	}
	
	public void create(ProductoEN prod) {
		em.persist(prod);
	}

	public ProductoEN read(String id) {
		return em.find(ProductoEN.class, id);
	}

	public void update(ProductoEN prod) {
		em.merge(prod);
	}

	public void delete(String id) {
		ProductoEN prod = read(id);
		em.remove(prod);
	}

	public List<ProductoEN> listaProducto() {
		String jpql = "SELECT prod FROM ProductoEN prod";
		Query q = em.createQuery(jpql, ProductoEN.class);
		List<ProductoEN> productos = q.getResultList();
		return productos;
	}

	public List<ProductoEN> listaProductosPorNombre(String filtroBusqueda) {
		String jpql = "SELECT prod FROM ProductoEN prod " + "	WHERE prod.nombre LIKE :filtro ";
		Query q = em.createQuery(jpql, ProductoEN.class);
		q.setParameter("filtro", "%" + filtroBusqueda + "%");
		List<ProductoEN> productos = q.getResultList();
		return productos;
	}

}
