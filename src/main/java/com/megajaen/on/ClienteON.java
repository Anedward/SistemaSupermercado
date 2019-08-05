package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.megajaen.controlador.preferencias;
import com.megajaen.dao.ClienteDAO;
import com.megajaen.entidades.ClienteEN;
import com.megajaen.entidades.UsuarioEN;


@Stateless
public class ClienteON {

	@Inject
	private ClienteDAO dao; // lo q tenga el servidor

	//@Inject
	//private instalacion init; // lo q tenga el servidor
	
	@Inject
	private preferencias pre;
	
	private List<UsuarioEN> usuarios;
	private UsuarioEN usuario;

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
	
	
	
	public List<UsuarioEN> listadousuarioLog(String un, String pass) {
		
		return dao.listadousuarioLog(un, pass);
		
	}
	
	
public List<UsuarioEN> listadousuario() {
		
		return dao.listadousuario();
		
	}

/**public List<UsuarioEN> ingreso(String email) {
	return dao.ingresoLogin(email);
}**/
	
public UsuarioEN Iniciar(String usua, String pass) {	
	try {
		if(usua!=null && pass!=null) {
			System.out.println("hola ");
			 usuarios = dao.listadousuarioLog(usua, pass);
			if(usuarios.size()>0) {
				usuario=usuarios.get(0);
				pre.setUsuario(usuarios.get(0));
				System.out.println("hola "+usuario.getEmailusuario());
				
			}else {
				FacesContext.getCurrentInstance().addMessage(
		                 null,
		                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário no encontrado!",
		                   "Error no Login!"));
		              return null;
		              	
			}			
		}
	}catch (Exception e) {
			System.out.println("error");
	}
	return usuario;
	
}
	
	

}