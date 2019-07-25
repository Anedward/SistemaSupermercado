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

	public void save(ProveedorEN prov) {
		if (this.read(prov.getCodigo()) != null)
			this.update(prov);
		else
			this.create(prov);
	}

	public void create(ProveedorEN prov) {
		em.persist(prov);
	}

	public ProveedorEN read(int id) {
		return em.find(ProveedorEN.class, id);
	}
	
	public ProveedorEN readNombre(String nombre) {
		return em.find(ProveedorEN.class, nombre);
	}

	public ProveedorEN read2(int id) {
		ProveedorEN prov = em.find(ProveedorEN.class, id);
		prov.getProducto().size();
		return prov;
	}

	public ProveedorEN read3(int id) {
		String jpql = "SELECT prov " + "	 FROM ProveedorEN prov " + "		  JOIN FETCH prov.producto p "
				+ " WHERE prov.codigo = :a";
		Query q = em.createQuery(jpql, ProveedorEN.class);
		q.setParameter("a", id);
		ProveedorEN prov = (ProveedorEN) q.getSingleResult();

		return prov;
	}

	public void update(ProveedorEN prov) {
		em.merge(prov);
	}

	public void delete(int id) {
		ProveedorEN prov = read(id);
		em.remove(prov);
	}

	public List<ProveedorEN> getProveedor() {
		String jpql = "SELECT prov FROM ProveedorEN prov ";
		Query q = em.createQuery(jpql, ProveedorEN.class);
		List<ProveedorEN> proveedores = q.getResultList();
		return proveedores;
	}

	public List<ProveedorEN> getProveedor2() {
		String jpql = "SELECT prov FROM ProveedorEN prov ";
		Query q = em.createQuery(jpql, ProveedorEN.class);
		List<ProveedorEN> proveedores = q.getResultList();
		for (ProveedorEN prov : proveedores) {
			prov.getProducto().size();
		}

		return proveedores;
	}

	public List<ProveedorEN> getProveedorNombre(String filtroBusqued) {
		String jpql = "SELECT prov FROM ProveedorEN prov " + "	WHERE prov.razonsocial LIKE :filtro ";
		Query q = em.createQuery(jpql, ProveedorEN.class);
		q.setParameter("filtro", "%" + filtroBusqued + "%");
		List<ProveedorEN> proveedores = q.getResultList();
		return proveedores;
	}

}
