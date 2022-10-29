package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.example.PrimerProyectoTIC1.Imagen;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class CrearActividadController {
    public void altaActividad(Actividad actividad){
        Gson gson=new Gson();
        String body= gson.toJson(actividad);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/empleado/iniciosesion").
                header("Content-Type","application/json").
                body(new JsonNode(body)).asJson();
    }
    public void subirFotos(Actividad actividad){


    }


    //Rellenar, eventualmente.


}
