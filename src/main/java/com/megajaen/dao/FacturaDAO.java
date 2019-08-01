package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.DetalleFacturaEN;
import com.megajaen.entidades.FacturaEN;


@Stateless
public class FacturaDAO {

	@Inject
	private EntityManager em;

	public void save(FacturaEN fac) {

		if (this.read(fac.getCodigo()) != null)
			this.update(fac);
		else {
			this.create(fac);
		}

	}

	public void create(FacturaEN fac) {
		em.persist(fac);

	}

	public FacturaEN read(int id) {
		return em.find(FacturaEN.class, id);

	}

	public FacturaEN read2(int id) {
		FacturaEN fac = em.find(FacturaEN.class, id);
		return fac;

	}

	public FacturaEN read3(int id) {

		String jpql = "SELECT fac " + "	 FROM FacturaEN fac " + " WHERE fac.codigo = :a";

		Query q = em.createQuery(jpql, FacturaEN.class);
		q.setParameter("a", id);
	    FacturaEN fac = (FacturaEN) q.getSingleResult();

		return fac;

	}

	public void update(FacturaEN fac) {
		em.merge(fac);

	}

	public void delete(int id) {
		FacturaEN fac = read(id);
		em.remove(fac);
	}

	public List<FacturaEN> getFacturas() {
		String jpql = "SELECT fac FROM FacturaEN fac";

		Query q = em.createQuery(jpql, FacturaEN.class);
		List<FacturaEN> fac = q.getResultList();
		return fac;

	}

	public List<FacturaEN> getFacturas2() {
		String jpql = "SELECT fac FROM FacturaEN fac";

		Query q = em.createQuery(jpql, FacturaEN.class);

		List<FacturaEN> factura = q.getResultList();

		return factura;

	}

	public List<FacturaEN> getFacturasPorNombre(String filtroBusqueda) {
		String jpql = "SELECT fac FROM FacturaEN fac" + "WHERE fac.codigo LIKE :filtro";

		Query q = em.createQuery(jpql, FacturaEN.class);
		q.setParameter("filtro", "%" + filtroBusqueda + "%");

		List<FacturaEN> fac = q.getResultList();
		return fac;

	}

	// public String idIncrement() {
	// String jpql = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE
	// TABLE_SCHEMA = 'megajaenbd' AND TABLE_NAME = 'facturaen'";
	// Query q = em.createNativeQuery(jpql);
	// List id =
	// return;
	// }
/*
	public String getPK() {
		// String jpql = "SELECT MAX(fac.codigo) FROM ClienteEN fac";
		String jpql = "SELECT fac.numFact FROM FacturaEN fac ORDER BY fac.codigo DESC";
		// --> vale String jpql = "SELECT fac.numFact FROM FacturaEN fac WHERE
		// fac.codigo = (SELECT MAX(fac.codigo) FROM FacturaEN fac)";
		
		// String jpql = "SELECT fac.numFact FROM FacturaEn fac";

		// Query q = em.createQuery(jpql);
		// FacturaEN fac = (FacturaEN) q.getSingleResult();
		// int id = (Integer) q.getSingleResult(entityManager =
		// this.entityManagerFactory.createEntityManager();;
		// return entityManager.createQuery("select max(u.id) from User u",
		// Integer.class).getSingleResult()
		Query codiFac = em.createQuery(jpql, String.class);
		Object obj = codiFac.setMaxResults(1).getResultList();
		String c = obj.toString();
		c.replace("[", "").replace("]", "");
		// return (Integer) em.createQuery(jpql).getSingleResult() <--- este vale;

		// --String c =(String) em.createQuery(jpql).getSingleResult();
		// String c = codiFac.getSingleResult().toString();
		// String fac
		// return em.createQuery(jpql);
		if (c.isEmpty()) {
			c = "S0000001";
			System.out.println("Ingreso" + c);
		}

		return c;
	}
*/
}

