package com.megajaen.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.DetalleFacturaEN;
import com.megajaen.entidades.FacturaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.on.CategoriaON;
import com.megajaen.on.DetalleFacturaON;
import com.megajaen.on.FacturaON;

@ManagedBean
@ViewScoped
public class FacturaController {
	
	private FacturaEN factura = new FacturaEN();
	private DetalleFacturaEN detalle = new DetalleFacturaEN();
	private List<FacturaEN> listaFacturas;
	
	private int id;
	
	@Inject
	private FacturaON facON;
	
	@Inject
	private DetalleFacturaON detON;
	
	@PostConstruct
	public void init() {
		factura = new FacturaEN();
		listaFacturas = facON.getListadoFacturas();
	}
	
	public void loadData() {
		System.out.println("codigo editar " + id);
		if(id==0)
			return;
		factura = facON.getFactura(id);
		System.out.println(factura.getCodigo() + " " + factura.getFechaEmision());
		System.out.println("#detalles: " + " " + factura.getDetalle().size());
		for(DetalleFacturaEN det : factura.getDetalle()) {
			System.out.println("\t"+det);
		}		
	}
	
	
	public FacturaEN getFactura() {
		return factura;
	}

	public void setFactura(FacturaEN factura) {
		this.factura = factura;
	}

	public List<FacturaEN> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<FacturaEN> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FacturaEN getFactura(int codFac) {
		
		if(codFac == 0) {
			throw new IllegalArgumentException("Codigo invalido");
		}
		for(FacturaEN factura : listaFacturas) {
			if (codFac == (factura.getCodigo())) {
				return factura;
		}
		
	}
		return null;
	}

	public String cargarDatos() {
		
		try {
			/*facON.guardar(factura);
			detON.guardar(detalle);
			
			init();*/
			System.out.println(factura.toString());
			System.out.println(detalle.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String borrar(int codigo) {
		System.out.println("codigo borrar " + codigo);
		
		try {
			facON.borrar(codigo);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error "+ e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String nuevo() {
		factura = new FacturaEN();
		return "categoria";
	}
	
	public String listado() {
		return "listaFacturas";
	}
	
	public void addDetalles(){
		factura.addDetalles(new DetalleFacturaEN());
		System.out.println("cnt " + factura.getDetalle().size());
	}
}


