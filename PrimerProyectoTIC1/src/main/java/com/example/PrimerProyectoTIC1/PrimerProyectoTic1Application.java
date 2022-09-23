package com.example.PrimerProyectoTIC1;

import javafx.application.Application;
import javafx.scene.Scene;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PrimerProyectoTic1Application {

	//private static ConfigurableApplicationContext context;

	public static void main(String[] args) {

		Application.launch(Main.class,args);
	}

	//public static ConfigurableApplicationContext getContext() {return context; }
}
