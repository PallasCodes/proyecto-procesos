/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author escor
 */
public class FXMLEditarPropagandaController implements Initializable {

  @FXML
  private Button botonEditar;
  @FXML
  private Font x1;
  @FXML
  private Button botonCancelar;
  @FXML
  private TextField tfTipo;
  @FXML
  private Font x2;
  @FXML
  private TextField tfPrecioU;
  @FXML
  private TextField tfUnidades;
  @FXML
  private TextField tfFecha;
  @FXML
  private TextArea taDescripcion;

  /**
   * Initializes the controller class.
   */
  SQLPropagandaDAO dao = new SQLPropagandaDAO();
  
  
  @Override
  public void initialize(URL url, ResourceBundle rb)  {
    try{
    llenarFormulario();
    } catch(Exception e){
      JOptionPane.showMessageDialog(null,"Seleccione un elemento a editar");
      
    }
    
  }  

  @FXML
  private void editarPropaganda(MouseEvent event) throws IOException {
    Propaganda p = new Propaganda();
    System.out.println(PropagandaH.modTabla.getID());
    
    p.setTipo(tfTipo.getText());
    p.setFecha(tfFecha.getText());
    p.setUnidades(tfUnidades.getText());
    p.setPrecioUnitario(tfPrecioU.getText());
    p.setDescripcion(taDescripcion.getText());
    
    dao.editarPropaganda(p,PropagandaH.modTabla.getID());
    
    volver(event);
  }

  @FXML
  private void cancelarP(ActionEvent event) {
  }

  @FXML
  private void salir(MouseEvent event) {
    System.exit(0);
  }

  @FXML
  private void regresar(){

  }

  @FXML
  private void volver(MouseEvent event) throws IOException {
  
    Parent propaganda = FXMLLoader.load(getClass().getResource("/gym/FXMLDocument.fxml"));
    Scene sceneConsultarPropaganda = new Scene(propaganda);

    Stage ventana = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    ventana.setScene(sceneConsultarPropaganda);
    ventana.show();
  }
  
  public void llenarFormulario(){
    Propaganda p = dao.getPropaganda(PropagandaH.modTabla.getID());
    
    tfTipo.setText(p.getTipo());
    tfPrecioU.setText(p.getPrecioUnitario());
    tfUnidades.setText(p.getUnidades());
    tfFecha.setText(p.getFecha());
    taDescripcion.setText(p.getDescripcion());
  }
}
