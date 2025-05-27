package com.jdc.wikyvideojuegos.DTO;

import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;

import java.util.Date;

public class ComicDTO {
    private Long idcomic;
    private String titulo;
    private String resumen;
    private Date fechapublicacion;
    private String urlimagen;
    private Long videojuego;

    public Long getIdcomic() {
        return idcomic;
    }

    public void setIdcomic(Long idcomic) {
        this.idcomic = idcomic;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public Long getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Long videojuego) {
        this.videojuego = videojuego;
    }
}
