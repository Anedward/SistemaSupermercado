package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.dao.CategoriaDAO;
import com.megajaen.dao.FacturaDAO;
import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.DetalleFacturaEN;
import com.megajaen.entidades.FacturaEN;

@Stateless
public class FacturaON {
	@Inject
	private FacturaDAO facdao;
	
	public void guardar(FacturaEN fac){		
		facdao.save(fac);		
	}
	
	public List<FacturaEN> getListadoFacturas(){
		return facdao.getFacturas2();
	}
	
	public void borrar(int codigo) throws Exception {
		try {
			facdao.delete(codigo);
		}catch(Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}	
	}
	
	public FacturaEN getFactura(int codigo) {
		FacturaEN aux = facdao.read3(codigo);
		return aux;	
	}
	
}
