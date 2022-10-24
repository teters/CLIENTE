package com.example.PrimerProyectoTIC1.EmpresaP;

public class Empresa {
    private Long id;
    private String nombre;
    private String direccion;

    public Empresa(Long telefono, String nombre,String direccion) {
        this.id = telefono;
        this.nombre = nombre;
        this.direccion=direccion;
    }

    public Long getTelefono() {
        return id;
    }

    public void setTelefono(Long telefono) {
        this.id = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

