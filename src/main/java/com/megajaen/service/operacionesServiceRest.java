package com.megajaen.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.megajaen.entidades.AdministradorEN;
import com.megajaen.entidades.ClienteEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.on.AdministradorON;
import com.megajaen.on.ClienteON;
import com.megajaen.on.ProductoON;


@Path("/cliente")

public class operacionesServiceRest {

	private ProductoEN prod;
	
	@Inject
	private ClienteON clienteON;

	@Inject
	private ProductoON prodON;
	
	@Inject
	private AdministradorON adminON;

	@GET
	@Path("listarP")
	@Produces("application/json")

	public List<ProductoEN> getPro() {

		return prodON.getListadoProd();

	}

	@GET
	@Path("log")
	@Produces("application/json")
	public ClienteEN usuarioLog(@QueryParam("un") String un, @QueryParam("pass") String pass) {
		System.out.println("usuarios");
		//System.out.println(clienteON.listadousuarioLog(un, pass));
		return clienteON.Iniciar(un, pass);
		
		
		

	}
	
	@GET
	@Path("ImagenProductos")
	@Produces("application/json")
	public List<ProductoEN> muestraFotos(){
		return prodON.getListadoProductos();
		
	}
	
	@GET
	@Path("ImagenProducto")
	@Produces("application/json")
	public ProductoEN mostrarProducto(@QueryParam("cod") int codigo) {
		ProductoEN prod=new ProductoEN();
		System.out.println("Llegando el cod "+codigo);
		prod=prodON.buscarProducto(codigo);
		System.out.println("Paso el codigo "+codigo);
		return prod;
	}
	
	@GET
	@Path("ImagenProductoCat")
	@Produces("application/json")
	public List<ProductoEN> mostrarProducto(@QueryParam("cod") String categoria) {
	
		System.out.println("Llegando el cod "+categoria);
		
		System.out.println("Paso el codigo "+categoria);
		return prodON.buscarProducto(categoria);
	}
	
	@POST
	@Path("/insertCliente")
	@Consumes("application/json")
	@Produces("application/json")
	public Response crearUniversidad(ClienteEN cli) {

		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
     
		try {
			clienteON.guardar(cli);
			
			data.put("Codigo", "ingresado "+cli.getCodigo());
			data.put("Mensaje", "Dato Ingresado Correctamente");
			builder = Response.status(Response.Status.OK).entity(data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("codigo", "404");
			data.put("message", "Error" + e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		return builder.build();

	}
	
	
	@GET
	@Path("listarClientes")
	@Produces("application/json")
	public List<ClienteEN> listaClientes(){
		return clienteON.getListadoClientes();
		
	}
	

	/**
	 * @GET @Path("ingreso") @Produces("application/json") public List<UsuarioEN>
	 *      ingreso(String email) { return clienteON.ingreso(email); }
	 **/
	

	
	@GET
	@Path("cliente")
	@Produces("application/json")
	public ClienteEN mostrarCliente(@QueryParam("nombre") String nombre ) {
		return clienteON.getClienteCedula(nombre);
	}
	
	@GET
	@Path("admin")
	@Produces("application/json")
	public AdministradorEN admin(@QueryParam("usuario") String usu, @QueryParam("password") String pws) {
		return adminON.getUsuario(usu, pws);

	}


}
