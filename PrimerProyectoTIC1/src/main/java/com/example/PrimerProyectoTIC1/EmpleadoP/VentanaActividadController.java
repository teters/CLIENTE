package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.Actividad;
import com.example.PrimerProyectoTIC1.CentroDeportivoP.CentroDeportivo;
import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;

public class VentanaActividadController implements Initializable {


    @FXML
    private ImageView imgAct;

    @FXML
    private Label nombreAct;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ChoiceBox<String> horarioAct;

    @FXML
    private ChoiceBox<String> centroDepAct;

    @FXML
    private Label ubicacionCentroDep;

    @FXML
    private Button reservar;

    private String actividad;



    public void setData(String actividad){
        this.actividad = actividad;
        this.nombreAct=new Label();
        nombreAct.setText(actividad);
       /* ObservableList<String> centrosDeportivos = FXCollections.observableArrayList(nombreDeCentrosDeportivos(actividad));
        centroDepAct.setItems(centrosDeportivos);*/
    }
    public void reserva(ActionEvent event){
        String centroDep = centroDepAct.getValue();
        /*for (int i=0;i<listaCentroDep.size();i++){
            if (centroDep == listaCentroDep.get(i).getNombre()){

            }
        }*/
    }
    public List<String> nombreDeCentrosDeportivos(String nombredeactividad){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/actividad/"+nombredeactividad+"/centros").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        List<String> centros=null;
        try {
            String[] nombres=mapper.readValue(response.getBody().toString(),String[].class);
            centros= Arrays.asList(nombres);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return centros;
    }
    public List<String> horariosDeActividad(String nombredeact){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/actividad/"+nombredeact+"/horarios").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        List<String> horarios=null;
        try {
            String[] horariosArray=mapper.readValue(response.getBody().toString(),String[].class);
            horarios= Arrays.asList(horariosArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return horarios;

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


/*  byte[] decodedBytes = Base64.getDecoder().decode(actividad.getImg());
        ByteArrayInputStream is = new ByteArrayInputStream(decodedBytes);
        imgAct.setImage(new Image(is));*/
}
