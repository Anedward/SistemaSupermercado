package com.megajaen.dao;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.AdministradorEN;

@Stateless
public class AdministradorDAO {
	
	@Inject
	private EntityManager em;

	/*public List<UsuarioEN> listadousuarioLog(String un, String pass) {
		String  jpql = "SELECT u FROM UsuarioEN u WHERE u.emailusuario=:un AND u.contrasenia=:pass";
		Query query = em.createQuery(jpql, UsuarioEN.class);
		query.setParameter("un", un);
		query.setParameter("pass", pass);
		List<UsuarioEN> listado = query.getResultList();
		return listado;
	}*/
	
	
	public AdministradorEN usuario(String usu, String pass) {
		String  jpql = "SELECT u FROM AdministradorEN u WHERE u.usuario=?1 AND u.password=?2";
		Query  query = em.createQuery(jpql, AdministradorEN.class);
		query.setParameter(1, usu);
		query.setParameter(2, pass);
		AdministradorEN admin = (AdministradorEN) query.getSingleResult();
		return admin;
	}
}
