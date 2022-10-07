package com.example.PrimerProyectoTIC1.EmpresaP;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class CrearEmpresaController {
    @FXML
    private TextField telefonoID;

    @FXML
    private TextField nombreEmpID;

    @FXML
    private TextField direccionEmpID;


    public void agregarEmpresa(ActionEvent actionEvent){
        Empresa empresa = new Empresa(Long.parseLong(telefonoID.getText()),nombreEmpID.getText(), direccionEmpID.getText());
        Gson gson=new Gson();
        String body= gson.toJson(empresa);
        HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.post("http://localhost:8080/empresa/agregarEmpresa").header("Content-Type","application/json").body(new JsonNode(body)).asJson();//esto te crea y te manda al servidor la empresa
    }


}
