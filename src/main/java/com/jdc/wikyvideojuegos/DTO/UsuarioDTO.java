package com.jdc.wikyvideojuegos.DTO;

import com.jdc.wikyvideojuegos.Entities.RolEntity;

import java.util.Date;

public class UsuarioDTO {
    private Long idusuario;
    private String nombreusuario;
    private String documentousuario;
    private String correousuario;
    private Date fechanacimientousuario;
    private Long rol;

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getDocumentousuario() {
        return documentousuario;
    }

    public void setDocumentousuario(String documentousuario) {
        this.documentousuario = documentousuario;
    }

    public String getCorreousuario() {
        return correousuario;
    }

    public void setCorreousuario(String correousuario) {
        this.correousuario = correousuario;
    }

    public Date getFechanacimientousuario() {
        return fechanacimientousuario;
    }

    public void setFechanacimientousuario(Date fechanacimientousuario) {
        this.fechanacimientousuario = fechanacimientousuario;
    }

    public Long getRol() {
        return rol;
    }

    public void setRol(Long rol) {
        this.rol = rol;
    }
}
