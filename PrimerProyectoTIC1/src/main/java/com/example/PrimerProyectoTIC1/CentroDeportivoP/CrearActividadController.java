package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.CentroDeportivo1;
import com.example.PrimerProyectoTIC1.OptionPaneController;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kong.unirest.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CrearActividadController {
    public void altaActividad(Actividad actividad){
        Gson gson=new Gson();
        String body= gson.toJson(actividad);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/empleado/iniciosesion").
                header("Content-Type","application/json").
                body(new JsonNode(body)).asJson();
    }

    @FXML
    private TextField cuposActividad;

    @FXML
    private TextArea descripcionActividad;

    @FXML
    private DatePicker fechaActividad;

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


    //Rellenar, eventualmente.


}
