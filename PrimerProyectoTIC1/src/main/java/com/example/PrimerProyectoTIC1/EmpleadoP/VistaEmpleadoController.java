package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.Actividad;
import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
import com.example.PrimerProyectoTIC1.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.io.IOException;
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

    private Stage stage;

    private List<Actividad> getData(){
        List<Actividad> actividades= Unirest.get("http://localhost:8080/actividad/").
                header("Content-Type","application/json").
                asObject(new GenericType<List<Actividad>>(){}).getBody();

        Actividad actividad;

        for (int i=0;i<20;i++){
            actividad = new Actividad();

            actividad.setNombreAct(actividades.get(0).getNombreAct());
            actividad.setImg("/imagenes/futbol.jpg");
            actividades.add(actividad);

            actividad.setNombreAct("Basketball");
            actividad.setImg("/imagenes/basketball.jpg");
            actividades.add(actividad);




        }

        return actividades;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        actividades.addAll(getData());
        if (actividades.size() > 0){

        }
        int column = 0;
        int row = 1;
        try{
            for (int i=0;i< actividades.size();i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(VentanaActividadController.class.getResource("ventana-actividad.fxml"));
                BorderPane borderPane = fxmlLoader.load();


                VentanaActividadController ventanaActividadController = fxmlLoader.getController();
                ventanaActividadController.setData(actividades.get(i));

                if (column == 3){
                    column =0;
                    row++;
                }

                grid.add(borderPane, column++, row);
                GridPane.setMargin(borderPane,new Insets(10));
            }
        } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

