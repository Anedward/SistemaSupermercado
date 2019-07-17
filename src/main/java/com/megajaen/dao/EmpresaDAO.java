package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.EmpresaEN;

@Stateless
public class EmpresaDAO {

	@Inject
	private EntityManager em;
	
	public void save(EmpresaEN emp) {
		if (this.read(emp.getCodigo()) != null)
			this.update(emp);
		else
			this.create(emp);
	}
	
	public void create(EmpresaEN emp) {
		em.persist(emp);
	}

	public EmpresaEN read(int id) {
		return em.find(EmpresaEN.class, id);
	}

	public void update(EmpresaEN emp) {
		em.merge(emp);
	}

	public void delete(int id) {
		EmpresaEN emp = read(id);
		em.remove(emp);
	}

	public List<EmpresaEN> listaEmpresa() {
		String jpql = "SELECT emp FROM EmpresaEN emp";
		Query q = em.createQuery(jpql, EmpresaEN.class);
		List<EmpresaEN> empresas = q.getResultList();
		return empresas;
	}

	public List<EmpresaEN> listaEmpresaPorNombre(String filtroBusqueda) {
		String jpql = "SELECT emp FROM EmpresaEN emp " + "	WHERE emp.descripcion LIKE :filtro ";
		Query q = em.createQuery(jpql, EmpresaEN.class);
		q.setParameter("filtro", "%" + filtroBusqueda + "%");
		List<EmpresaEN> empresas = q.getResultList();
		return empresas;
	}
}