package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.Actividad;
import com.example.PrimerProyectoTIC1.CentroDeportivoP.CentroDeportivo;
import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.List;

public class VentanaActividadController {


    @FXML
    private ImageView imgAct;

    @FXML
    private Label nombreAct;

    @FXML
    private BorderPane borderPane;

    @FXML
    private SplitMenuButton horarioAct;

    @FXML
    private SplitMenuButton centroDepAct;

    @FXML
    private Label ubicacionCentroDep;

    private Actividad actividad;

    public void setData(Actividad actividad){
        this.actividad = actividad;
        nombreAct.setText(actividad.getNombreAct());


        byte[] decodedBytes = Base64.getDecoder().decode(actividad.getImg());
        ByteArrayInputStream is = new ByteArrayInputStream(decodedBytes);
        imgAct.setImage(new Image(is));

    }
    public void setCosasInCoso(){
        horarioAct.getItems().addAll();
    }



}
