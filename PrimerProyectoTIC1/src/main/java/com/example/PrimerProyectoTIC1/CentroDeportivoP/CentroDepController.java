package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CentroDepController implements Initializable{

    @Autowired


    @FXML
    private TableView<CentroDeportivo> centroDepTabla;

    @FXML
    private TableColumn<CentroDeportivo, String> colNombre;

    @FXML
    private TableColumn<CentroDeportivo,String> colDireccion;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<CentroDeportivo> items = Unirest.get("http://localhost:8080/empresa/listaDeCentrosDeportivos")
                .asObject(new GenericType<List<CentroDeportivo>>(){})
                .getBody();

        ObservableList<CentroDeportivo> listaCentroDep = FXCollections.observableArrayList(items);

        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("Direccion"));


        centroDepTabla.setItems(listaCentroDep);
    }

    public void guardarCentroDep(ActionEvent actionEvent) {

    }

}
