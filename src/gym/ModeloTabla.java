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
public class ModeloTabla {
  String tipo, descripcion, fecha, precioUnitario, unidades, costoTotal, id;

  // CONSTRUCTORES
  public ModeloTabla() {
    this.tipo = "";
    this.descripcion = "";
    this.precioUnitario = "";
    this.unidades = "";
    this.costoTotal = "";
    this.fecha = "";
    this.id = "";
  }

  public ModeloTabla(String tipo, String descripcion, String precioUnitario, String unidades, String costoTotal, String fecha, String id) {
    this.tipo = tipo;
    this.descripcion = descripcion;
    this.precioUnitario = precioUnitario;
    this.unidades = unidades;
    this.costoTotal = costoTotal;
    this.fecha = fecha;
    this.id = id;
  }

  // SETTERS
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public void setPrecioUnitario(String precioUnitario) {
    this.precioUnitario = precioUnitario;
  }

  public void setUnidades(String unidades) {
    this.unidades = unidades;
  }

  public void setCostoTotal(String costoTotal) {
    this.costoTotal = costoTotal;
  }
  
   public void setID(String id) {
    this.id = id;
  }
  
  // GETTERS
  public String getTipo() {
    return tipo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getFecha() {
    return fecha;
  }

  public String getPrecioUnitario() {
    return precioUnitario;
  }

  public String getUnidades() {
    return unidades;
  }

  public String getCostoTotal() {
    return costoTotal;
  }
  
  public String getID() {
    return id;
  }
  
}