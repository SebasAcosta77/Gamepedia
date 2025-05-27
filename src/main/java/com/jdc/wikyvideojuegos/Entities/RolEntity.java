package com.jdc.wikyvideojuegos.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.util.List;

@Entity(name = "roles")
public class RolEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Long idrol;

    @NotNull
    @Size(min =1, max = 30)
    @Column(name ="nombrerol")
    private String nombrerol;

    @NotNull
    @Size(min =1, max = 30)
    @Column(name ="estadorol")
    private String estadorol;


    // Relación OneToMany con usuario
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UsuarioEntity> usuario;

    public List<UsuarioEntity> getUsuario() {
        return usuario;
    }

    public Long getIdrol() {
        return idrol;
    }

    public void setIdrol(Long idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public String getEstadorol() {
        return estadorol;
    }

    public void setEstadorol(String estadorol) {
        this.estadorol = estadorol;
    }
}
