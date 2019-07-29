package com.megajaen.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.on.CategoriaON;

@ManagedBean
@ViewScoped
public class CategoriaController {

	private CategoriaEN categoria = new CategoriaEN();
	private CategoriaEN cate;
	private List<CategoriaEN> listaCategorias;
	
	private int id;
	
	@Inject
	private CategoriaON catON;
	
	private int codCat;
	
	@PostConstruct
	public void init() {
		categoria = new CategoriaEN();
		//categoria.addProducto(new ProductoEN());
		listaCategorias = catON.getListadoCategorias();
	}
	
	public void loadData() {
		System.out.println("codigo editar " + id);
		if(id==0)
			return;
		categoria = catON.getCategoria(id);
		System.out.println(categoria.getCodigo() + " " + categoria.getDescripcion() );
		System.out.println("#telefonos: " + " " + categoria.getProducto().size());
		for(ProductoEN prod : categoria.getProducto()) {
			System.out.println("\t"+prod);
		}		
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

	public CategoriaEN getCate() {
		return cate;
	}

	public void setCate(CategoriaEN cate) {
		this.cate = cate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodCat() {
		return codCat;
	}

	public void setCodCat(int codCat) {
		this.codCat = codCat;
	}
	
	public CategoriaEN getCategoria(int codigoCat) {
		
		if(codigoCat == 0) {
			throw new IllegalArgumentException("Codigo invalido");
		}
		for(CategoriaEN categoria : listaCategorias) {
			if (codigoCat == (categoria.getCodigo())) {
				return categoria;
		}
		
	}
		return null;
	}

	public String cargarDatos() {
		
		try {
			catON.guardar(categoria);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String editar(int codigo) {
		
		return "categoria?faces-redirect=true&id="+codigo;
	}
	
	public String borrar(int codigo) {
		System.out.println("codigo borrar " + codigo);
		
		try {
			catON.borrar(codigo);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error "+ e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
/*	public void addProducto(){
		categoria.addProducto(new ProductoEN());
		System.out.println("cnt " + categoria.getProducto().size());
	}*/
	
	public String nuevo() {
		categoria = new CategoriaEN();
		return "categoria";
	}
	
	public String listado() {
		return "listaCategoria";
	}
}
