package com.jdc.wikyvideojuegos.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;

@Entity(name = "datocurioso")
public class DatoCuriosoEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddatocurioso")
    private Long iddatocurioso;

    @NotNull
    @Size(min =1, max = 255)
    @Column(name ="descripcion")
    private String descripcion;

    //fk muchos a uno videojuegos
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkvideojuego", referencedColumnName = "idvideojuego",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private VideoJuegoEntity videoJuego;

    //getter y setter personalizado para la foranea
    @JsonProperty("fkvideojuego")
    public Long getIdVideojuego() {
        //operador ternario
        return videoJuego != null ?
                videoJuego.getIdvideojuego() : null;
    }

    public VideoJuegoEntity getVideoJuego() {
        return videoJuego;
    }

    public void setVideoJuego(VideoJuegoEntity videoJuego) {
        this.videoJuego = videoJuego;
    }

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
}
