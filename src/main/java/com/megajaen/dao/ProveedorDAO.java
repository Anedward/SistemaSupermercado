package com.megajaen.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.megajaen.entidades.ProveedorEN;

@Stateless
public class ProveedorDAO {
	
	private EntityManager em;
	
	public void create (ProveedorEN pro) {
		em.persist(pro);
	}

}
