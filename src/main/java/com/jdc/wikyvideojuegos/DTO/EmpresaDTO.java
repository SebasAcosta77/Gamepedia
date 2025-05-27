package com.jdc.wikyvideojuegos.DTO;

public class EmpresaDTO {
    private Long idempresa;
    private String nombres;
    private String paisempresa;
    private int anofundacionempresa;
    private String sitiowebempresa;

    public Long getIdempresa() {
        return idempresa;
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
