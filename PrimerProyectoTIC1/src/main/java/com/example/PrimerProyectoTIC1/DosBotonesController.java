package com.example.PrimerProyectoTIC1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DosBotonesController {

    @FXML
    private Button empresaBtn;

    @FXML
    private Button centroDepBtn;



    public void empresaPane(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("empresa.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void centroDepPane(ActionEvent e) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("centro-deportivo.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
