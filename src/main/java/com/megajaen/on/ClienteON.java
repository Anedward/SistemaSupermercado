package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.megajaen.controlador.preferencias;
import com.megajaen.dao.ClienteDAO;
import com.megajaen.entidades.ClienteEN;


@Stateless
public class ClienteON {

	@Inject
	private ClienteDAO dao;

	public void guardar(ClienteEN c) throws Exception {

		if (c.getNombre() == null)
			throw new Exception("Error: No puede ir campos vacios");
		dao.save(c);

	}

	public List<ClienteEN> getListadoClientes() {
		return dao.getClientes2();

	}
	
	public ClienteEN getClienteCedula(String nombre) {
		return dao.getClienteCedula(nombre);

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
	
	public ClienteEN Iniciar(String usua, String pass) {	

	return dao.usuario(usua, pass);
	
}
	
	

}