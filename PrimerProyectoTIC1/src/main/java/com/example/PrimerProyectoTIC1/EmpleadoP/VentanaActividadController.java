package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.Actividad;
import com.example.PrimerProyectoTIC1.CentroDeportivoP.CentroDeportivo;
import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
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
import kong.unirest.Unirest;

import java.io.ByteArrayInputStream;
import java.net.URL;
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

    private Actividad actividad;

    public void setData(Actividad actividad){
        this.actividad = actividad;
        nombreAct.setText(actividad.getNombreAct());




    }
    public void reserva(ActionEvent event){
        String centroDep = centroDepAct.getValue();
        /*for (int i=0;i<listaCentroDep.size();i++){
            if (centroDep == listaCentroDep.get(i).getNombre()){

            }
        }*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     //   centroDepAct.setItems();
    }


/*  byte[] decodedBytes = Base64.getDecoder().decode(actividad.getImg());
        ByteArrayInputStream is = new ByteArrayInputStream(decodedBytes);
        imgAct.setImage(new Image(is));*/
}
