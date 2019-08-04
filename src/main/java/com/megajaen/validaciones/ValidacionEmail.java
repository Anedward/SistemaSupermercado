package com.megajaen.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("vemail")
public class ValidacionEmail implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String cadena = value.toString().trim();

		if (cadena.length() == 0 || cadena == null) {
			throw new ValidatorException(new FacesMessage("*Campo Obligatorio"));
		}

		else {
			String caracterPermitido = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";

			boolean email_OK = Pattern.matches(caracterPermitido, cadena);

			if (!email_OK) { // Email doesn't match
				throw new ValidatorException(new FacesMessage("Email Invalido"));
			}

		}

	}

}
