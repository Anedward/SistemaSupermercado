package com.megajaen.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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
//@SessionScoped
public class FacturaDetalleController {

	private DetalleFacturaEN detalle;
	private ProductoEN producto;
	private FacturaEN factura;

	private List<FacturaEN> listaFacturas;
	private List<ProductoEN> listaProductos;
	private List<DetalleFacturaEN> listaDetalles = new ArrayList<>();

	private int id;
	private String codBarra;

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

		factura = new FacturaEN();
		detalle = new DetalleFacturaEN();

		// listaFacturas = facON.getListadoFacturas();
		// listaProductos = proON.getListadoProductos();
	}

	public DetalleFacturaEN getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleFacturaEN detalle) {
		this.detalle = detalle;
	}

	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}

	public FacturaEN getFactura() {
		return factura;
	}

	public void setFactura(FacturaEN factura) {
		this.factura = factura;
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

	public List<DetalleFacturaEN> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<DetalleFacturaEN> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

	public void loadData() {
		System.out.println("codigo editar " + id);
		if (id == 0)
			return;
		factura = facON.getFactura(id);
		System.out.println(factura.getCodigo() + " " + factura.getFechaEmision());
		System.out.println("#detalles: " + " " + factura.getDetalle().size());
		for (DetalleFacturaEN det : factura.getDetalle()) {
			System.out.println("\t" + det);
		}
	}

	public String guardarDatos() throws IOException {
		for (DetalleFacturaEN det : factura.getDetalle()) {
			System.out.println("\t" + det);

			facON.guardar(factura);
			facON.guardarDet(det);
			init();
		}
		// System.out.println(factura.toString());
		// System.out.println(detalle.toString());
		return "detalle";
	}

	/*
	 * public String guardarDatosDet() throws IOException { detON.guardar(detalle);
	 * 
	 * //System.out.println(detalle); //System.out.println(detalle.toString());
	 * return "detalle"; }
	 */

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

	/*
	 * public Map<ProductoEN, Integer> getContenidoCarrito() { Map<ProductoEN,
	 * Integer> contenidoCarrito = new HashMap<>(); for (ProductoEN obj :
	 * listaProductos) { if (contenidoCarrito.containsKey(obj)) {
	 * contenidoCarrito.put(obj, contenidoCarrito.get(obj) + 1); } else {
	 * contenidoCarrito.put(obj, 1); } } return contenidoCarrito;
	 * 
	 * }
	 */

	/*
	 * public void addProductos(){ detalle.addProductos(new ProductoEN());
	 * System.out.println("Productos " + detalle.getProducto().size()); }
	 */

	public void addDetalles() {
		factura.addDetalles(new DetalleFacturaEN());
		System.out.println("Nuevo detalle" + factura.getDetalle().size());
	}

	public void agregarDatosProductoCod(){

        try {
            if (this.codBarra == null) {
                
            } else {
            	
                this.producto = proON.obtenerProducto(codBarra);
                
                if(this.producto != null){
                    this.listaDetalles.add(new DetalleFacturaEN(this.producto));
                    this.codBarra=null;
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se encontro el cliente", "ok"));
                }else{
                  this.codBarra=null;
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se encontro el registro", ";/"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
           
        }
    }
	
	public String TotalVenta(){
        String total;
        double precio = 0;
        try {
            for(DetalleFacturaEN d: listaDetalles){
               precio = precio+ d.getProducto().getPrecioVenta();
            }
            
        } catch (Exception e) {
            total = "0";
        }
        total = String.format("%.2f", precio);
        return total;
    }

}
