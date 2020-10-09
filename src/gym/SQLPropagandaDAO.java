/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author escor
 */
public class SQLPropagandaDAO extends Conector{
  
  ObservableList<ModeloTabla> listaTabla = FXCollections.observableArrayList();
  
  public void agregarPropaganda(Propaganda p){
    try {
      PreparedStatement ps = conexion().prepareStatement("INSERT INTO propaganda (tipo, precio_unitario, unidades, fecha, descripcion) values (?,?,?,?,?)");
      ps.setString(1, p.getTipo());
      ps.setString(2, p.getPrecioUnitario());
      ps.setString(3, p.getUnidades());
      ps.setString(4, p.getFecha());
      ps.setString(5, p.getDescripcion());
      ps.executeUpdate();
      
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  public ObservableList actualizarTabla() {
    try {
      listaTabla.clear();
      ResultSet rs = conexion().createStatement().executeQuery("select * from propaganda");

      while (rs.next()) {
        listaTabla.add(new ModeloTabla(rs.getString("tipo"), rs.getString("descripcion"), rs.getString("precio_unitario"), rs.getString("unidades"), 
                Integer.toString((Integer.parseInt(rs.getString("precio_unitario")))*(Integer.parseInt(rs.getString("unidades"))))
                , rs.getString("fecha"), Integer.toString(rs.getInt("id"))));
      }
    } catch (SQLException e) {
      System.out.println(e);
    }

    return listaTabla;
  }
  
  public void editarPropaganda(Propaganda p, String id){
    try {
      PreparedStatement ps = conexion().prepareStatement("update propaganda set tipo='" + p.getTipo() + "' , precio_unitario='"
              + p.getPrecioUnitario() + "', unidades='" + p.getUnidades() +"', fecha='"+ p.getFecha() + "', descripcion='" +  
              p.getDescripcion() + "' where id='" + id +"'");
      ps.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }
    
    
  }
  
  public void eliminar(String ID_Propaganda){
    try {
      PreparedStatement ps = conexion().prepareStatement("DELETE FROM propaganda where id='" + ID_Propaganda + "'");
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  public Propaganda getPropaganda(String id){
    Propaganda p = new Propaganda();
    
    try {
      listaTabla.clear();
      ResultSet rs = conexion().createStatement().executeQuery("select * from propaganda where id='"+id+"'");

      while(rs.next()){
      p.setTipo(rs.getString("tipo"));
      p.setPrecioUnitario(rs.getString("precio_unitario"));
      p.setUnidades(rs.getString("unidades"));
      p.setFecha(rs.getString("fecha"));
      p.setDescripcion(rs.getString("descripcion"));
      }
    } catch (SQLException e) {
      System.out.println(e);
    
    }
    return p;
  }
}
