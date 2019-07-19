package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.ProveedorEN;

@Stateless
public class ProveedorDAO {

	@Inject
	private EntityManager em;

	public void save(ProveedorEN p) {

		if (this.read(p.getCodigo()) != null)
			this.update(p);
		else
			this.create(p);
	}

	public void create(ProveedorEN p) {
		em.persist(p);
	}

	public ProveedorEN read(int id) {
		return em.find(ProveedorEN.class, id);
	}

	public void update(ProveedorEN p) {
		em.merge(p);
	}

	public void delete(int id) {
		ProveedorEN p = read(id);
		em.remove(p);
	}

	public List<ProveedorEN> getProveedor() {
		String jpql = "SELECT p FROM ProveedorEN p ";

		Query q = em.createQuery(jpql, ProveedorEN.class);

		List<ProveedorEN> proveedor = q.getResultList();
		return proveedor;

	}

}
