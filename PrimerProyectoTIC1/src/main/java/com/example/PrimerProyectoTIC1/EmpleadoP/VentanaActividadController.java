package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.Actividad;
import com.example.PrimerProyectoTIC1.CentroDeportivoP.CentroDeportivo1;
import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
import com.example.PrimerProyectoTIC1.Imagen;
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
import kong.unirest.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;

public class VentanaActividadController {


    @FXML
    private ImageView imgAct;

    @FXML
    private Label nombreAct;

    @FXML
    private Label centroDepYLugar;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ChoiceBox<String> diaAct;

    @FXML
    private ChoiceBox<String> horarioAct;

    /*@FXML
    private ChoiceBox<String> centroDepAct;
*/

    @FXML
    private Label descripcion;

    @FXML
    private Label tipoAct;

    @FXML
    private Label precio;

    @FXML
    private Button reservar;

    private Actividad actividad;



    public static final String CURRENCY = "$";

    public void setData(Actividad actividad){
        this.actividad = actividad;
        nombreAct.setText(actividad.getNombre());
        //ObservableList<String> centrosDeportivos = FXCollections.observableArrayList(nombreDeCentrosDeportivos(actividad.getCentroDeportivo().getNombre()));
        centroDepYLugar.setText(actividad.getCentroDeportivo1().getNombre() + "," + "" + actividad.getCentroDeportivo1().getDireccion());
        precio.setText(VentanaActividadController.CURRENCY + actividad.getPrecio());
        if (actividad.getReserva()==true){
            Button reservar = new Button();
            reservar.setText("Reservar");
            reservar.setLayoutX(94);
            reservar.setLayoutY(232);
            reservar.setPrefWidth(76);
            reservar.setPrefHeight(32);
            reservar.setOnAction(this::reserva);
            ObservableList<String> horarios = FXCollections.observableArrayList(actividad.getHorarios());
            horarioAct.setItems(horarios);
        } else {
            horarioAct.setValue("Libre horario");
        }

    }

    public void reserva(ActionEvent event){

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

    public List<String> obtenerHorarioConNombreCentroYNombreActividad(String actividad,String centro){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/actividad/"+actividad+"/"+centro+"/horarios").
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
    public List<String> obtenerCentrosAPartirDeUnHorariodeActividad(String actividad, String horario){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/actividad/"+actividad+"/"+horario+"/centro").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        List<String> centro=null;
        try {
            String[] horariosArray=mapper.readValue(response.getBody().toString(),String[].class);
            centro= Arrays.asList(horariosArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return centro;
    }
    public void getFotos(String nombreAct){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/imagen/"+nombreAct).
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        List<Imagen> imagens=null;
        try {
            Imagen[] horariosArray=mapper.readValue(response.getBody().toString(),Imagen[].class);
            imagens= Arrays.asList(horariosArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < imagens.size(); i++) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imagens.get(i).getContent());
            BufferedImage bImage2 = null;
            try {
                bImage2 = ImageIO.read(byteArrayInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                String string=String.valueOf(i);
                ImageIO.write(bImage2, "jpg", new File(nombreAct+string+".jpg") );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




/*  byte[] decodedBytes = Base64.getDecoder().decode(actividad.getImg());
        ByteArrayInputStream is = new ByteArrayInputStream(decodedBytes);
        imgAct.setImage(new Image(is));*/
}
