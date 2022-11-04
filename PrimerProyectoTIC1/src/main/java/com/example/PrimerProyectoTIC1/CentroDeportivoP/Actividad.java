package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.example.PrimerProyectoTIC1.EmpleadoP.Reserva;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Lob;
import java.util.List;

public class Actividad {

    //private DateTime horario;
    private List<Reserva> Reservas;
    private Long id;

    private CentroDeportivo1 centroDeportivo1;
    private String horario;
    private String dia;

    private Integer cupos;

    private String nombre;

    private Float precio;


    private String descripcion;

    private Boolean reserva;

    private String tipoActividad;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<String> horarios;

    //private String img;




    public Actividad() {
    }

    public List<Reserva> getReservas() {
        return Reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        Reservas = reservas;
    }

    public Actividad(Long actividadID, Integer cupos, String nombre, Float precio, String dia, String horario, CentroDeportivo1 centroDeportivo1, Boolean reserva, String tipoActividad, String descripcion) {
        this.id = actividadID;
        this.centroDeportivo1 = centroDeportivo1;
        this.horario = horario;
        this.cupos = cupos;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion=descripcion;
        this.dia = dia;
        this.reserva = reserva;
        this.tipoActividad = tipoActividad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CentroDeportivo1 getCentroDeportivo1() {
        return centroDeportivo1;
    }

    public void setCentroDeportivo1(CentroDeportivo1 centroDeportivo1) {
        this.centroDeportivo1 = centroDeportivo1;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getReserva() {
        return reserva;
    }

    public void setReserva(Boolean reserva) {
        this.reserva = reserva;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }
}

