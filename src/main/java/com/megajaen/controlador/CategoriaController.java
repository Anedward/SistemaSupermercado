package com.megajaen.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.entidades.ProveedorEN;
import com.megajaen.on.CategoriaON;
import com.megajaen.on.ProveedorON;

@ManagedBean
@ViewScoped
public class CategoriaController {

	private CategoriaEN categoria = new CategoriaEN();
	private ProveedorEN proveedor=new ProveedorEN();

	private int id;

	private List<CategoriaEN> listaCategorias;
	private List<ProveedorEN> listaProveedores;
	private List<String> listaCat;
	private List<String> listaProv;

	@Inject
	private FacesContext fc;

	@Inject
	private CategoriaON catON;
	
	@Inject
	private ProveedorON provON;

	@PostConstruct
	public void init() {
		System.out.println("init " + categoria);
		listaCategorias = catON.listaCategorias();
	}

	public CategoriaEN getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEN categoria) {
		this.categoria = categoria;
	}

	public List<CategoriaEN> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaEN> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	

	public ProveedorEN getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEN proveedor) {
		this.proveedor = proveedor;
	}

	public List<ProveedorEN> getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(List<ProveedorEN> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String cargarDatos() {
		try {
			catON.guardar(categoria);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void loadData() {
		if (id == 0)
			return;
		System.out.println("codigo editar " + this.id);
		categoria = catON.getCategoria(this.id);
		if (categoria == null) {
			categoria = new CategoriaEN();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "El Registro no Existe", "Información");
			fc.addMessage(null, msg);
		}
		System.out.println(categoria);
	}

	public String editar(int codigo) {
		return "categorias?faces-redirect=true&id=" + codigo;
	}

	public String borrar(int codigo) {
		System.out.println("Codigo borrar " + codigo);
		try {
			catON.borrar(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public void addProducto() {
		categoria.addProducto(new ProductoEN());
		System.out.println("Productos" + categoria.getProducto().size());
	}
	
	public List<String> comboCat(){
		listaCategorias = catON.listaCategorias();
		listaCat= new ArrayList<>();
		
		for (CategoriaEN cate : listaCategorias) {
			listaCat.add(cate.getDescripcion());
			System.out.println(cate.getCodigo());
		}
		return listaCat;
		
	}
	
	public List<String> comboProv(){
		listaProveedores=provON.getListadoProveedor();
		listaProv=new ArrayList<>();
		for (ProveedorEN prove : listaProveedores) {
			listaProv.add(prove.getRazonSocial());
			System.out.println(prove.getCodigo());
			
		}
		return listaProv;
		
	}
	
	public String nuevo() {
		categoria = new CategoriaEN();
		return "categoria";
	}
	
	public String nuevoProveedor() {
		//proveedor = new ProveedorEN();
		return "proveedor";
	}
	
	public String nuevoPrincipal() {
		//proveedor = new ProveedorEN();
		return "productos";
	}

}