package com.jdc.wikyvideojuegos.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;

@Entity(name = "accesos")
public class AccesoEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idusuario;

    @NotNull
    @Size(min =1, max = 30)
    @Column(name ="nombreacceso")
    private String nombreacceso;

    @NotNull
    @Size(min =1, max = 30)
    @Column(name ="claveacceso")
    private String claveacceso;

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreacceso() {
        return nombreacceso;
    }

    public void setNombreacceso(String nombreacceso) {
        this.nombreacceso = nombreacceso;
    }

    public String getClaveacceso() {
        return claveacceso;
    }

    public void setClaveacceso(String claveacceso) {
        this.claveacceso = claveacceso;
    }

}
