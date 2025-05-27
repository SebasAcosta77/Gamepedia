package com.jdc.wikyvideojuegos.DTO;

import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;

public class HistoriaRealDTO {
    private Long idhistoriareal;
    private String descripcion;
    private String eventosimportantes;
    private Long videojuego;

    public Long getIdhistoriareal() {
        return idhistoriareal;
    }

    public void setIdhistoriareal(Long idhistoriareal) {
        this.idhistoriareal = idhistoriareal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEventosimportantes() {
        return eventosimportantes;
    }

    public void setEventosimportantes(String eventosimportantes) {
        this.eventosimportantes = eventosimportantes;
    }

    public Long getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Long videojuego) {
        this.videojuego = videojuego;
    }
}
