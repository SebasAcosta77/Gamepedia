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

@Entity(name = "comentarios")
public class ComentarioEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomentario")
    private Long idcomentario;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "contenido", nullable = false)
    private String contenido;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechacomentario", nullable = false)
    private Date fechacomentario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkusuario", referencedColumnName = "idusuario", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UsuarioEntity usuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkvideojuego", referencedColumnName = "idvideojuego", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private VideoJuegoEntity videojuego;

    @JsonProperty("fkusuario")
    public Long getIdUsuario() {
        return usuario != null ? usuario.getIdusuario() : null;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @JsonProperty("fkvideojuego")
    public Long getIdVideojuego() {
        return videojuego != null ? videojuego.getIdvideojuego() : null;
    }

    public void setVideojuego(VideoJuegoEntity videojuego) {
        this.videojuego = videojuego;
    }

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

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public VideoJuegoEntity getVideojuego() {
        return videojuego;
    }
}
