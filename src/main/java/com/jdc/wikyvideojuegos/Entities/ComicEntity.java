package com.jdc.wikyvideojuegos.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "comic")
public class ComicEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomic")
    private Long idcomic;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titulo")
    private String titulo;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "resumen")
    private String resumen;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fechapublicacion")
    private Date fechapublicacion;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "urlimagen")
    private String urlimagen;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkvideojuego", referencedColumnName = "idvideojuego", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private VideoJuegoEntity videojuego;

    // Getter para enviar el ID del videojuego en lugar del objeto completo
    @JsonProperty("fkvideojuego")
    public Long getIdVideojuego() {
        return videojuego != null ? videojuego.getIdvideojuego() : null;
    }

    // Setters y getters
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

    public VideoJuegoEntity getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(VideoJuegoEntity videojuego) {
        this.videojuego = videojuego;
    }
}
