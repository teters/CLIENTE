package com.example.PrimerProyectoTIC1.EmpleadoP;

import com.example.PrimerProyectoTIC1.CentroDeportivoP.Actividad;

import java.time.LocalDate;

public class Reserva {
    private Long id;
    private Actividad actividad;
    private Empleado empleado;
    //private String fechaAct;
    private String horaAct;
    private String dia;
    private LocalDate fechaReserva;

    public Reserva(Actividad actividad, Empleado empleado, String horaAct, String dia, LocalDate fechaReserva) {
        this.actividad = actividad;
        this.empleado = empleado;
        //this.fechaAct = fechaAct;
        this.horaAct = horaAct;
        this.dia = dia;
        this.fechaReserva = fechaReserva;
    }

    public Reserva() {
    }

    public Long getId() {
        return id;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    /*public String getFechaAct() {
        return fechaAct;
    }*/

    public String getHoraAct() {
        return horaAct;
    }

    public String getDia() {
        return dia;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /*public void setFechaAct(String fechaAct) {
        this.fechaAct = fechaAct;
    }*/

    public void setHoraAct(String horaAct) {
        this.horaAct = horaAct;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}