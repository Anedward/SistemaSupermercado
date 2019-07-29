package com.megajaen.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.entidades.ProveedorEN;
import com.megajaen.on.ProveedorON;

@ManagedBean
@ViewScoped
public class ProveedorController {

	private ProveedorEN proveedor = new ProveedorEN ();
	private List<ProveedorEN> listadoProveedor;
	
	private int id;
	
	@Inject
	private ProveedorON provON;
	
	private int codProv;
	
	@PostConstruct
	public void init() {
		proveedor = new ProveedorEN ();
		
		listadoProveedor = provON.getListadoProveedor();
	}
	
	public void loadData() {
		System.out.println("codigo editar " + id);
		if(id==0)
			return;
		proveedor = provON.getProveedor(id);
		System.out.println(proveedor.getCodigo() + " " + proveedor.getRazonSocial() );
		System.out.println("#Proveedor: " + " " + proveedor.getProducto().size());
		for(ProductoEN prod : proveedor.getProducto()) {
			System.out.println("\t"+prod);
		}		
	}
	

	public ProveedorEN getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEN proveedor) {
		this.proveedor = proveedor;
	}

	public List<ProveedorEN> getListadoProveedor() {
		return listadoProveedor;
	}

	public void setListadoProveedor(List<ProveedorEN> listadoProveedor) {
		this.listadoProveedor = listadoProveedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getCodProv() {
		return codProv;
	}

	public void setCodProv(int codProv) {
		this.codProv = codProv;
	}

	public ProveedorEN getProveedor(int codigoPro) {
		
		if(codigoPro == 0) {
			throw new IllegalArgumentException("Codigo invalido");
		}
		for(ProveedorEN  proveedor : listadoProveedor) {
			if (codigoPro == (proveedor.getCodigo())) {
				return proveedor;
		}
		
	}
		return null;
	}

	public String cargarDatos() {
		
		try {
			provON.guardar(proveedor);
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
			provON.borrar(codigo);
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
		proveedor = new ProveedorEN();
		return "proveedor";
	}
	
}
