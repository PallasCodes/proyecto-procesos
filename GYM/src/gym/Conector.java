/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author escor
 */
public class Conector {
  Connection cn;
  Statement st;
  
  public Connection conexion() {
    String url = "jdbc:mysql://localhost:3306/gym";
    String user = "root";
    String pass = "clonador241097";
    
    try  {
      Class.forName("com.mysql.jdbc.Driver");
      cn = DriverManager.getConnection(url, user, pass);
      System.out.println("Conectado!!");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return cn;
  }
}
