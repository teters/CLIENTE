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

import java.io.IOException;
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
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/empleado/getEmpleadoInicio").
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nombreEmpleado.setText(obtenerEmpleadoDelLogin().getNombre());
        mail.setText(obtenerEmpleadoDelLogin().getMail());
        saldo.setText(Long.toString(obtenerEmpleadoDelLogin().getSaldo()));
        telefono.setText(Long.toString(obtenerEmpleadoDelLogin().getTelefono()));
    }
}
