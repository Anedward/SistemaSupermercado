package com.megajaen.controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.DetalleFacturaEN;
import com.megajaen.entidades.FacturaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.entidades.ProveedorEN;
import com.megajaen.on.CategoriaON;
import com.megajaen.on.DetalleFacturaON;
import com.megajaen.on.FacturaON;
import com.megajaen.on.ProductoON;
import com.megajaen.on.ProveedorON;


@ManagedBean
@ViewScoped
public class DetalleFacturaController {
	
	private DetalleFacturaEN detalle;
	private List<FacturaEN> listaFacturas;
	private List<ProductoEN> listaProductos;

	@Inject
	private FacturaON facON;
	
	@Inject
	private ProductoON proON;
	
	@Inject
	private DetalleFacturaON detON;


	@Inject
	private FacesContext fc;

	@PostConstruct
	public void init() {
		detalle = new DetalleFacturaEN();
		//listaFacturas = facON.getListadoFacturas();
		listaProductos = proON.getListadoProductos();
	}	

	public DetalleFacturaEN getDetalle() {
		return detalle;
	}
	
	public void setDetalle(DetalleFacturaEN detalle) {
		this.detalle = detalle;
	}
	public List<FacturaEN> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<FacturaEN> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	
	
	public List<ProductoEN> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoEN> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String guardarDatos() throws IOException {
	
		detON.guardar(detalle);
		System.out.println(detalle);
		return "detalle";
	}
	
	
	public void consultarFactura() {

		FacturaEN fac;
		try {
			fac = detON.consultarFactura(detalle.getIdFacturaTemp());
			detalle.setFactura(fac);
		} catch (Exception e) {
			detalle.setFactura(null);
			// TODO Auto-generated catch block
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			fc.addMessage("txtFactura", msg);
			e.printStackTrace();
		}

	}
	
	public void consultarProducto() {

		ProductoEN prod;
		try {
			prod = detON.consultaProducto(detalle.getIdProductoTemp());
			System.out.println("Producto");
			detalle.setProducto(prod);
		} catch (Exception e) {
			detalle.setProducto(null);
			// TODO Auto-generated catch block
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			fc.addMessage("txtProducto", msg);

			e.printStackTrace();
		}

	}

	/*public Map<ProductoEN, Integer> getContenidoCarrito() {
		Map<ProductoEN, Integer> contenidoCarrito = new HashMap<>();
		for (ProductoEN obj : listaProductos) {
			if (contenidoCarrito.containsKey(obj)) {
				contenidoCarrito.put(obj, contenidoCarrito.get(obj) + 1);
			} else {
				contenidoCarrito.put(obj, 1);
			}
		}
		return contenidoCarrito;

	}*/
	
	/*public void addProductos(){
		detalle.addProductos(new ProductoEN());
		System.out.println("Productos " + detalle.getProducto().size());
	}*/

}
