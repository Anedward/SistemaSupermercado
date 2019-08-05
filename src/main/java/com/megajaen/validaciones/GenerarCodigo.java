package ec.edu.ups.validaciones;

public class GenerarCodigo {
	private int dato;
	private int cont = 1;
	private String num = "";
	

	public void GenerarCodigoProd(int dato) {
		this.dato = dato;

		if ((this.dato >= 1000) || (this.dato < 1000)) {
			int can = cont + this.dato;
			num = "PROD" + can;
		}
		if ((this.dato >= 100) || (this.dato < 100)) {
			int can = cont + this.dato;
			num = "PROD0" + can;
		}
		if ((this.dato >= 9) || (this.dato < 100)) {
			int can = cont + this.dato;
			num = "PROD00" + can;
		}
		if (this.dato < 9) {
			int can = cont + this.dato;
			num = "PROD000" + can;
		}
	}
	
	 public String serie(){
	       return this.num;
	       
	   }

}
