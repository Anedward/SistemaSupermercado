package com.megajaen.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.megajaen.entidades.ProveedorEN;
import com.megajaen.on.ProveedorON;

@ViewScoped
@ManagedBean(name = "proveedorMB")
public class ProveedorController {
	
	private ProveedorEN proveedor = new ProveedorEN();
	private List<ProveedorEN> listadoProveedor;
	private int id;
	@Inject
	private ProveedorON pON;
	
	
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

	@PostConstruct
	public void init() {
		proveedor = new ProveedorEN();
		listadoProveedor = pON.getListadoProveedor();
		
	}
	
	public void loadData() {
		System.out.println("codigo editar " + id);
		if (id == 0)
			return;
		proveedor = pON.getProveedor(id);
		System.out.println(proveedor.getCodigo() + " " + proveedor.getRazonSocial());
		
	}
	
	public String cargarDatos() {

		try {
			pON.guardar(proveedor);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String editar(int codigo) {

		return "proveedor?faces-redirect=true&id=" + codigo;
	}

	public String borrar(int codigo) {
		System.out.println("codigo borrar " + codigo);

		try {
			pON.borrar(codigo);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}
	
	public String nuevo() {
		proveedor = new ProveedorEN();
		return "proveedor";
	}


}
