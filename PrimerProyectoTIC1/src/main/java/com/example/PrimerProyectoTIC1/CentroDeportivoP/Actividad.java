package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Actividad {

    //private DateTime horario;
    private Long id;

    private String horario;


    private Integer cupos;

    private String nombre;

    private Float precio;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<String> horarios;

    //private String img;


    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }

    private CentroDeportivo1 centroDeportivo1;

    private Boolean reserva;

    private String tipoActividad;


    public Actividad() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public CentroDeportivo1 getCentroDeportivo1() {
        return centroDeportivo1;
    }

    public void setCentroDeportivo1(CentroDeportivo1 centroDeportivo1) {
        this.centroDeportivo1 = centroDeportivo1;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Actividad(Long actividadID, Integer cupos, String nombre, Float precio, String horario, CentroDeportivo1 centroDeportivo1, Boolean reserva, String tipoActividad) {
        this.id = actividadID;
        this.cupos = cupos;
        this.nombre = nombre;
        this.precio = precio;
        this.horario = horario;
        this.centroDeportivo1 = centroDeportivo1;
        this.reserva = reserva;
        this.tipoActividad = tipoActividad;
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



    public CentroDeportivo1 getCentroDeportivo() {
        return centroDeportivo1;
    }

    public void setCentroDeportivo(CentroDeportivo1 centroDeportivo) {
        this.centroDeportivo1 = centroDeportivo;
    }

    public Boolean getReserva() {
        return reserva;
    }

    public void setReserva(Boolean reserva) {
        this.reserva = reserva;
    }


}

