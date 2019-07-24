package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.dao.CategoriaDAO;
import com.megajaen.entidades.CategoriaEN;

@Stateless
public class CategoriaON {

	@Inject
	private CategoriaDAO catdao;

	public void guardar(CategoriaEN cat) throws Exception {
		if (cat.getDescripcion().length() < 5)
			throw new Exception("Dimension corta");
		catdao.save(cat);
	}

	public List<CategoriaEN> listaCategorias() {
		return catdao.getCategoria2();
	}

	public void borrar(int codigo) throws Exception {
		try {
			catdao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al eliminar " + e.getMessage());
		}
	}

	public CategoriaEN getCategoria(int codigo) {
		CategoriaEN auxcat = catdao.read(codigo);
		return auxcat;
	}
}
