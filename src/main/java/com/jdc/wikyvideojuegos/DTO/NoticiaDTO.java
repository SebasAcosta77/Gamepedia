package com.jdc.wikyvideojuegos.DTO;

import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;

import java.util.Date;

public class NoticiaDTO {
    private Long idnoticia;
    private String titulo;
    private String contenido;
    private Date fechapublicacion;
    private String fuente;
    private Long videojuego;

    public Long getIdnoticia() {
        return idnoticia;
    }

    public void setIdnoticia(Long idnoticia) {
        this.idnoticia = idnoticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public Long getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Long videojuego) {
        this.videojuego = videojuego;
    }
}
