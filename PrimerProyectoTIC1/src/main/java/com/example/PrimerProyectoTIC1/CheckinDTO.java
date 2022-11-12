package com.example.PrimerProyectoTIC1;


import java.time.LocalDateTime;

    public class CheckinDTO {
        private Long id_empleado;
        private Long id_actividad;
        private LocalDateTime hora;


        public Long getId_empleado() {
            return id_empleado;
        }

        public void setId_empleado(Long id_empleado) {
            this.id_empleado = id_empleado;
        }

        public Long getId_actividad() {
            return id_actividad;
        }

        public void setId_actividad(Long id_actividad) {
            this.id_actividad = id_actividad;
        }

        public LocalDateTime getHora() {
            return hora;
        }

        public void setHora(LocalDateTime hora) {
            this.hora = hora;
        }
    }

