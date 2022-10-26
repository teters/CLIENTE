package com.example.PrimerProyectoTIC1.CentroDeportivoP;

import java.util.List;

public class Actividad {

    //private DateTime horario;
    private Long id;

    private Integer cupos;

    private String nombre;

    private Float precio;

    private String horario;

    //private String img;

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

    /*public String getImg() {
        return img;
    }*/

    /*public void setImg(String img) {
        this.img = img;
    }*/

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
