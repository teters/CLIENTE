package com.example.PrimerProyectoTIC1.EmpleadoP;

import java.time.LocalDate;

public class Empleado {
    private Long id;
    private String nombre;
    private Long telefono;
    private String mail;
    private String password;
    private Long saldo;
    private LocalDate fechaNacimiento;
    private Long empresaID;

    public Empleado(Long id, String nombre, Long telefono, String mail, String password, Long saldo, LocalDate fechaNacimiento, Long empresaID) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.password = password;
        this.saldo = saldo;
        this.fechaNacimiento = fechaNacimiento;
        this.empresaID = empresaID;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getEmpresaID() {
        return empresaID;
    }

    public void setEmpresaID(Long empresaID) {
        this.empresaID = empresaID;
    }
}
