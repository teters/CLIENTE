package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmpleadosEnCentrosController implements Initializable {

    @FXML
    private ChoiceBox<String> actividadesList;

    @FXML
    private ChoiceBox<String> dias;

    @FXML
    private TextField mailDeEmp;

    List<String> listaActividades = new ArrayList<>();


    public void setData(Actividad actividad){
        for (int i = 0; i < listaActividades.size(); i++) {
            if (actividad.equals(listaActividades.get(i))){}
        }


    }

    public void validar(ActionEvent event){
        for (int i = 0; i < listaActividades.size(); i++) {

        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = null;
        list.addAll("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo");
        dias.setItems(list);
    }
}
