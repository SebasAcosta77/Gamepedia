package com.jdc.wikyvideojuegos.DTO;

import com.jdc.wikyvideojuegos.Entities.UsuarioEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;

import java.util.Date;

public class ComentarioDTO {
    private Long idcomentario;
    private String contenido;
    private Date fechacomentario;
    private Long usuario;
    private Long videojuego;

    public Long getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(Long idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechacomentario() {
        return fechacomentario;
    }

    public void setFechacomentario(Date fechacomentario) {
        this.fechacomentario = fechacomentario;
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
