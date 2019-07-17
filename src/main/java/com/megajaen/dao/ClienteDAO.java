package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cliente;

@Stateless

public class ClienteDAO {

	@Inject
	private EntityManager em;

	public void save(Cliente c) {

		if (this.read(c.getCodigo()) != null)
			this.update(c);
		else {
			this.create(c);
		}

	}

	public void create(Cliente c) {
		em.persist(c);

	}

	public Cliente read(int id) {
		return em.find(Cliente.class, id);

	}

	public Cliente read2(int id) {
		Cliente c = em.find(Cliente.class, id);
		return c;

	}

	public Cliente read3(int id) {

		String jpql = "SELECT c " + "	 FROM Cliente c " + "		  JOIN FETCH c.facturas f "
				+ " WHERE c.codigo = :a";

		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("a", id);
		Cliente c = (Cliente) q.getSingleResult();

		return c;

	}

	public void update(Cliente c) {
		em.merge(c);

	}

	public void delete(int id) {
		Cliente c = read(id);
		em.remove(c);
	}

	public List<Cliente> getClientes() {
		String jpql = "SELECT p FROM Cliente p";

		Query q = em.createQuery(jpql, Cliente.class);
		List<Cliente> clientes = q.getResultList();
		return clientes;

	}

	public List<Cliente> getClientes2() {
		String jpql = "SELECT p FROM Cliente p";

		Query q = em.createQuery(jpql, Cliente.class);

		List<Cliente> clientes = q.getResultList();
		for (Cliente c : clientes) {
			c.getFacturas().size();
		}
		return clientes;

	}

	public List<Cliente> getClientesPorNombre(String filtroBusqueda) {
		String jpql = "SELECT c FROM Cliente c" + "WHERE c.codigo LIKE :filtro";

		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("filtro", "%" + filtroBusqueda + "%");

		List<Cliente> clientes = q.getResultList();
		return clientes;

	}

}
