package com.example.PrimerProyectoTIC1;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Imagen {
    Long id;
    byte[] content;
    String nombreActividad;

    public Imagen() {
    }

    public Imagen(Long id, byte[] content, String nombreActividad) {
        this.id = id;
        this.content = content;
        this.nombreActividad = nombreActividad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }
}
