package com.firma.transport_persoane.dto;

public class AutobuzDTO {
    private Integer idAutobuz;
    private String numarInmatriculare;
    private String status;
    private Integer capacitate;
    private Integer idRuta;
    private Integer idFirma;

    public Integer getIdAutobuz() {
        return idAutobuz;
    }

    public void setIdAutobuz(Integer idAutobuz) {
        this.idAutobuz = idAutobuz;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(String numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(Integer capacitate) {
        this.capacitate = capacitate;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Integer getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(Integer idFirma) {
        this.idFirma = idFirma;
    }
}