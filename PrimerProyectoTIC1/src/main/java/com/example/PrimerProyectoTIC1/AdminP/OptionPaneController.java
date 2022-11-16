package com.example.PrimerProyectoTIC1.AdminP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.CentroDepController;
import com.example.PrimerProyectoTIC1.CentroDeportivoP.CrearCentroDepController;
import com.example.PrimerProyectoTIC1.EmpresaP.CrearEmpresaController;
import com.example.PrimerProyectoTIC1.EmpresaP.EmpresaPaneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OptionPaneController {

    @FXML
    private Button empresaBtn;

    @FXML
    private Button centroDepBtn;





    public void empresaPane(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(EmpresaPaneController.class.getResource("empresa"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void centroDepPane(ActionEvent e) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(CentroDepController.class.getResource("centro-dep"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void crearEmpresaPane(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(CrearEmpresaController.class.getResource("crear-empresa"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void crearCentroDepPane(ActionEvent a) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(CrearCentroDepController.class.getResource("crear-centro-dep"));
        Stage stage = (Stage)((Node)a.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
