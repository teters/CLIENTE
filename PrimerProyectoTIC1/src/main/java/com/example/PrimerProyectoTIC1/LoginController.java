package com.example.PrimerProyectoTIC1;

import com.example.PrimerProyectoTIC1.AdminP.Admin;
import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginBtn;

    @FXML
    private Label textoError;

    @FXML
    private Button salirBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void adminAceptado(ActionEvent e) throws IOException {
        Admin admin=new Admin("eduardo@correo.com","Eduardo");
        String mail = username.getText();
        String passwordLogin = password.getText();
        if (mail ==admin.getMail() && passwordLogin == admin.getContrasena()) {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("option-pane.fxml"));
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            textoError.setText("Usuario o contraseña incorrectos");
        }
    }

    public void closeWindow(ActionEvent event){
        exitWindow();
    }

    private void exitWindow(){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Salir");
        alerta.setHeaderText("¿Estás seguro que quieres salir?");
        if (alerta.showAndWait().get() == ButtonType.OK){
            stage = (Stage) salirBtn.getScene().getWindow();
            System.out.println("Has salido exitosamente.");
            stage.close();
        }

    }





}
