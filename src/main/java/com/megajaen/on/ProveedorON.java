package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.dao.ProveedorDAO;
import com.megajaen.entidades.ProveedorEN;

@Stateless
public class ProveedorON {

	@Inject
	private ProveedorDAO pdao;

	public void guardar(ProveedorEN p) throws Exception {

		if (p.getRazonSocial().length() < 5)
			throw new Exception("Dimension corta");

		/**
		 * List<TipoProducto> tipos = init.getProdu(); for (Producto prod :
		 * p.getProductos()) { for (TipoProducto tp : tipos) { if (prod.getIdTipo() ==
		 * tp.getCodigo()) { prod.setTipo(tp); } } }
		 **/

		pdao.save(p);
	}

	public List<ProveedorEN> getListadoProveedor() {
		return pdao.getProveedor();
	}

	public void borrar(int codigo) throws Exception {
		try {
			pdao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}

	}
	
	public ProveedorEN getProveedor(int codigo) {
		ProveedorEN aux = pdao.read(codigo);

		return aux;

	}


}
