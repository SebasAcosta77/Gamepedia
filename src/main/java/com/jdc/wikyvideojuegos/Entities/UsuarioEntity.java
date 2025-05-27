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
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "usuarios")
public class UsuarioEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idusuario;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre", nullable = false)
    private String nombre;


    @NotNull
    @Size(min =1, max = 30)
    @Column(name ="documento")
    private String documentousuario;

    @NotNull
    @Size(min =1, max = 30)
    @Column(name ="correo")
    private String correousuario;

    @NotNull
    @Column(name ="fechanacimiento")
    private Date fechanacimientousuario;

    //fk muchos a uno rol
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkrol", referencedColumnName = "idrol",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private RolEntity rol;

    //uno a muchos comentarios
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ComentarioEntity> comentarios;

    //uno a muchos valoracion
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ValoracionEntity> valoracion;

    //getter y setter personalizado para la foranea
    @JsonProperty("fkrol")
    public Long getIdRol() {
        //operador ternario
        return rol != null ?
                rol.getIdrol() : null;
    }

    public RolEntity getRol() {
        return rol;
    }

    public List<ComentarioEntity> getComentarios() {
        return comentarios;
    }

    public List<ValoracionEntity> getValoracion() {
        return valoracion;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombre;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombre = nombreusuario;
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
}
