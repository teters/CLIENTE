package com.example.PrimerProyectoTIC1.EmpresaP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.CentroDeportivo;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kong.unirest.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EmpresaController implements Initializable {
    @FXML
    private TableView<Empresa> empresaTabla;
    @FXML
    private TableColumn<Empresa, Long> colTelefono;
    @FXML
    private TableColumn<Empresa, String> colNombreE;
    @FXML
    private TableColumn<Empresa, String> colDireccionE;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Empresa> items= Unirest.get("http://localhost:8080/empresas/").
                header("Content-Type","application/json").
                asObject(new GenericType<List<Empresa>>(){}).getBody();
        System.out.println("hola");

        ObservableList<Empresa> listaEmpresas = FXCollections.observableArrayList(items);
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colNombreE.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDireccionE.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        empresaTabla.setItems(listaEmpresas);

    }


    //HttpResponse<JsonNode> response= Unirest.get("http://localhost:8080/empresa/listaDeEmpresas").header("Content-Type","application/json").asJson();// aca en response se va a guardar una lista de empresas teoricamente




}
