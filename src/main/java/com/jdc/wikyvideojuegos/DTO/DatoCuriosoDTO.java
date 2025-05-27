package com.jdc.wikyvideojuegos.DTO;

import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;

public class DatoCuriosoDTO {
    private Long iddatocurioso;
    private String descripcion;
    private Long videoJuego;

    public Long getIddatocurioso() {
        return iddatocurioso;
    }

    public void setIddatocurioso(Long iddatocurioso) {
        this.iddatocurioso = iddatocurioso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getVideoJuego() {
        return videoJuego;
    }

    public void setVideoJuego(Long videoJuego) {
        this.videoJuego = videoJuego;
    }
}
