package com.example.PrimerProyectoTIC1.CentroDeportivoP;

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


public class CrearCentroDepController {
    @FXML
    private TextField nombreCentroDep;

    @FXML
    private TextField direccionCentroDep;



    public void agregarCentroDeportivo(ActionEvent actionEvent) throws Exception{
        CentroDeportivo centroDeportivo = new CentroDeportivo(nombreCentroDep.getText(),direccionCentroDep.getText());
        Gson gson=new Gson();
        String body= gson.toJson(centroDeportivo);
        HttpResponse<kong.unirest.JsonNode> jsonNodeHttpResponse= Unirest.post("http://localhost:8080/centrodeportivo/agregarcentrodeportivo").header("Content-Type","application/json").body(new JsonNode(body)).asJson();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("option-pane.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
