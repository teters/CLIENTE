package com.example.PrimerProyectoTIC1;

import com.example.PrimerProyectoTIC1.AdminP.Admin;
import com.example.PrimerProyectoTIC1.EmpleadoP.Empleado;
import com.example.PrimerProyectoTIC1.EmpleadoP.VistaEmpleadoController;
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
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.IOException;
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
        List<Empleado> empleados= Unirest.get("http://localhost:8080/empleado/").
                header("Content-Type","application/json").
                asObject(new GenericType<List<Empleado>>(){}).getBody();

        if (mail.equals(admin.getMail())  && passwordLogin.equals(admin.getContrasena()) ) {
            login = true;
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("option-pane.fxml"));
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        for (int i=0;i<empleados.size();i++){
            if (empleados.get(i).getMail() == mail){
                if (empleados.get(i).getPassword() == passwordLogin){
                    login = true;
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = loader.load(VistaEmpleadoController.class.getResource("vista-empleado.fxml"));
                    Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
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
