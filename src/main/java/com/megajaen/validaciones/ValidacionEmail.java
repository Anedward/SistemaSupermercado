package com.megajaen.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("vEmail")
public class ValidacionEmail implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String cadena = value.toString().trim();

		if (cadena.length() == 0 || cadena == null) {
			throw new ValidatorException(new FacesMessage("*Campo Obligatorio"));
		}

		else {		
			 // comprueba que no empieze por punto o @
		      Pattern p = Pattern.compile("^.|^@");
		      Matcher m = p.matcher(cadena);
		      if (m.find())
		    	  throw new ValidatorException(new FacesMessage("Email No puede empezar por '.' ó '@'"));
		         
		      // comprueba que no empieze por www.
		      p = Pattern.compile("^www.");
		      m = p.matcher(cadena);
		      if (m.find())
		    	  throw new ValidatorException(new FacesMessage("Email No puede empezar con 'www'"));

		      // comprueba que contenga @
		      p = Pattern.compile("@");
		      m = p.matcher(cadena);
		      if (!m.find())
		    	  throw new ValidatorException(new FacesMessage("Email debe tener '@'"));
		      	
		      // comprueba que no contenga caracteres prohibidos	
		      p = Pattern.compile("[^A-Za-z0-9.@_-~#]+");
		      m = p.matcher(cadena);
		      StringBuffer sb = new StringBuffer();
		      boolean resultado = m.find();
		      boolean caracteresIlegales = false;

		      while(resultado) {
		         caracteresIlegales = true;
		         m.appendReplacement(sb, "");
		         resultado = m.find();
		      }

		      // Añade el ultimo segmento de la entrada a la cadena
		      m.appendTail(sb);

		      cadena = sb.toString();

		      if (caracteresIlegales) {
		         System.out.println("La cadena contiene caracteres ilegales");
		      }
			
		}

	}

}
