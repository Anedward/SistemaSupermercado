package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;

@Stateless
public class CategoriaDAO {

	@Inject
	private EntityManager em;

	public void save(CategoriaEN cat) {
		if (this.read(cat.getCodigo()) != null)
			this.update(cat);
		else
			this.create(cat);
	}

	public void create(CategoriaEN cat) {
		em.persist(cat);
	}

	public CategoriaEN read(int id) {
		return em.find(CategoriaEN.class, id);
	}
	
	public CategoriaEN readNombre(String nombre) {
		return em.find(CategoriaEN.class, nombre);
	}

	public CategoriaEN read2(int id) {
		CategoriaEN cat = em.find(CategoriaEN.class, id);
		cat.getProducto().size();
		return cat;
	}

	public CategoriaEN read3(int id) {
		String jpql = "SELECT cat " + "	 FROM CategoriaEN cat " + "		  JOIN FETCH cat.producto p "
				+ " WHERE cat.codigo = :a";
		Query q = em.createQuery(jpql, CategoriaEN.class);
		q.setParameter("a", id);
		CategoriaEN cat = (CategoriaEN) q.getSingleResult();

		return cat;
	}

	public void update(CategoriaEN cat) {
		em.merge(cat);
	}

	public void delete(int id) {
		CategoriaEN cat = read(id);
		em.remove(cat);
	}

	public List<CategoriaEN> getCategoria() {
		String jpql = "SELECT cat FROM CategoriaEN cat ";
		Query q = em.createQuery(jpql, CategoriaEN.class);
		List<CategoriaEN> categorias = q.getResultList();
		return categorias;
	}

	public List<CategoriaEN> getCategoria2() {
		String jpql = "SELECT cat FROM CategoriaEN cat ";
		Query q = em.createQuery(jpql, CategoriaEN.class);
		List<CategoriaEN> categorias = q.getResultList();
		for (CategoriaEN cat : categorias) {
			cat.getProducto().size();
		}

		return categorias;
	}

	public List<CategoriaEN> getCategoriaDescripcion(String filtroBusqued) {
		String jpql = "SELECT cat FROM CategoriaEN cat " + "	WHERE cat.descripcion LIKE :filtro ";
		Query q = em.createQuery(jpql, CategoriaEN.class);
		q.setParameter("filtro", "%" + filtroBusqued + "%");
		List<CategoriaEN> categorias = q.getResultList();
		return categorias;
	}
	
	public List<ProductoEN> getProductos2() {
		String jpql = "SELECT prod FROM ProductoEN prod";

		Query q = em.createQuery(jpql, ProductoEN.class);

		List<ProductoEN> productos = q.getResultList();
	//	for (Producto c : clientes) {
		//	c.getFacturas().size();
		//}
		return productos;

	}
	
	public List<ProductoEN> getProductos() {
		String jpql = "SELECT prod FROM ProductoEN prod";

		Query q = em.createQuery(jpql, ProductoEN.class);
		List<ProductoEN> prod = q.getResultList();
		return prod;

	}
	
	public ProductoEN read33(int id) {

		String jpql = "SELECT prod " + "	 FROM ProductoEN prod "
				+ " WHERE prod.codigo = :a";

		Query q = em.createQuery(jpql, ProductoEN.class);
		q.setParameter("a", id);
		ProductoEN prod = (ProductoEN) q.getSingleResult();

		return prod;

	}
	
	public ProductoEN readPro(int id) {
		return em.find(ProductoEN.class, id);

	}

	
	public void deletePro(int id) {
		ProductoEN prod = readPro(id);
		em.remove(prod);
	}


	public List<ProductoEN> getProductosPorNombre(String filtroBusqueda) {
		String jpql = "SELECT prod FROM ProductoEN prod" + "WHERE prod.codigo LIKE :filtro";

		Query q = em.createQuery(jpql, ProductoEN.class);
		q.setParameter("filtro", "%" + filtroBusqueda + "%");

		List<ProductoEN> prod = q.getResultList();
		return prod;

	}



}
