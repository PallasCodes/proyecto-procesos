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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author escor
 */
public class FXMLDocumentController extends PropagandaH implements Initializable {
  
  SQLPropagandaDAO dao = new SQLPropagandaDAO();
  String ID_Propaganda = "";
  
  private Label label;
  @FXML
  private TableColumn<ModeloTabla, String> columTipo;
  @FXML
  private TableColumn<ModeloTabla, String> columDescripcion;
  @FXML
  private TableColumn<ModeloTabla, String> columPrecioU;
  @FXML
  private TableColumn<ModeloTabla, String> columUnidades;
  @FXML
  private TableColumn<ModeloTabla, String> columCostoT;
  @FXML
  private TableColumn<ModeloTabla, String> columFecha;
  @FXML
  private Button botonAgregar;
  @FXML
  private Button botonEditar;
  @FXML
  private Button botonEliminar; 
  @FXML
  private TableView<ModeloTabla> tabla;
  @FXML
  private Label labelAdvertencia;
  @FXML
  private ImageView iconoSalir;
  @FXML
  private TableColumn<ModeloTabla, String> ID;
  @FXML
  private Rectangle columID;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    actualizar();
  }  
  
  public void actualizar(){
    columTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    columDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    columPrecioU.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
    columUnidades.setCellValueFactory(new PropertyValueFactory<>("unidades"));
    columCostoT.setCellValueFactory(new PropertyValueFactory<>("costoTotal"));
    columFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    ID.setCellValueFactory(new PropertyValueFactory<>("id"));

    try {
      tabla.setItems(dao.actualizarTabla());
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @FXML
  private void agregarPropaganda(ActionEvent event) throws IOException {
    Parent propaganda = FXMLLoader.load(getClass().getResource("/gym/FXMLAgregarPropaganda.fxml"));
    Scene sceneAgregarpropaganda = new Scene(propaganda);

    Stage ventana = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    ventana.setScene(sceneAgregarpropaganda);
    ventana.show();
  }

  @FXML
  private void editarPropaganda(ActionEvent event) throws IOException {
    PropagandaH.modTabla = tabla.getSelectionModel().getSelectedItem();
    
    Parent propaganda = FXMLLoader.load(getClass().getResource("/gym/FXMLEditarPropaganda.fxml"));
    Scene sceneEditarPropaganda = new Scene(propaganda);

    Stage ventana = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    ventana.setScene(sceneEditarPropaganda);
    ventana.show();
  }

  @FXML
  private void eliminarPropaganda(ActionEvent event) {
    dao.eliminar(ID_Propaganda);
    actualizar();
  }

  @FXML
  private void salir(MouseEvent event) {
    System.exit(0);
  }

  @FXML
  private void seleccionar(){
    ModeloTabla modTab = tabla.getSelectionModel().getSelectedItem();
    ID_Propaganda = modTab.getID();
  }

 
}
