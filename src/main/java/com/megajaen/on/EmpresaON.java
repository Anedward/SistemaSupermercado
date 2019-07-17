package com.megajaen.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.megajaen.dao.EmpresaDAO;
import com.megajaen.entidades.EmpresaEN;

@Stateless
public class EmpresaON {

	@Inject
	private EmpresaDAO empdao;

	public void guardar(EmpresaEN emp) throws Exception {
		if (emp.getRazonSocial().length() < 5)
			throw new Exception("Dimension corta");
		empdao.save(emp);
	}

	public List<EmpresaEN> listaEmpresas() {
		return empdao.listaEmpresa();
	}

	public void borrar(int codigo) throws Exception {
		try {
			empdao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al eliminar " + e.getMessage());
		}
	}

	public EmpresaEN getEmpresa(int codigo) {
		EmpresaEN auxemp= empdao.read(codigo);
		return auxemp;
	}
}