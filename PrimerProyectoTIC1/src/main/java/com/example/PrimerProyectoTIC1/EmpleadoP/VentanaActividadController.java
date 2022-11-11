package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.Actividad;
import com.example.PrimerProyectoTIC1.CentroDeportivoP.CentroDeportivo1;
import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
import com.example.PrimerProyectoTIC1.Imagen;
import com.example.PrimerProyectoTIC1.LoginController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        Long centro_id=actividad.getCentro_deportivo_1_id();
        HttpResponse<String> response = Unirest.get("http://localhost:8080/centrodeportivo/"+centro_id+"/").
                header("Content-Type","application/json").asString();
        ObjectMapper mapper=new ObjectMapper();
        String nombre_centro=null;
       //     nombre_centro=mapper.readValue(response.getBody().toString(),String.class);
        nombre_centro=response.getBody();

        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        centroDepYLugar.setText(nombre_centro + ",");
        precio.setText(VentanaActividadController.CURRENCY + actividad.getPrecio());
        ObservableList<String> list =  FXCollections.observableArrayList();

        list.addAll("lunes", "martes", "miercoles","jueves", "viernes","sabado","domingo");
        diaAct.setItems(list);
        if (actividad.getReserva()==true){
            reservar.setVisible(true);
            reservar.setOnAction(this::reserva);
            ObservableList<String> horarios = FXCollections.observableArrayList(actividad.getHorarios());
            horarioAct.setItems(horarios);
        } else {
            horarioAct.setValue("Libre horario");
        }

    }

    public void reserva(ActionEvent event){
        Reserva reserva=new Reserva();
        reserva.setActividadId(actividad.getId());
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        String formattedString = localDate.format(formatter);
        reserva.setFecha(formattedString);
        reserva.setDia(diaAct.getValue());
        reserva.setHora(horarioAct.getValue());
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/empleado/getEmpleadoInicio").
                header("Content-Type","application/json").asJson();
        ObjectMapper mapper=new ObjectMapper();
        Empleado empleado=null;

        try {
            empleado=mapper.readValue(response.getBody().toString(),Empleado.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        reserva.setEmpleadoId(empleado.getId());
        posteoReserva(reserva);

    }
    public void posteoReserva(Reserva reserva){
        Gson gson=new Gson();
        String body= gson.toJson(reserva);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/reserva/").
                header("Content-Type","application/json").
                body(new JsonNode(body)).asJson();

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
