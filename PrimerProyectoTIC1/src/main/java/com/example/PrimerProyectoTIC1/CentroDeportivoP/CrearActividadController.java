package com.example.PrimerProyectoTIC1.CentroDeportivoP;


import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kong.unirest.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrearActividadController implements Initializable{
    @FXML
    private TextField cuposActividad;

    @FXML
    private TextArea descripcionActividad;

    @FXML
    private ChoiceBox<String> fechaActividad;

    @FXML
    private TextField horariosActividad;

    @FXML
    private TextField nombreActividad;

    @FXML
    private TextField precioActividad;

    @FXML
    private TextField tipoActividad;

    @FXML
    private Button salirBEmp;

    public void altaActividad(Actividad actividad) {
        String cupos = cuposActividad.getText();
        String descripcion = descripcionActividad.getText();
        String fechaAct = fechaActividad.getValue();
        String horarios = horariosActividad.getText();
        String nombre = nombreActividad.getText();
        String precio = precioActividad.getText();
        String tipo = tipoActividad.getText();
        Actividad actividad1 = new Actividad();
        actividad1.setCupos(Integer.valueOf(cupos));
        actividad1.setDescripcion(descripcion);
        actividad1.setHorario(horarios);
        //como hacemos con la fecha?
        actividad1.setNombre(nombre);
        actividad1.setPrecio(Float.valueOf(precio));
        actividad1.setTipoActividad(tipo);
        //Actividad actividad1 = new Actividad(cupos, descripcion, fechaAct, horarios, nombre, precio, tipo);}
        Gson gson=new Gson();
        String body= gson.toJson(actividad1);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/empleado/iniciosesion").
                header("Content-Type","application/json").
                body(new JsonNode(body)).asJson();
        }
    public void subirFotos(Actividad actividad){


    }

    public void volverEmp(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(CrearActividadController.class.getResource("crear-actividad.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void salirEmp(ActionEvent e){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Salir");
        alerta.setHeaderText("¿Estás seguro que quieres salir?");
        if (alerta.showAndWait().get() == ButtonType.OK){
            Stage stage = (Stage) salirBEmp.getScene().getWindow();
            System.out.println("Has salido exitosamente.");
            stage.close();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> fecha = FXCollections.observableArrayList("Lunes","Martes","Miercoles",
                "Jueves", "Viernes","Sabado");
        fechaActividad.setItems(fecha);
    }


    //Rellenar, eventualmente.


}
