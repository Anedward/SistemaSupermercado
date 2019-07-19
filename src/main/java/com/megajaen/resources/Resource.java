package com.megajaen.resources;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
<<<<<<< HEAD
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resource {
	
	@Produces
	@PersistenceContext
	private EntityManager em;
	
	
	@Produces
	@RequestScoped
	public FacesContext prodiceFC() {
=======

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resource {
	
	
	@Produces
	@PersistenceContext
	private EntityManager em;
	
	@Produces
	@RequestScoped
	public FacesContext produceFC() {
>>>>>>> refs/remotes/origin/Andrew
		return FacesContext.getCurrentInstance();
	}

}
