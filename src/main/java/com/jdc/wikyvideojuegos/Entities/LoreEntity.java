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

@Entity(name = "lore")
public class LoreEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlore")
    private Long idlore;

    @NotNull
    @Size(min =1, max = 255)
    @Column(name ="descripcion")
    private String descripcion;

    @NotNull
    @Size(min =1, max = 255)
    @Column(name ="lineatiempo")
    private String lineatiempo;

    //fk muchos a uno videojuegos
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkvideojuego", referencedColumnName = "idvideojuego", nullable = false)
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

    public Long getIdlore() {
        return idlore;
    }

    public void setIdlore(Long idlore) {
        this.idlore = idlore;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLineatiempo() {
        return lineatiempo;
    }

    public void setLineatiempo(String lineatiempo) {
        this.lineatiempo = lineatiempo;
    }
}
