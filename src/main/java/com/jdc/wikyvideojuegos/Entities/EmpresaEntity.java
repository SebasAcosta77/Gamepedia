package com.jdc.wikyvideojuegos.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.util.List;

@Entity(name ="empresas")
public class EmpresaEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempresa")
    private Long idempresa;

    @NotNull
    @Size(min =1, max = 255)
    @Column(name ="nombreempresa")
    private String nombres;

    @NotNull
    @Size(min =1, max = 100)
    @Column(name ="paisempresa")
    private String paisempresa;

    @NotNull
    @Column(name ="anofundacion")
    private int anofundacionempresa;

    @NotNull
    @Size(min =1, max = 255)
    @Column(name ="sitioweb")
    private String sitiowebempresa;

    //uno a muchos videoJuegos
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<VideoJuegoEntity> videojuego;

    public Long getIdempresa() {
        return idempresa;
    }

    public List<VideoJuegoEntity> getVideoJuego() {
        return videojuego;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaisempresa() {
        return paisempresa;
    }

    public void setPaisempresa(String paisempresa) {
        this.paisempresa = paisempresa;
    }

    public int getAnofundacionempresa() {
        return anofundacionempresa;
    }

    public void setAnofundacionempresa(int anofundacionempresa) {
        this.anofundacionempresa = anofundacionempresa;
    }

    public String getSitiowebempresa() {
        return sitiowebempresa;
    }

    public void setSitiowebempresa(String sitiowebempresa) {
        this.sitiowebempresa = sitiowebempresa;
    }
}
