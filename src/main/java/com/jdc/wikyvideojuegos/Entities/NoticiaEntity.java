package com.jdc.wikyvideojuegos.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.util.Date;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "noticias")
public class NoticiaEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnoticia")
    private Long idnoticia;

    @NotNull
    @Size(min =1, max = 255)
    @Column(name ="titulo")
    private String titulo;

    @NotNull
    @Size(min =1, max = 255)
    @Column(name ="contenido")
    private String contenido;

    @NotNull
    @Column(name ="fechapublicacion")
    private Date fechapublicacion;

    @NotNull
    @Size(min =1, max = 255)
    @Column(name ="fuente")
    private String fuente;

    //fk muchos a uno videojuegos
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkvideojuego", referencedColumnName = "idvideojuego",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private VideoJuegoEntity videojuego;

    //getter y setter personalizado para la foranea
    @JsonProperty("fkvideojuego")
    public Long getIdVideojuego() {
        //operador ternario
        return videojuego != null ?
                videojuego.getIdvideojuego() : null;
    }

    public VideoJuegoEntity getVideoJuego() {
        return videojuego;
    }

    public void setVideoJuego(VideoJuegoEntity videoJuego) {
        this.videojuego = videoJuego;
    }

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
}
