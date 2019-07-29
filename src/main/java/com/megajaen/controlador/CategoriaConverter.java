package com.megajaen.controlador;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.megajaen.entidades.CategoriaEN;


@FacesConverter(value="categoriaConverter")
public class CategoriaConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String categoriaId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{categoriaController}", CategoriaController.class);

	        CategoriaController categorias = (CategoriaController)vex.getValue(ctx.getELContext());
	        return categorias.getCategoria(Integer.valueOf(categoriaId));
	        
	    }

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		//System.out.println("Holaaa"+value);
		return null;
	}

	/*
	 * @Override public String getAsString(FacesContext facesContext, UIComponent
	 * uiComponent, Object cat) {
	 * 
	 * return String.valueOf(((CategoriaEN)cat).getCodigo()); //return
	 * 
	 * }
	 */
	
	
	

}
