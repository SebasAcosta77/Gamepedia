package com.jdc.wikyvideojuegos.DTO;

import com.jdc.wikyvideojuegos.Entities.EmpresaEntity;

import java.util.Date;

public class VideoJuegoDTO {
    private Long idvideojuego;
    private String titulo;
    private String descripcion;
    private Date fechalanzamiento;
    private String caratulaurl;
    private String plataforma;
    private String genero;
    private Long empresa;

    public Long getIdvideojuego() {
        return idvideojuego;
    }

    public void setIdvideojuego(Long idvideojuego) {
        this.idvideojuego = idvideojuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechalanzamiento() {
        return fechalanzamiento;
    }

    public void setFechalanzamiento(Date fechalanzamiento) {
        this.fechalanzamiento = fechalanzamiento;
    }

    public String getCaratulaurl() {
        return caratulaurl;
    }

    public void setCaratulaurl(String caratulaurl) {
        this.caratulaurl = caratulaurl;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }
}
