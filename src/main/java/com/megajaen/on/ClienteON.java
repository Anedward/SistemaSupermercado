package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ClienteDAO;
import modelo.Cliente;
import modelo.Factura;
import modelo.TipoFactura;

@Stateless

public class ClienteON {

	@Inject
	private ClienteDAO dao; // lo q tenga el servidor

	@Inject
	private instalacion init; // lo q tenga el servidor

	public void guardar(Cliente c) throws Exception {

		if (c.getNombre().length() < 5)
			throw new Exception("Dimension corta");
		List<TipoFactura> tipos = init.getFact();
		for (Factura cli : c.getFacturas()) {
			for (TipoFactura tf : tipos) {
				if (cli.getIdTipo() == tf.getCodigo()) {
					cli.setTipo(tf);

				}

			}

		}

		dao.save(c);

	}

	public List<Cliente> getListadoClientes() {
		return dao.getClientes2();

	}

	public List<Cliente> getListadoNombre(Cliente c) {
		return dao.getClientesPorNombre(c.getNombre());
	}

	public void borrar(int codigo) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("error al borrar " + e.getMessage());
		}

	}

	public Cliente getCliente(int codigo) {

		Cliente aux = dao.read3(codigo);

		return aux;
	}

}
