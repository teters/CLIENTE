package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class EmpleadosEnCentrosController implements Initializable {

    @FXML
    private ChoiceBox<String> actividadesList;

    @FXML
    private ChoiceBox<String> dias;

    @FXML
    private TextField mailDeEmp;

    List<String> listaActividades = new ArrayList<>();


    public void setData(Actividad actividad){
        for (int i = 0; i < listaActividades.size(); i++) {
            if (actividad.equals(listaActividades.get(i))){}
        }


    }
    public List<Actividad> obtenerActividadesConCentro(CentroDeportivo1 centro){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/centrodeportivo/"+centro+"/actividades").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        List<Actividad> actividades=null;
        try {
            Actividad[] nombres=mapper.readValue(response.getBody().toString(),Actividad[].class);
            actividades= Arrays.asList(nombres);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return actividades
        ;
    }

    public void validar(ActionEvent event){





    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {




    }
}
