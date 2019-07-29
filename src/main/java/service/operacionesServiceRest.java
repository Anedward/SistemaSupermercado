package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.megajaen.entidades.ClienteEN;
import com.megajaen.entidades.UsuarioEN;
import com.megajaen.on.ClienteON;





@Path("/cliente")

public class operacionesServiceRest {

	@Inject
	private ClienteON clienteON;

	
	@GET
	@Path("listar")
	@Produces("application/json")
			
	public List<UsuarioEN> ge(){
		return clienteON.listadousuario();
		
	}
	
	/**@GET
	@Path("ingreso")
	@Produces("application/json")
	public List<UsuarioEN> ingreso(String email) {
		return clienteON.ingreso(email);
	}**/
	

}
