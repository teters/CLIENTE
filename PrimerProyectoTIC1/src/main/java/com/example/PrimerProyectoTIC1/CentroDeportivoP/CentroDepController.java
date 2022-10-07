package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kong.unirest.Unirest;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CentroDepController implements Initializable {

    @FXML
    private TableView<CentroDeportivo> centroDepTabla;

    @FXML
    private TableColumn<CentroDeportivo, String> colNombre;

    @FXML
    private TableColumn<CentroDeportivo,String> colDireccion;

    @FXML
    private TextField nombreID;

    @FXML
    private TextField direccionID;


    public void guardarCentroDep(ActionEvent actionEvent){
        CentroDeportivo centroDeportivo = new CentroDeportivo(nombreID.getText(), direccionID.getText());
        centroDepTabla.getItems().add(centroDeportivo);
    }
 //   List<CentroDeportivo> items = Unirest.get(/);

    ObservableList<CentroDeportivo> listaCentroDep = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNombre.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, String>("Nombre"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, String>("Direccion"));
    }
}
