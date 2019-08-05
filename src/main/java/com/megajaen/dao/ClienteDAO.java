package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.ClienteEN;
@Stateful
public class ClienteDAO {

	@Inject
	private EntityManager em;

	public void save(ClienteEN c) {

		if (this.read(c.getCodigo()) != null)
			this.update(c);
		else {
			this.create(c);
		}

	}

	public void create(ClienteEN c) {
		em.persist(c);

	}

	public ClienteEN read(int id) {
		return em.find(ClienteEN.class, id);

	}

	public ClienteEN read2(int id) {
		ClienteEN c = em.find(ClienteEN.class, id);
		return c;

	}

	public ClienteEN read3(int id) {

		String jpql = "SELECT c " + "	 FROM ClienteEN c " + "		  JOIN FETCH c.facturas f "
				+ " WHERE c.codigo = :a";

		Query q = em.createQuery(jpql, ClienteEN.class);
		q.setParameter("a", id);
		ClienteEN c = (ClienteEN) q.getSingleResult();

		return c;

	}

	public void update(ClienteEN c) {
		em.merge(c);

	}

	public void delete(int id) {
		ClienteEN c = read(id);
		em.remove(c);
	}

	public List<ClienteEN> getClientes() {
		String jpql = "SELECT c FROM ClienteEN c";

		Query q = em.createQuery(jpql, ClienteEN.class);
		List<ClienteEN> clientes = q.getResultList();
		return clientes;

	}

	public List<ClienteEN> getClientes2() {
		String jpql = "SELECT c FROM ClienteEN c";

		Query q = em.createQuery(jpql, ClienteEN.class);

		List<ClienteEN> clientes = q.getResultList();
		// for (ClienteEN c : clientes) {
		// c.getFacturas().size();
		// }
		return clientes;

	}

	public List<ClienteEN> getClientesPorNombre(String filtroBusqueda) {
		String jpql = "SELECT c FROM ClienteEN c" + "WHERE c.codigo LIKE :filtro";

		Query q = em.createQuery(jpql, ClienteEN.class);
		q.setParameter("filtro", "%" + filtroBusqueda + "%");

		List<ClienteEN> clientes = q.getResultList();
		return clientes;

	}
	
//	public List<UsuarioEN> listadousuarioLog(String un, String pass) {
//		String  jpql = "SELECT u FROM UsuarioEN u WHERE u.emailusuario=:un AND u.contrasenia=:pass";
//		Query query = em.createQuery(jpql, UsuarioEN.class);
//		query.setParameter("un", un);
//		query.setParameter("pass", pass);
//		List<UsuarioEN> listado = query.getResultList();
//		return listado;
//	}
//	
	
//	public ClienteEN usuarioLog(String usu, String pass) {
//		String  jpql = "SELECT u FROM ClienteEN u WHERE u.email=?1 AND u.pass=?2";
//		Query query = em.createQuery(jpql, UsuarioEN.class);
//		query.setParameter(1, usu);
//		query.setParameter(2, pass);
//		UsuarioEN usuario = (UsuarioEN) query.getSingleResult();
//		return usuario;
//	}
	
	public ClienteEN usuario(String user,String pass) {
		ClienteEN cli=null;

			String jpql="SELECT c FROM ClienteEN c WHERE c.email =: user AND c.pass =: pass";
			Query q = em.createQuery(jpql, ClienteEN.class);
			q.setParameter("user", user);
			q.setParameter("pass", pass);
			List<ClienteEN> clienteLista = q.getResultList();
			if(!clienteLista.isEmpty()) {
				cli=clienteLista.get(0);
			}else {
				cli=null;
			}
		return cli;
		}
	
	
	/**public List<UsuarioEN> ingresoLogin(String email) {
		String jpql="SELECT u.usu_emailusuario FROM UsuarioEN u WHERE u.usu_emailusuario LIKE :filtro";
		
		Query query = em.createNativeQuery(jpql, UsuarioEN.class);
		query.setParameter("filtro", email);
		List<UsuarioEN> usuario=query.getSingleResult();
		return  usuario;
		
	}**/
	
	public ClienteEN getClienteCedula(String nombre) {
		String jpql = "SELECT  c FROM ClienteEN c WHERE c.nombre LIKE ?1 ";
		Query q = em.createQuery(jpql, ClienteEN.class);
		q.setParameter(1, nombre);
		ClienteEN cliente = (ClienteEN) q.getSingleResult();
		return cliente;

	}

}
