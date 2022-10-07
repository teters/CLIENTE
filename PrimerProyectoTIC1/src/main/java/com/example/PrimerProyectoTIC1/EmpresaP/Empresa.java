package com.example.PrimerProyectoTIC1.EmpresaP;

public class Empresa {
    private Long telefono;
    private String nombre;
    private String direccion;

    public Empresa(Long telefono, String nombre,String direccion) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion=direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
