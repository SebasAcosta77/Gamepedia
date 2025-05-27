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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "valoracion")
public class ValoracionEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvaloracion")
    private Long idvaloracion;

    @NotNull
    @Column(name ="puntuacion")
    private int puntuacion;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name ="comentario")
    private String comentario;

    //fk muchos a uno usuarios
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkusuario", referencedColumnName = "idusuario",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UsuarioEntity usuario;

    //getter y setter personalizado para la foranea
    @JsonProperty("fkusuario")
    public Long getIdUsuario() {
        //operador ternario
        return usuario != null ?
                usuario.getIdusuario() : null;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public VideoJuegoEntity getVideoJuego() {
        return videojuego;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

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

    public void setVideoJuego(VideoJuegoEntity videojuego) {
        this.videojuego = videojuego;
    }

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
}
