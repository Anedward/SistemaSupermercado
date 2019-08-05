package com.megajaen.dao;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import com.megajaen.entidades.ProductoEN;



@Named
@ApplicationScoped
public class ImageBean {
	
	private ProductoEN foto;
	
	@EJB
	private ProductoDAO service;
	
	public byte[] getBytes(int id) {
		foto= service.buscarFoto(id);
		return foto.getImagen();
	}

}
