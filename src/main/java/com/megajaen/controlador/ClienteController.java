package com.megajaen.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.megajaen.entidades.ClienteEN;
import com.megajaen.on.ClienteON;


@ManagedBean(name = "clienteMB")
@ViewScoped
public class ClienteController {

	private ClienteEN cliente = new ClienteEN();

	private List<ClienteEN> listadoClientes;
	
	private int id;

	@Inject
	private ClienteON pON;
	

	public ClienteEN getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEN cliente) {
		this.cliente = cliente;
	}

	public List<ClienteEN> getListadoClientes() {
		return listadoClientes;
	}

	public void setListadoClientes(List<ClienteEN> listadoClientes) {
		this.listadoClientes = listadoClientes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@PostConstruct
	public void init() {
		cliente = new ClienteEN();
		//cliente.agregarUsuario(new UsuarioEN());
		listadoClientes = pON.getListadoClientes();
	}

	public void loadData() {
		System.out.println("codigo editar " + id);
		if (id == 0)
			return;
		cliente = pON.getCliente(id);
		System.out.println(cliente.getCodigo() + " " + cliente.getNombre());

	}

	public String cargarDatos() {
		try {
			pON.guardar(cliente);
			init();
		} catch (Exception e) {
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

	public String nuevo() {
		cliente = new ClienteEN();
		return "clientesRegistro";

	}

	public String listado() {
		return "listarClientes";

	}

	public String buscar() {
		pON.getListadoNombre(cliente);
		return null;
	}

}
