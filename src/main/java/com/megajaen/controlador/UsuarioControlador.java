package com.megajaen.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioControlador {
	
//		private List<UsuarioEN> usuarios;
//		private String nombreusuario;
//		private String password;
//		private UsuarioEN usuario;
//		@Inject
//		private ClienteON con;
//		@Inject
//		private preferencias pre;
//		
//
//	public UsuarioEN getUsuario() {
//			return usuario;
//		}
//
//		public void setUsuario(UsuarioEN usuario) {
//			this.usuario = usuario;
//		}
//
//	public String getNombreusuario() {
//			return nombreusuario;
//		}
//
//		public void setNombreusuario(String nombreusuario) {
//			this.nombreusuario = nombreusuario;
//		}
//
//		public String getPassword() {
//			return password;
//		}
//
//		public void setPassword(String password) {
//			this.password = password;
//		}
//		
//		
//
//	public String Iniciar() {	
//		try {
//			if(nombreusuario!=null && password!=null) {
//				System.out.println("hola ");
//				 usuarios=con.listadousuarioLog(nombreusuario, password);
//				if(usuarios.size()>0) {
//					usuario=usuarios.get(0);
//					pre.setUsuario(usuarios.get(0));
//					System.out.println("hola "+usuario.getEmailusuario());
//					return"listaProductos";
//				}else {
//					FacesContext.getCurrentInstance().addMessage(
//			                 null,
//			                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário no encontrado!",
//			                   "Erro no Login!"));
//			              return null;
//			              	
//				}			
//			}
//		}catch (Exception e) {
//				System.out.println("error");
//		}
//		return "";
//	}

}
