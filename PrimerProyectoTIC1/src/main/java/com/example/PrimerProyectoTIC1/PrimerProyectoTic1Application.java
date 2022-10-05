package com.example.PrimerProyectoTIC1;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.scene.Scene;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PrimerProyectoTic1Application {

	//private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		Admin admin=new Admin("eduardo@correo.com","Eduardo",0100L );
		Gson gson=new Gson();
		String administrator=gson.toJson(admin);
		//try {
			//HttpResponse<JsonNode> jsonNodeHttpResponse1= Unirest.get("http://localhost:8080/admins/").asJson();
		//}catch (Exception e){
			//HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.post("http://localhost:8080/admins/").header("Content-Type","application/json").body(new JsonNode(administrator)).asJson();
		//}


		Application.launch(Main.class,args);
	}

	//public static ConfigurableApplicationContext getContext() {return context; }
}
