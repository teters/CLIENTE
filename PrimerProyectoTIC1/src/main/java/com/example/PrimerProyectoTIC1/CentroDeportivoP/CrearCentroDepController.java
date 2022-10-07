package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.List;

public class CrearCentroDepController {
    @FXML
    private TextField nombreCentroDep;

    @FXML
    private TextField direccionCentroDep;



    public void agregarCentroDeportivo(ActionEvent actionEvent){
        CentroDeportivo centroDeportivo = new CentroDeportivo(nombreCentroDep.getText(),direccionCentroDep.getText());
        Gson gson=new Gson();
        String body= gson.toJson(centroDeportivo);
        HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.post("http://localhost:8080/centrodeportivo/crearcentrodeportivo").header("Content-Type","application/json").body(new JsonNode(body)).asJson();

    }
    public List<CentroDeportivo> listaDeCentrosDeportivos(){
        HttpResponse<JsonNode> response=Unirest.get("http://localhost:8080/centrodeportivo/listaDeCentrosDeportivos").header("Content-Type","application/json").asJson();
        String lista=response.getBody().toString();
        List<CentroDeportivo> centroslist=null;
        return centroslist;
    }

}
