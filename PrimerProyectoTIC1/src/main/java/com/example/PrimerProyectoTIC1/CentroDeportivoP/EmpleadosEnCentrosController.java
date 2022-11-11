package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.example.PrimerProyectoTIC1.EmpleadoP.Reserva;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

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

    @FXML
    private Button validarReserva;

    @FXML
    private Label esValida;


    List<String> listaActividades = new ArrayList<>();



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
        return actividades;
    }
    public List<Reserva> obtenerReservasConMail(String mail){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/reservas/"+mail+"/").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        List<Reserva> reservas=null;
        try {
            Reserva[] reservasarray=mapper.readValue(response.getBody().toString(),Reserva[].class);
            reservas= Arrays.asList(reservasarray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservas;

    }
    public CentroDeportivo1 obtenerCentroDelManager(){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/reserva/managercentrodep/centroDelManagerLoggeado").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        CentroDeportivo1 centro=null;
        try {
            centro=mapper.readValue(response.getBody().toString(),CentroDeportivo1.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return centro;

    }

    public void validar(ActionEvent event){
        /*for (int i = 0; i < obtenerActividadesConCentro(obtenerCentroDelManager()).size(); i++) {
            if (){}
        }*/
        boolean seHizo=false;
        List<Reserva> reservas=obtenerReservasConMail(mailDeEmp.getText());
        for (int i = 0; i < reservas.size(); i++) {
            if(dias.getValue().equals(reservas.get(i).getDia())){
                validarReserva.setVisible(false);
                seHizo=true;
            }
        }
        if(!seHizo){
            esValida.setText("No hay ninguna reserva del usuario ingresado para ese dia");
        }

        esValida.setText("Reserva valida");
        validarReserva.setVisible(false);
    }

    public void checkIn(){

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = null;
        list.addAll("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo");
        dias.setItems(list);
        ObservableList<String> actividadesCD = null;
        for (int i = 0; i < obtenerActividadesConCentro(obtenerCentroDelManager()).size(); i++) {
            actividadesCD.add(obtenerActividadesConCentro(obtenerCentroDelManager()).get(i).getNombre());
        }
        actividadesList.setItems(actividadesCD);
    }
}
