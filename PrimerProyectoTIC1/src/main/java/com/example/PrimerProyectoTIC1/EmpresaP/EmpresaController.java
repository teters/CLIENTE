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
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

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




    public void agregarEmpresa(ActionEvent actionEvent){
        List<Empresa> items = Unirest.get("http://localhost:8080/empresa/listaDeEmpresas")
                .asObject(new GenericType<List<Empresa>>(){})
                .getBody();

        ObservableList<Empresa> listaEmpresas = FXCollections.observableArrayList(items);
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colNombreE.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDireccionE.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        empresaTabla.setItems(listaEmpresas);
       // Gson gson=new Gson();
        //String body= gson.toJson(empresa);
        //HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.post("http://localhost:8080/empresa/agregarEmpresa").header("Content-Type","application/json").body(new JsonNode(body)).asJson();//esto te crea y te manda al servidor la empresa
    }

    //HttpResponse<JsonNode> response= Unirest.get("http://localhost:8080/empresa/listaDeEmpresas").header("Content-Type","application/json").asJson();// aca en response se va a guardar una lista de empresas teoricamente
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    //
}
