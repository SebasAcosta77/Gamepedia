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
import java.util.Date;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "videojuegos")
public class VideoJuegoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvideojuego")
    private Long idvideojuego;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fechalanzamiento", nullable = false)
    private Date fechalanzamiento;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "caratulaurl", nullable = false)
    private String caratulaurl;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "plataforma", nullable = false)
    private String plataforma;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "genero", nullable = false)
    private String genero;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkempresa", referencedColumnName = "idempresa", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private EmpresaEntity empresa;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<NoticiaEntity> noticias;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ValoracionEntity> valoraciones;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ComentarioEntity> comentarios;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<HistoriaRealEntity> historiasReales;

    @OneToMany(mappedBy = "videoJuego", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DatoCuriosoEntity> datosCuriosos;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ComicEntity> comics;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<LoreEntity> lores;

    // Getter para exponer solo el id de empresa en JSON
    @JsonProperty("fkempresa")
    public Long getIdEmpresa() {
        return empresa != null ? empresa.getIdempresa() : null;
    }

    // Getters y Setters

    public Long getIdvideojuego() {
        return idvideojuego;
    }

    public void setIdvideojuego(Long idvideojuego) {
        this.idvideojuego = idvideojuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechalanzamiento() {
        return fechalanzamiento;
    }

    public void setFechalanzamiento(Date fechalanzamiento) {
        this.fechalanzamiento = fechalanzamiento;
    }

    public String getCaratulaurl() {
        return caratulaurl;
    }

    public void setCaratulaurl(String caratulaurl) {
        this.caratulaurl = caratulaurl;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    public List<NoticiaEntity> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<NoticiaEntity> noticias) {
        this.noticias = noticias;
    }

    public List<ValoracionEntity> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<ValoracionEntity> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public List<ComentarioEntity> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioEntity> comentarios) {
        this.comentarios = comentarios;
    }

    public List<HistoriaRealEntity> getHistoriasReales() {
        return historiasReales;
    }

    public void setHistoriasReales(List<HistoriaRealEntity> historiasReales) {
        this.historiasReales = historiasReales;
    }

    public List<DatoCuriosoEntity> getDatosCuriosos() {
        return datosCuriosos;
    }

    public void setDatosCuriosos(List<DatoCuriosoEntity> datosCuriosos) {
        this.datosCuriosos = datosCuriosos;
    }

    public List<ComicEntity> getComics() {
        return comics;
    }

    public void setComics(List<ComicEntity> comics) {
        this.comics = comics;
    }

    public List<LoreEntity> getLores() {
        return lores;
    }

    public void setLores(List<LoreEntity> lores) {
        this.lores = lores;
    }
}
