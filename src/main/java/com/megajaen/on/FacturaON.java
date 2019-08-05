package com.megajaen.on;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.megajaen.controlador.FacturaDetalleController;
import com.megajaen.dao.CategoriaDAO;
import com.megajaen.dao.DetalleFacturaDAO;
import com.megajaen.dao.FacturaDAO;
import com.megajaen.dao.ProductoDAO;
import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.DetalleFacturaEN;
import com.megajaen.entidades.FacturaEN;
import com.megajaen.entidades.ProductoEN;

@Stateless
public class FacturaON {
	@Inject
	private FacturaDAO facdao;

	@Inject
	private DetalleFacturaDAO daoDetFac;

	@Inject
	private ProductoDAO daoProd;

	@Inject
	private EntityManager em;
	
	public void guardar(FacturaEN fac){		
		facdao.save(fac);		
	}

	
	public List<FacturaEN> getListadoFacturas(){
		return facdao.getFacturas2();
	}
	
	
	public FacturaEN getFactura(int codigo) {
		FacturaEN aux = facdao.read3(codigo);
		return aux;	
	}
	
	

	public String guardarDet(DetalleFacturaEN detalle){	
		String redirect="";
		System.out.println("Hola detalle estas AHI " + detalle);
		//System.out.println(producto);
		//detalle.setProducto(producto);
		
		daoDetFac.save(detalle);
		//em.persist(producto);
		return redirect;
		
	}
	
	

	public FacturaEN consultarFactura(int codigoFactura) throws Exception {
		FacturaEN fac = facdao.read(codigoFactura);
		if (fac == null)
			throw new Exception("Factura  no existe");
		return fac;
	}
	
	public ProductoEN consultaProducto(int codigoProducto) throws Exception {

		ProductoEN prod = daoProd.read(codigoProducto);
		if (prod == null)
			throw new Exception("Producto  no existe");

		return prod;
	}
	
	public List<FacturaEN> getListadoFacturass() {
		return facdao.getFacturas2();

	}

	public FacturaEN getFacturas(int codigo) {

		FacturaEN aux = facdao.read3(codigo);

		return aux;
	}
	

	public DetalleFacturaEN buscarDetalle (int id) {
		DetalleFacturaEN producto = daoDetFac.buscarDetalles(id);
		return producto;
	}

	public void borrar(int codigo) throws Exception {
		try {
			facdao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}

	}

	public List<DetalleFacturaEN> getListadoDetalle() {
		return daoDetFac.listDetalles();
	}
	
	public FacturaEN obtenerUltimoRegistro() throws Exception {
		FacturaEN fac = facdao.obtenerUltimoRegistro();
		return fac;
	}
	
}
