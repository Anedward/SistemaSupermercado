package com.megajaen.on;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import com.megajaen.dao.CategoriaDAO;
import com.megajaen.dao.DetalleFacturaDAO;
import com.megajaen.dao.FacturaDAO;
import com.megajaen.dao.ProductoDAO;
import com.megajaen.dao.ProveedorDAO;
import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.DetalleFacturaEN;
import com.megajaen.entidades.FacturaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.entidades.ProveedorEN;

@Stateless
public class DetalleFacturaON {
	
	@Inject
	private FacturaDAO daoFactura;

	@Inject
	private DetalleFacturaDAO daoDetFac;

	@Inject
	private EntityManager em;

	public void guardar(DetalleFacturaEN detalle){		
		daoDetFac.insertarDetalle(detalle);
	}


	public FacturaEN consultarFactura(int codigoFactura) throws Exception {
		FacturaEN fac = daoFactura.read(codigoFactura);
		if (fac == null)
			throw new Exception("Factura  no existe");
		return fac;
	}
	
	public List<FacturaEN> getListadoFacturass() {
		return daoFactura.getFacturas2();

	}

	public FacturaEN getFacturas(int codigo) {

		FacturaEN aux = daoFactura.read3(codigo);

		return aux;
	}
	

	public DetalleFacturaEN buscarDetalle (int id) {
		DetalleFacturaEN producto = daoDetFac.buscarDetalles(id);
		return producto;
	}

	public void borrar(int codigo) throws Exception {
		try {
			daoFactura.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}

	}

	public List<DetalleFacturaEN> getListadoDetalle() {
		return daoDetFac.listDetalles();
	}

}
