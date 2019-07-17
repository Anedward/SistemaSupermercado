package com.megajaen.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import bussines.ClienteON;
import bussines.instalacion;

import modelo.Cliente;
import modelo.Factura;
import modelo.TipoFactura;

@ManagedBean
@ViewScoped
public class ClienteController {

	private Cliente cliente = new Cliente();
	private TipoFactura fa = new TipoFactura();

	private List<Cliente> listadoClientes;
	private List<TipoFactura> tipFac;
	private List<String> listaP;
	private List<Integer> au;
	private int id;

	@Inject
	private ClienteON pON;
	@Inject
	private instalacion iON;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListadoClientes() {
		return listadoClientes;
	}

	public void setListadoClientes(List<Cliente> listadoClientes) {
		this.listadoClientes = listadoClientes;
	}

	public List<TipoFactura> getTipFac() {
		return tipFac;
	}

	public TipoFactura getFa() {
		return fa;
	}

	public void setFa(TipoFactura fa) {
		this.fa = fa;
	}

	public void setTipFac(List<TipoFactura> tipFac) {
		this.tipFac = tipFac;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getListaP() {
		return listaP;
	}

	public void setListaP(List<String> listaP) {
		this.listaP = listaP;
	}

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		cliente.addFactura(new Factura());
		fa = new TipoFactura();
		listadoClientes = pON.getListadoClientes();
	}

	public void loadData() {
		System.out.println("codigo editar " + id);
		if (id == 0)
			return;
		cliente = pON.getCliente(id);
		System.out.println(cliente.getCodigo() + " " + cliente.getNombre());
		// System.out.println("#facturas: " + " " + cliente.size());
		for (Factura c : cliente.getFacturas()) {
			System.out.println("\t " + c);

		}

	}

	public String cargarDatos() {
		try {
			pON.guardar(cliente);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String editar(int codigo) {

		return "Clientes?faces-redirect=true&id=" + codigo;

	}

	public String borrar(int codigo) {
		System.out.println("codigo borrar " + codigo);

		try {
			pON.borrar(codigo);
			init();
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
			e.printStackTrace();
		}

		return null;

	}

	public void addFactura() {
		cliente.addFactura(new Factura());
		System.out.println("Facturas" + cliente.getFacturas().size());

	}

	public String nuevo() {
		cliente = new Cliente();

		return "cliente";

	}

	public String listado() {

		return "listadoClientes";

	}

	public List<String> fac1() {
		tipFac = iON.getFact();
		listaP = new ArrayList<>();

		for (TipoFactura tp1 : tipFac) {

			listaP.add(tp1.getDescripcion());
		}
		return listaP;

	}

	public String buscar() {
		pON.getListadoNombre(cliente);
		return null;

	}

}
