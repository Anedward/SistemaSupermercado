package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.CategoriaEN;

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

	public void update(CategoriaEN cat) {
		em.merge(cat);
	}

	public void delete(int id) {
		CategoriaEN cat = read(id);
		em.remove(cat);
	}

	public List<CategoriaEN> listaCategoria() {
		String jpql = "SELECT cat FROM CategoriaEN cat";
		Query q = em.createQuery(jpql, CategoriaEN.class);
		List<CategoriaEN> categorias = q.getResultList();
		return categorias;
	}

	public List<CategoriaEN> listaCategoriaPorNombre(String filtroBusqueda) {
		String jpql = "SELECT cat FROM CategoriaEN cat " + "	WHERE cat.descripcion LIKE :filtro ";
		Query q = em.createQuery(jpql, CategoriaEN.class);
		q.setParameter("filtro", "%" + filtroBusqueda + "%");
		List<CategoriaEN> categorias = q.getResultList();
		return categorias;
	}
}
