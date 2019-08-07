package com.megajaen.controlador;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.megajaen.entidades.AdministradorEN;
import com.megajaen.on.AdministradorON;



@ManagedBean
@ViewScoped
public class UsuarioControlador {
	
		private List<AdministradorEN> usuarios;
		private String nombreusuario;
		private String password;
		private AdministradorEN usuario;
		@Inject
		private AdministradorON con;
		
		@Inject
		private preferencias pre;
	
		public List<AdministradorEN> getUsuarios() {
			return usuarios;
		}
		public void setUsuarios(List<AdministradorEN> usuarios) {
			this.usuarios = usuarios;
		}
		public String getNombreusuario() {
			return nombreusuario;
		}
public void setNombreusuario(String nombreusuario) {
			this.nombreusuario = nombreusuario;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public AdministradorEN getUsuario() {
			return usuario;
		}
public void setUsuario(AdministradorEN usuario) {
			this.usuario = usuario;
		}



public String Iniciar() {	
	try {
if(nombreusuario!=null && password!=null) {
		System.out.println("hola ");
			 con.getUsuario(nombreusuario, password);
			 return"principal";	
		}
		}catch (Exception e) {
				System.out.println("error"+e);
		}
	return null;
		
	}




//public String Iniciar() {	
//	try {
//		if(nombreusuario!=null && password!=null) {
//			System.out.println("hola ");
//		   con.getUsuario(nombreusuario, password);
//		   
//			if(usuarios.size()>0) {
//				usuario=usuarios.get(0);
//				pre.setUsuario(usuarios.get(0));
//				System.out.println("hola "+usuario.getUsuario());
//				return"listaProductos";
//			}else {
//				return"error";		
//			}			
//		}
//	}catch (Exception e) {
//			System.out.println("error");
//	}
//	return "";
//}




//public String Iniciar() {	
//	try {
//	if(nombreusuario!=null && password!=null) {
//			System.out.println("hola ");
//			 con.getUsuario(nombreusuario, password);
//		if(usuarios.size()>0) {
//			usuario=usuarios.get(0);
//			pre.setUsuario(usuarios.get(0));
//			System.out.println("hola "+usuario.getUsuario());
//				return"index";
//		}else {
//				FacesContext.getCurrentInstance().addMessage(
//	                 null,
//	                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário no encontrado!",
//		                   "Erro no Login!"));
//	              return null;
//		              	
//			}			
//		}
//	}catch (Exception e) {
//			System.out.println("error"+e);
//	}
//	return "";
//}

}