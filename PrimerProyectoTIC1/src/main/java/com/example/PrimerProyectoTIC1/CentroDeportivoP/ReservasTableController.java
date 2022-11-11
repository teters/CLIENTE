package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.example.PrimerProyectoTIC1.EmpleadoP.Reserva;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReservasTableController implements Initializable {

    @FXML
    private TableColumn<Reserva, Long> colActividadID;

    @FXML
    private TableColumn<Reserva, String> colDia;

    @FXML
    private TableColumn<Reserva, Long> colEmpID;

    @FXML
    private TableColumn<Reserva, LocalDate> colFecha;

    @FXML
    private TableColumn<Reserva, String> colHora;

    @FXML
    private TableView<Reserva> empresaTabla;

    @FXML
    private Button salirBEmp;

    @FXML
    void salirEmp(ActionEvent event) {

    }

    @FXML
    void volverEmp(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
         List<Empresa> items= Unirest.get("http://localhost:8080/empresas/ListaDeEmpresas").
                header("Content-Type","application/json").
                asObject(new GenericType<List<Empresa>>(){}).getBody();

        ObservableList<Empresa> listaEmpresas = FXCollections.observableArrayList(items);
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colNombreE.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDireccionE.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        empresaTabla.setItems(listaEmpresas);

        */
    }
}
