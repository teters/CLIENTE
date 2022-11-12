package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.example.PrimerProyectoTIC1.CheckIn;
<<<<<<< HEAD
import com.example.PrimerProyectoTIC1.CheckinDTO;
import com.example.PrimerProyectoTIC1.EmpleadoP.Empleado;
=======
>>>>>>> 77857394395996b6b2bcc15c7a24bd7ee421b198
import com.example.PrimerProyectoTIC1.EmpleadoP.Reserva;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.hibernate.annotations.Check;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/centrodeportivo/"+centro.getId()+"/actividades").
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
    public Empleado obtenerEmpleadoConMail(String mail){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/empleado/"+mail+"/").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        Empleado empleado=null;
        try {
            empleado=mapper.readValue(response.getBody().toString(),Empleado.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return empleado;



    }
    public CentroDeportivo1 obtenerCentroDelManager(){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/managercentrodep/centroDelManagerLoggeado").
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
    public Actividad obtenerActividadConNombre(String nombre){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/actividad/"+nombre+"/").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        Actividad actividad=null;
        try {
            actividad=mapper.readValue(response.getBody().toString(),Actividad.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return actividad;


    }

    public void checkIn(ActionEvent event){
        CheckIn checkIn=new CheckIn();
        Empleado empleado=obtenerEmpleadoConMail(mailDeEmp.getText());
        CheckinDTO checkindto=new CheckinDTO();
        checkIn.setEmpleado(empleado);
        checkIn.setHora(LocalDateTime.now());
        checkIn.setActividad(obtenerActividadConNombre(actividadesList.getValue()));
        Actividad actividad=obtenerActividadConNombre(actividadesList.getValue());
        checkindto.setId_empleado(empleado.getId());
        checkindto.setHora(LocalDateTime.now());
        checkindto.setId_actividad(actividad.getId());
        Gson gson=new Gson();
        String body= gson.toJson(checkindto);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/checkIn/").
                header("Content-Type","application/json").header("Accept","application/json").
                body(new JsonNode(body)).asJson();
        System.out.println(response);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo");
        dias.setItems(list);
        ObservableList<String> actividadesCD = FXCollections.observableArrayList();
        CentroDeportivo1 centroManager=obtenerCentroDelManager();
        List<Actividad> actividades=obtenerActividadesConCentro(centroManager);
        for (int i = 0; i < actividades.size(); i++) {
            actividadesCD.add(actividades.get(i).getNombre());
        }
        actividadesList.setItems(actividadesCD);


    }
}
