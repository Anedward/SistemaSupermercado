package com.megajaen.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.megajaen.entidades.CategoriaEN;
import com.megajaen.entidades.ProductoEN;
import com.megajaen.on.CategoriaON;
import com.megajaen.on.ProductoON;


@ManagedBean
@ViewScoped
public class ProductoController {
	
private ProductoEN producto;
private UploadedFile file;
private List<CategoriaEN> listaCategorias;

@Inject
private CategoriaON catON;
	
	@Inject
	private ProductoON prodON; 
	
	@Inject
	private FacesContext fc;
	
	@PostConstruct
	public void init() {
		producto = new ProductoEN();
		listaCategorias=catON.getListadoCategorias();
	}
	
	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}

	public List<CategoriaEN> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaEN> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public String guardarDatos() {
		prodON.guardarProducto(producto);
		System.out.println(producto);
		return "productos";
	}
	
	
	public void consultarCategoria() {
		
		CategoriaEN cat;
		try {
			cat = prodON.consultaCategoria(producto.getIdCategoriaTemp());
			producto.setCategoria(cat);
		} catch (Exception e) {
			producto.setCategoria(null);
			// TODO Auto-generated catch block
			FacesMessage msg =  new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(), "Error");
			fc.addMessage("txtCategoria", msg);
			
			e.printStackTrace();
		}
		
	}
	
	
	 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
