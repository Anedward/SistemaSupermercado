package com.megajaen.service;

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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.megajaen.entidades.ClienteEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.entidades.UsuarioEN;
import com.megajaen.on.ClienteON;
import com.megajaen.on.ProductoON;

@Path("/cliente")

public class operacionesServiceRest {

	private ProductoEN prod;
	
	@Inject
	private ClienteON clienteON;

	@Inject
	private ProductoON prodON;

	@GET
	@Path("listar")
	@Produces("application/json")

	public List<UsuarioEN> ge() {
		return clienteON.listadousuario();

	}

	@GET
	@Path("listarP")
	@Produces("application/json")

	public List<ProductoEN> getPro() {

		return prodON.getListadoProd();

	}

	@GET
	@Path("listarU")
	@Produces("application/json")
	public List<UsuarioEN> listadousuarioLog(@QueryParam("un") String un, @QueryParam("pass") String pass) {
		String mensaje = "llego";
		System.out.println("llego" + mensaje);
		return clienteON.listadousuarioLog(un, pass);

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

	/**
	 * @GET @Path("ingreso") @Produces("application/json") public List<UsuarioEN>
	 *      ingreso(String email) { return clienteON.ingreso(email); }
	 **/

}
