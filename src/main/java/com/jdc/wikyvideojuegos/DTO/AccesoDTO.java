package com.jdc.wikyvideojuegos.DTO;

public class AccesoDTO {
    private Long idusuario;
    private String nombreacceso;
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
