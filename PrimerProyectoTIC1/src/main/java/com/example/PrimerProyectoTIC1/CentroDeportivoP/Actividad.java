package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import java.util.List;

public class Actividad {

    //private DateTime horario;

    private Integer cupos;

    private String nombre;

    private Float precio;

    private String img;

    private String centroDeportivoID;

    public Actividad(Integer cupos, String nombre, Float precio, String img, String centroDeportivoID) {
        this.cupos = cupos;
        this.nombre = nombre;
        this.precio = precio;
        this.img = img;
        this.centroDeportivoID = centroDeportivoID;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCentroDeportivoID() {
        return centroDeportivoID;
    }

    public void setCentroDeportivoID(String centroDeportivoID) {
        this.centroDeportivoID = centroDeportivoID;
    }
}
