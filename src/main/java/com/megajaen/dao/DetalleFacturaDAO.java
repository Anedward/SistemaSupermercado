package com.megajaen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.megajaen.entidades.DetalleFacturaEN;
import com.megajaen.entidades.ProductoEN;


@Stateless
public class DetalleFacturaDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(DetalleFacturaEN det) {
		if(this.read(det.getCodigo())!=null)
			this.update(det);
		else
			this.insertarDetalle(det);
		
	}
	
	public void insertarDetalle (DetalleFacturaEN detalle) {
		em.persist(detalle);
	}
	
	public DetalleFacturaEN read(int id) {
		return em.find(DetalleFacturaEN.class, id);
	}

	public List<DetalleFacturaEN> listDetalles(){
		String jpql = "SELECT det FROM DetalleFacturaEN det ";
		Query q = em.createQuery(jpql, DetalleFacturaEN.class);
		List<DetalleFacturaEN> detalles = q.getResultList();
		return detalles;	
	}
	
	public DetalleFacturaEN buscarDetalles(int id) {
		DetalleFacturaEN detalles = em.find(DetalleFacturaEN.class, id);
		return detalles;
	}
public void update(DetalleFacturaEN det) {
		
		em.merge(det);
	}

}
