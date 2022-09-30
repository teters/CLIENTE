package com.example.PrimerProyectoTIC1;

public class Admin {
    private String mail;
    private String nombre;
    private Long telefono;

    public Admin(String mail, String nombre, Long telefono) {
        this.mail = mail;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
}
