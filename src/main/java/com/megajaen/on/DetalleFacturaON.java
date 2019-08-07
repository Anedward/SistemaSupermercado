package com.megajaen.on;

import java.io.IOException;
import java.util.ArrayList;
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

	private DetalleFacturaEN detalle;
	private ProductoEN p;
	private FacturaEN factura;

	private List<FacturaEN> listaFacturas;
	private List<ProductoEN> listaProductos;
	private List<DetalleFacturaEN> listaDetalles = new ArrayList<>();

	private int id;
	private String codBarra;
	private int cantidadProducto;
	private String productoSeleccionado;
	private String numeroFactura;

	@Inject
	private FacturaDAO daoFactura;

	@Inject
	private DetalleFacturaDAO daoDetFac;

	@Inject
	private ProductoDAO daoProd;

	@Inject
	private EntityManager em;

	public String guardar(DetalleFacturaEN detalle) {
		daoDetFac.save(detalle);
		return null;

	}

	public FacturaEN consultarFactura(int codigoFactura) throws Exception {
		FacturaEN fac = daoFactura.read(codigoFactura);
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
		return daoFactura.getFacturas2();

	}

	public FacturaEN getFacturas(int codigo) {
		FacturaEN aux = daoFactura.read3(codigo);
		return aux;
	}

	public DetalleFacturaEN buscarDetalle(int id) {
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

	private int isExisting(ProductoEN p) {
		for (int i = 0; i < this.listaDetalles.size(); i++)
			if (this.listaDetalles.get(i).getProducto().getCodigo() == p.getCodigo())
				return i;
		return -1;
	}

	public String orderBy(ProductoEN p) {
		
		int index = isExisting(p);
		if (index == -1)
			this.listaDetalles.add(new DetalleFacturaEN(p, 1));
		else {
			int cantidad = this.listaDetalles.get(index).getCantidad() + 1;
			this.listaDetalles.get(index).setCantidad(cantidad);
		}
		return null;
	}

}
