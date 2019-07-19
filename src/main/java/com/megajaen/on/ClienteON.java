package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.dao.ClienteDAO;
import com.megajaen.modelo.ClienteEN;


@Stateless
public class ClienteON {

	@Inject
	private ClienteDAO dao; // lo q tenga el servidor

	//@Inject
	//private instalacion init; // lo q tenga el servidor

	public void guardar(ClienteEN c) throws Exception {

		if (c.getNombre() == null)
			throw new Exception("Error: No puede ir campos vacios");
		dao.save(c);

	}

	public List<ClienteEN> getListadoClientes() {
		return dao.getClientes2();

	}

	public List<ClienteEN> getListadoNombre(ClienteEN c) {
		return dao.getClientesPorNombre(c.getNombre());
	}

	public void borrar(int codigo) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("error al borrar " + e.getMessage());
		}

	}

	public ClienteEN getCliente(int codigo) {

		ClienteEN aux = dao.read3(codigo);

		return aux;
	}

}
