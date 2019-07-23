package com.megajaen.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.New;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.on.CategoriaON;

@ManagedBean
@ViewScoped
public class CategoriaController {

	private CategoriaEN categoria = new CategoriaEN();

	private int id;

	private List<CategoriaEN> listaCategorias;
	private List<String> listaCat;

	@Inject
	private FacesContext fc;

	@Inject
	private CategoriaON catON;

	@PostConstruct
	public void init() {
		categoria = new CategoriaEN();
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
		categoria = catON.getCategoria(id);
		System.out.println(categoria);
		if (categoria == null) {
			categoria = new CategoriaEN();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "El Registro no Existe", "Información");
			fc.addMessage(null, msg);
		}
		System.out.println(categoria);
	}

	public String editar(int codigo) {
		
		return "categoria?faces-redirect=true&id=" + codigo;
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
		}
		return listaCat;
		
	}
	
	public String nuevo() {
		categoria = new CategoriaEN();
		return "categoria";
	}
	
	public String listado() {
		return "listaCategoria";
	}

}