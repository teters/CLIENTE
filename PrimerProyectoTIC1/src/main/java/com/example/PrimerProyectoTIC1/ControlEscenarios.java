package com.example.PrimerProyectoTIC1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControlEscenarios {

    public void cambioDeEscenario(ActionEvent e, String resource) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource(resource));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
