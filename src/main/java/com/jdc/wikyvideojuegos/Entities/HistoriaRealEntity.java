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
import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "historiareal")
public class HistoriaRealEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhistoriareal")
    private Long idhistoriareal;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "eventosimportantes", nullable = false)
    private String eventosimportantes;

    // FK muchos a uno con VideoJuegoEntity
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkvideojuego", referencedColumnName = "idvideojuego", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private VideoJuegoEntity videojuego;

    // Getter para exponer solo el id del videojuego en JSON
    @JsonProperty("fkvideojuego")
    public Long getIdVideojuego() {
        return videojuego != null ? videojuego.getIdvideojuego() : null;
    }

    // Getters y Setters

    public Long getIdhistoriareal() {
        return idhistoriareal;
    }

    public void setIdhistoriareal(Long idhistoriareal) {
        this.idhistoriareal = idhistoriareal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEventosimportantes() {
        return eventosimportantes;
    }

    public void setEventosimportantes(String eventosimportantes) {
        this.eventosimportantes = eventosimportantes;
    }

    public VideoJuegoEntity getVideoJuego() {
        return videojuego;
    }

    public void setVideoJuego(VideoJuegoEntity videoJuego) {
        this.videojuego = videoJuego;
    }
}
