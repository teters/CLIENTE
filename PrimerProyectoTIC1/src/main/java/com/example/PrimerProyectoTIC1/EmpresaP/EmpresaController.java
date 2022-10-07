package com.example.PrimerProyectoTIC1.EmpresaP;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EmpresaController implements Initializable {
    @FXML
    private TableView<Empresa> empresaTabla;
    @FXML
    private TableColumn<Empresa, Long> colTelefono;
    @FXML
    private TableColumn<Empresa, String> colNombreE;
    @FXML
    private TableColumn<Empresa, String> colDireccionE;

    @FXML
    private TextField nombreE;
    @FXML
    private TextField telefonoE;
    @FXML
    private TextField direccionE;


    public void agregarEmpresa(ActionEvent actionEvent){
        Empresa empresa = new Empresa(Long.parseLong(telefonoE.getText()),nombreE.getText(),direccionE.getText());
        empresaTabla.getItems().add(empresa);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    //
}
