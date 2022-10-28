package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class CrearActividadController {
    public void altaActividad(Actividad actividad){
        Gson gson=new Gson();
        String body= gson.toJson(actividad);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/empleado/iniciosesion").
                header("Content-Type","application/json").
                body(new JsonNode(body)).asJson();
    }


    //Rellenar, eventualmente.


}
