package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import java.util.List;

public class Actividad {

    private String horario;

    private Integer cupos;

    private String nombre;

    private Float precio;

    private String img;

    private String centroDeportivoID;

    private CentroDeportivo centroDeportivo;

    private Boolean reserva;

    private String tipoActividad;

    public Actividad(String horario, Integer cupos, String nombre, Float precio, String img, String centroDeportivoID, CentroDeportivo centroDeportivo, Boolean reserva, String tipoActividad) {
        this.horario = horario;
        this.cupos = cupos;
        this.nombre = nombre;
        this.precio = precio;
        this.img = img;
        this.centroDeportivoID = centroDeportivoID;
        this.centroDeportivo = centroDeportivo;
        this.reserva = reserva;
        this.tipoActividad = tipoActividad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    public CentroDeportivo getCentroDeportivo() {
        return centroDeportivo;
    }

    public void setCentroDeportivo(CentroDeportivo centroDeportivo) {
        this.centroDeportivo = centroDeportivo;
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

