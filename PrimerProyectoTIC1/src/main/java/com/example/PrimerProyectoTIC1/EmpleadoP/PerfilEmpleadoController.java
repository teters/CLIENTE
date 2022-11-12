package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.apache.http.HttpRequest;

import java.net.URL;
import java.util.ResourceBundle;

public class PerfilEmpleadoController implements Initializable {


    @FXML
    private Label empresa;

    @FXML
    private Label fechaVenc;

    @FXML
    private Label mail;

    @FXML
    private Label nombreEmpleado;

    @FXML
    private Label saldo;

    @FXML
    private Label telefono;

    @FXML
    void salir(ActionEvent event) {

    }

    @FXML
    void volver(ActionEvent event) {

    }


    public Empleado obtenerEmpleadoDelLogin(){
        //Teo, aca haceme esta response si podes :D

        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
