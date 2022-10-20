package com.example.PrimerProyectoTIC1;

import com.example.PrimerProyectoTIC1.AdminP.Admin;
import com.example.PrimerProyectoTIC1.EmpleadoP.Empleado;
import com.example.PrimerProyectoTIC1.EmpleadoP.VistaEmpleadoController;
import com.example.PrimerProyectoTIC1.EmpresaP.Empresa;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kong.unirest.*;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


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
        boolean login = false;
        Admin admin=new Admin("eduardo@correo.com","Eduardo");
        String mail = username.getText();
        String passwordLogin = password.getText();
        Empleado empleado1=new Empleado(mail,passwordLogin);
        Gson gson=new Gson();
        String body= gson.toJson(empleado1);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/empleado/iniciosesion").
                header("Content-Type","application/json").
                body(new JsonNode(body)).asJson();

        com.fasterxml.jackson.databind.ObjectMapper mapper= new com.fasterxml.jackson.databind.ObjectMapper();
        Empleado empleado=mapper.readValue(response.getBody().toString(),new TypeReference<Empleado>(){});
        System.out.println(response.getBody().toString());

        if (mail.equals(admin.getMail())  && passwordLogin.equals(admin.getContrasena()) ) {
            login = true;
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(OptionPaneController.class.getResource("option-pane.fxml"));
            //Parent root = loader.load(getClass().getResource("option-pane.fxml"));
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
        if (empleado.getMail().equals(mail) && empleado.getPassword().equals(passwordLogin)){
            login=true;
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(VistaEmpleadoController.class.getResource("vista-empleado.fxml"));
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (login==false){
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
