package com.jdc.wikyvideojuegos.DTO;

import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;

public class LoreDTO {
    private Long idlore;
    private String descripcion;
    private String lineatiempo;
    private Long videojuego;

    public Long getIdlore() {
        return idlore;
    }

    public void setIdlore(Long idlore) {
        this.idlore = idlore;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLineatiempo() {
        return lineatiempo;
    }

    public void setLineatiempo(String lineatiempo) {
        this.lineatiempo = lineatiempo;
    }

    public Long getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Long videojuego) {
        this.videojuego = videojuego;
    }
}
