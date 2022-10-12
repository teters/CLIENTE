package com.example.PrimerProyectoTIC1.EmpresaP;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.io.IOException;

public class CrearEmpresaController {
    @FXML
    private TextField telefonoID;

    @FXML
    private TextField nombreEmpID;

    @FXML
    private TextField direccionEmpID;


    public void agregarEmpresa(ActionEvent actionEvent) throws IOException {
        Empresa empresa = new Empresa(Long.parseLong(telefonoID.getText()),nombreEmpID.getText(), direccionEmpID.getText());
        Gson gson=new Gson();
        String body= gson.toJson(empresa);
        HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.post("http://localhost:8080/empresas/agregarEmpresa").header("Content-Type","application/json").body(new JsonNode(body)).asJson();//esto te crea y te manda al servidor la empresa
        //HttpResponse<String> jsonNodeHttpResponse= Unirest.post("http://localhost:8080/empresa/agregarEmpresa").header("Content-Type","application/json").body(new JsonNode(body)).asString();

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("option-pane.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
