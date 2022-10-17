package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.Actividad;
import com.example.PrimerProyectoTIC1.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VistaEmpleadoController implements Initializable {

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Actividad> actividades = new ArrayList<>();

    private List<Actividad> getData(){
        List<Actividad> actividades = new ArrayList<>();
        Actividad actividad;

        for (int i=0;i<20;i++){
            actividad = new Actividad();
            actividad.setNombreAct("Futbol");
            actividad.setImg("/imagenes/soccer ball hit into a goal.jpg");
            actividades.add(actividad);
        }

        return actividades;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i=0;i< actividades.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(VentanaActividadController.class.getResource("ventana-actividad.fxml"));

        }


    }
}
