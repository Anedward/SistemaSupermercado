package com.megajaen.controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.omnifaces.cdi.GraphicImageBean;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.entidades.ProveedorEN;
import com.megajaen.on.CategoriaON;
import com.megajaen.on.ProductoON;
import com.megajaen.on.ProveedorON;

@ManagedBean
@ViewScoped
@GraphicImageBean
//@ApplicationScoped
public class ProductoController {

	private ProductoEN producto;
	private UploadedFile file;
	private List<CategoriaEN> listaCategorias;
	private List<ProveedorEN> listaProveedores;
	private List<ProductoEN> listaProductos;

	@Inject
	private CategoriaON catON;

	@Inject
	private ProductoON prodON;

	@Inject
	private ProveedorON provON;

	@Inject
	private FacesContext fc;

	@PostConstruct
	public void init() {
		producto = new ProductoEN();
		listaCategorias = catON.getListadoCategorias();
		listaProveedores = provON.getListadoProveedor();
		listaProductos = prodON.getListadoProductos();
	}

	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}

	public List<CategoriaEN> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaEN> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public List<ProveedorEN> getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(List<ProveedorEN> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public List<ProductoEN> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoEN> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public String guardarDatos() throws IOException {
		upload();
		System.out.println("Holaaa+++++"+file);
		System.out.println("Holaaa ++++++ "+producto);
		prodON.guardarProductoImg(producto, file);
		System.out.println(producto);
		System.out.println(file);
		return "productos";
	}
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	
	
	
	public void consultarCategoria() {

		CategoriaEN cat;
		try {
			cat = prodON.consultaCategoria(producto.getIdCategoriaTemp());
			producto.setCategoria(cat);
		} catch (Exception e) {
			producto.setCategoria(null);
			// TODO Auto-generated catch block
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			fc.addMessage("txtCategoria", msg);

			e.printStackTrace();
		}

	}

	public void consultarProveedor() {

		ProveedorEN prov;
		try {
			prov = prodON.consultaProveedor(producto.getIdProveedorTemp());
			producto.setProveedor(prov);
		} catch (Exception e) {
			producto.setProveedor(null);
			// TODO Auto-generated catch block
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			fc.addMessage("txtProveedor", msg);

			e.printStackTrace();
		}

	}
	
	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Map<ProductoEN, Integer> getContenidoCarrito() {
		Map<ProductoEN, Integer> contenidoCarrito = new HashMap<>();
		for (ProductoEN obj : listaProductos) {
			if (contenidoCarrito.containsKey(obj)) {
				contenidoCarrito.put(obj, contenidoCarrito.get(obj) + 1);
			} else {
				contenidoCarrito.put(obj, 1);
			}
		}
		return contenidoCarrito;

	}
	
	/*public byte[] getBytes(int id) {
		producto = prodON.buscarProducto(88888);
		System.out.println(producto);
		System.out.println(producto.getCodigo());
		System.out.println(producto.getNombre());
		return producto.getImagen();
	}*/
	
	public byte[] getBytesFo() {
		listaProductos = prodON.getListadoFotos();
		System.out.println(producto);
		System.out.println(producto.getCodigo());
		System.out.println(producto.getNombre());
		return producto.getImagen();
	}
	
	

}


