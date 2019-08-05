package com.megajaen.validaciones;

public class GenerarCodigo {
	private int dato;
	private int cont = 1;
	private String num = "";
	

	public void GenerarCodigoProd(int dato) {
		this.dato = dato;

		if ((this.dato >= 1000) || (this.dato < 1000)) {
			int can = cont + this.dato;
			num = "0000" + can;
		}
		if ((this.dato >= 100) || (this.dato < 100)) {
			int can = cont + this.dato;
			num = "00000" + can;
		}
		if ((this.dato >= 9) || (this.dato < 100)) {
			int can = cont + this.dato;
			num = "000000" + can;
		}
		if (this.dato < 9) {
			int can = cont + this.dato;
			num = "0000000" + can;
		}
	}
	
	 public String serie(){
	       return this.num;
	       
	   }

}
