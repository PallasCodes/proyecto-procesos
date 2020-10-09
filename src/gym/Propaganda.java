/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

/**
 *
 * @author escor
 */
public class Propaganda {
  String tipo, precioUnitario, unidades, fecha, descripcion;

  // CONSTRUCTORES
  public Propaganda() {
    this.tipo = "";
    this.precioUnitario = "";
    this.unidades = "";
    this.fecha = "";
    this.descripcion = "";
  }

  public Propaganda(String tipo, String precioUnitario, String unidades, String fecha, String descripcion) {
    this.tipo = tipo;
    this.precioUnitario = precioUnitario;
    this.unidades = unidades;
    this.fecha = fecha;
    this.descripcion = descripcion;
  }
  
  // SETTERS
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setPrecioUnitario(String precioUnitario) {
    this.precioUnitario = precioUnitario;
  }

  public void setUnidades(String unidades) {
    this.unidades = unidades;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  // GETTERS
  public String getTipo() {
    return tipo;
  }

  public String getPrecioUnitario() {
    return precioUnitario;
  }

  public String getUnidades() {
    return unidades;
  }

  public String getFecha() {
    return fecha;
  }

  public String getDescripcion() {
    return descripcion;
  }
  
  
}
