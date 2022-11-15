package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.Actividad;
import com.example.PrimerProyectoTIC1.CentroDeportivoP.CentroDeportivo1;
import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
import com.example.PrimerProyectoTIC1.LoginController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class VistaEmpleadoController implements Initializable {

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Actividad> actividades = new LinkedList<>();

    private Stage stage;

    public List<Actividad> getData(){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/actividad/todas").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        List<Actividad> actividades1=null;

        try {
            Actividad[] actividadsArray=mapper.readValue(response.getBody().toString(),Actividad[].class);
            actividades1=new ArrayList<>(Arrays.asList(actividadsArray)) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> horarios = new ArrayList<>();
        for (int i = 0; i < actividades1.size(); i++) {
            horarios.add(actividades1.get(i).getHorario());
            actividades1.get(i).setHorarios(horarios);
            for (int j = i+1; j < actividades1.size(); j++) {
                if(actividades1.get(i).getNombre().equals(actividades1.get(j).getNombre())){
                    actividades1.remove(j);
                }

            }
        }

        /*for (int i = 0; i < Objects.requireNonNull(actividades1).size(); i++) {
            VentanaActividadController ventanaActividadController=new VentanaActividadController();
            ventanaActividadController.setData(actividades1.get(i));

        }*/

        return actividades1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        actividades.addAll(getData());
        List<String> nombresact=new ArrayList<>();

        int column = 0;
        int row = 1;
        try{

            for (int i=0;i< actividades.size();i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(VentanaActividadController.class.getResource("ventana-actividad.fxml"));
                BorderPane borderPane = fxmlLoader.load();


                VentanaActividadController ventana = fxmlLoader.getController();
                ventana.setData(actividades.get(i));

                if (column == 2){
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

