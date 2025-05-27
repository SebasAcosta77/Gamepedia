package com.jdc.wikyvideojuegos.DTO;

import com.jdc.wikyvideojuegos.Entities.UsuarioEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;

public class ValoracionDTO {
    private Long idvaloracion;
    private int puntuacion;
    private String comentario;
    private Long usuario;
    private Long videojuego;

    public Long getIdvaloracion() {
        return idvaloracion;
    }

    public void setIdvaloracion(Long idvaloracion) {
        this.idvaloracion = idvaloracion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Long videojuego) {
        this.videojuego = videojuego;
    }
}
