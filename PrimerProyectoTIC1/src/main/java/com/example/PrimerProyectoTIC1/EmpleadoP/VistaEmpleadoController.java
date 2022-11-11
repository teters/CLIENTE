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

    private List<Actividad> actividades = new ArrayList<>();

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
            String nombre = actividades1.get(i).getNombre();
            HttpResponse<JsonNode> response1 = Unirest.get("http://localhost:8080/centrodeportivo/"+actividades1.get(i).getCentro_deportivo_1_id()+"/").
                    header("Content-Type","application/json").asJson();
            ObjectMapper mapper1=new ObjectMapper();
            CentroDeportivo1[] centroAct=null;
            CentroDeportivo1 centroAct2=null;
            List<CentroDeportivo1>centroscoso=null;


            try {
                centroAct=mapper1.readValue(response.getBody().toString(),CentroDeportivo1[].class);
                centroscoso=new ArrayList<>(Arrays.asList(centroAct));
                centroAct2=centroscoso.get(0);
            } catch (IOException e) {
                e.printStackTrace();
            }


            actividades1.get(i).setCentroDeportivo1(centroAct2);
            CentroDeportivo1 centroDep=actividades1.get(i).getCentroDeportivo1();
            horarios.add(actividades1.get(i).getHorario());
            for (int j = i+1; j < actividades1.size(); j++) {

                if (nombre.equals(actividades1.get(j).getNombre())){
                    if (centroDep.getDireccion().equals(actividades1.get(j).getCentroDeportivo1().getDireccion())){
                        horarios.add(actividades1.get(j).getHorario());
                        actividades1.remove(j);
                    }
                }
            }
            actividades1.get(i).setHorarios(horarios);
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

