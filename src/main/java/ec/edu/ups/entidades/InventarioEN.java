package ec.edu.ups.entidades;

import java.util.Date;

public class InventarioEN {
	
	private int codigo;
	private String descripcion;
	private Date fecha;
	private int cantidadCompra;
	private double precioCompra;
	private double totalCompra;
	private int cantidadVenta;
	private double precioVenta;
	private int cantidadExistencia;
	private double precioUnitarioExistencia;
	private double precioTotalExistencia;
	
	
	
	
public InventarioEN() {
	
}




public int getCodigo() {
	return codigo;
}




public void setCodigo(int codigo) {
	this.codigo = codigo;
}




public String getDescripcion() {
	return descripcion;
}




public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}




public Date getFecha() {
	return fecha;
}




public void setFecha(Date fecha) {
	this.fecha = fecha;
}




public int getCantidadCompra() {
	return cantidadCompra;
}




public void setCantidadCompra(int cantidadCompra) {
	this.cantidadCompra = cantidadCompra;
}




public double getPrecioCompra() {
	return precioCompra;
}




public void setPrecioCompra(double precioCompra) {
	this.precioCompra = precioCompra;
}




public double getTotalCompra() {
	return totalCompra;
}




public void setTotalCompra(double totalCompra) {
	this.totalCompra = totalCompra;
}




public int getCantidadVenta() {
	return cantidadVenta;
}




public void setCantidadVenta(int cantidadVenta) {
	this.cantidadVenta = cantidadVenta;
}




public double getPrecioVenta() {
	return precioVenta;
}




public void setPrecioVenta(double precioVenta) {
	this.precioVenta = precioVenta;
}




public int getCantidadExistencia() {
	return cantidadExistencia;
}




public void setCantidadExistencia(int cantidadExistencia) {
	this.cantidadExistencia = cantidadExistencia;
}




public double getPrecioUnitarioExistencia() {
	return precioUnitarioExistencia;
}




public void setPrecioUnitarioExistencia(double precioUnitarioExistencia) {
	this.precioUnitarioExistencia = precioUnitarioExistencia;
}




public double getPrecioTotalExistencia() {
	return precioTotalExistencia;
}




public void setPrecioTotalExistencia(double precioTotalExistencia) {
	this.precioTotalExistencia = precioTotalExistencia;
}


}
