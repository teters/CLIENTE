package com.example.PrimerProyectoTIC1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.List;

public class Main extends Application {

    private Parent root;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        //fxmlLoader.setControllerFactory(PrimerProyectoTic1Application.getContext()::getBean);
        root = fxmlLoader.load(Main.class.getResourceAsStream("Main.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Login usuario");
        stage.setScene(scene);
        stage.show();
    }


//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

}

//getClass().getResource("datos-usuario.fxml")