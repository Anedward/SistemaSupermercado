package com.megajaen.on;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import com.megajaen.dao.CategoriaDAO;
import com.megajaen.dao.ProductoDAO;
import com.megajaen.dao.ProveedorDAO;
import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.entidades.ProveedorEN;

@Stateless
public class ProductoON {

	@Inject
	private CategoriaDAO daoCategoria;

	@Inject
	private ProveedorDAO daoProveedor;

	@Inject
	private ProductoDAO daoProducto;

	@Inject
	private EntityManager em;

	public String guardarProductoImg(ProductoEN producto, UploadedFile file) throws IOException  {
		String redirect ="";
		System.out.println("llego");
		System.out.println(producto);
		System.out.println(file);
		producto.setImagen(IOUtils.toByteArray(file.getInputstream()));
		
		daoProducto.insertarProducto(producto);
		//em.persist(producto);
		return redirect;
				
	}

	public void guardarProducto(ProductoEN producto) {
		em.persist(producto);
	}

	
	public CategoriaEN consultaCategoria(int codigoCategoria) throws Exception {

		CategoriaEN cat = daoCategoria.read(codigoCategoria);
		if (cat == null)
			throw new Exception("Categoria  no existe");

		return cat;
	}

	public ProveedorEN consultaProveedor(int codigoProveedor) throws Exception {

		ProveedorEN prov = daoProveedor.read(codigoProveedor);
		if (prov == null)
			throw new Exception("Proveedor  no existe");

		return prov;
	}

	public List<ProductoEN> getListadoProductos() {
		return daoCategoria.getProductos2();

	}
	
	/*public List<ProductoEN> listadoFotos() {
		return daoProducto.listarFotos();

	}*/

	public ProductoEN getProducto(int codigo) {

		ProductoEN aux = daoCategoria.read33(codigo);

		return aux;
	}
	

	public ProductoEN buscarProducto (int id) {
		ProductoEN producto = daoProducto.buscarProducto(id);
		return producto;
	}

	public void borrar(int codigo) throws Exception {
		try {
			daoCategoria.deletePro(codigo);
		} catch (Exception e) {
			throw new Exception("error al borrar " + e.getMessage());
		}

	}

	public List<ProductoEN> getListadoNombre(ProductoEN prod) {
		return daoCategoria.getProductosPorNombre(prod.getNombre());
	}
	

	public List<ProductoEN> getListadoProd() {
		return daoProducto.listP();
	}

	public String verProducto(ProductoEN producto, int id) {
		String redirect = null;
		producto = daoProducto.buscarProducto(id);
		
			redirect = "verProducto?faces-redirect=true&id=" + producto.getCodigo();
		return redirect;
	}
	

	public ProductoEN obtenerProducto( String codBarra) throws Exception {
		return daoProducto.obtenerProducto(codBarra);
	} 
	

}

