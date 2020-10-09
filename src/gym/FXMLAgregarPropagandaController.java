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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author escor
 */
public class FXMLAgregarPropagandaController implements Initializable {

  @FXML
  private Button botonAgregarP;
  @FXML
  private Font x1;
  @FXML
  private Button botonCancelarP;
  @FXML
  private Label labelValidacionP;
  @FXML
  private TextField tfTipo;
  @FXML
  private Font x2;
  @FXML
  private TextField tfPrecioUnitario;
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
  @FXML
  private ImageView iconoSalir;
  @FXML
  private ImageView iconoVolver;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

  @FXML
  private void agregarPropaganda(MouseEvent event) throws IOException {
    Propaganda p = new Propaganda();
    
    p.setTipo(tfTipo.getText());
    p.setPrecioUnitario(tfPrecioUnitario.getText());
    p.setUnidades(tfUnidades.getText());
    p.setFecha(tfFecha.getText());
    p.setDescripcion(taDescripcion.getText());
    
    dao.agregarPropaganda(p);
    
    volver(event);
  }

  @FXML
  private void cancelarP(ActionEvent event) throws IOException {
    Parent propaganda = FXMLLoader.load(getClass().getResource("/gym/FXMLDocument.fxml"));
    Scene sceneConsultarPropaganda = new Scene(propaganda);

    Stage ventana = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    ventana.setScene(sceneConsultarPropaganda);
    ventana.show();
  }

  @FXML
  private void salir(MouseEvent event) {
    System.exit(0);
  }

  @FXML
  private void volver(MouseEvent event) throws IOException {
    Parent propaganda = FXMLLoader.load(getClass().getResource("/gym/FXMLDocument.fxml"));
    Scene sceneConsultarPropaganda = new Scene(propaganda);

    Stage ventana = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    ventana.setScene(sceneConsultarPropaganda);
    ventana.show();
  }
  
  
}
