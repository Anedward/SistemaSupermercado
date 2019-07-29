package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.dao.ProveedorDAO;
import com.megajaen.entidades.ProveedorEN;


@Stateless
public class ProveedorON {

	@Inject
	private ProveedorDAO provdao;
	
	public void guardar(ProveedorEN prov){		
		provdao.save(prov);		
	}
	
	public List<ProveedorEN> getListadoProveedor(){
		return provdao.getProveedor2();
	}
	
	public void borrar(int codigo) throws Exception {
		try {
			provdao.delete(codigo);
		}catch(Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}	
	}
	
	public ProveedorEN getProveedor(int codigo) {
		ProveedorEN aux = provdao.read3(codigo);
		return aux;	
	}
}
