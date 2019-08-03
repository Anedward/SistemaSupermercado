package com.megajaen.on;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.controlador.FacturaDetalleController;
import com.megajaen.dao.CategoriaDAO;
import com.megajaen.dao.FacturaDAO;
import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.DetalleFacturaEN;
import com.megajaen.entidades.FacturaEN;
import com.megajaen.entidades.ProductoEN;

@Stateless
public class FacturaON {
	@Inject
	private FacturaDAO facdao;
	
	@Inject
	private DetalleFacturaON detFacdao;
	
	public void guardar(FacturaEN fac){		
		facdao.save(fac);		
	}
	
	public String guardarDatosFac(DetalleFacturaEN detalle, FacturaEN factura, int p ) throws IOException {
		//facON.guardar(factura);
		//detON.guardar(DetalleFacturaEN detalle, factura, producto);
		detalle.setFactura(factura);
		//detalle.setProducto(producto);
		//System.out.println(producto);
		//System.out.println(factura);
		//System.out.println("Holaaa"+detalle.getFactura());
		//System.out.println("Holaaa"+producto.getNombre());
		
		
		//System.out.println(factura.toString());
		//System.out.println(detalle.toString());
		facdao.save(factura);
		
		//detFacdao.guardar(detalle,);
		return "factura";
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
