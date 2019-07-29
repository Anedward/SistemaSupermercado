package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.dao.CategoriaDAO;
import com.megajaen.entidades.CategoriaEN;



@Stateless
public class CategoriaON {

	@Inject
	private CategoriaDAO catdao;
	
	public void guardar(CategoriaEN cat){		
		catdao.save(cat);		
	}
	
	public List<CategoriaEN> getListadoCategorias(){
		return catdao.getCategoria2();
	}
	
	public void borrar(int codigo) throws Exception {
		try {
			catdao.delete(codigo);
		}catch(Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}	
	}
	
	public CategoriaEN getCategoria(int codigo) {
		CategoriaEN aux = catdao.read3(codigo);
		return aux;	
	}
}
