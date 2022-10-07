package com.example.PrimerProyectoTIC1.CentroDeportivoP;

public class CentroDeportivo {

    private String nombre;

    private String direccion;

    public CentroDeportivo(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
