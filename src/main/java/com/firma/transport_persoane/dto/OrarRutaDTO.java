package com.firma.transport_persoane.dto;

import java.time.LocalTime;

public class OrarRutaDTO {

    private String zi;
    private String rutaPlecare;
    private String rutaDestinatie;
    private String plecare;
    private LocalTime ora;
    private Double pret;

    public OrarRutaDTO(String zi, String rutaPlecare, String rutaDestinatie,
                       String plecare, LocalTime ora, Double pret) {
        this.zi = zi;
        this.rutaPlecare = rutaPlecare;
        this.rutaDestinatie = rutaDestinatie;
        this.plecare = plecare;
        this.ora = ora;
        this.pret = pret;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public String getRutaPlecare() {
        return rutaPlecare;
    }

    public void setRutaPlecare(String rutaPlecare) {
        this.rutaPlecare = rutaPlecare;
    }

    public String getRutaDestinatie() {
        return rutaDestinatie;
    }

    public void setRutaDestinatie(String rutaDestinatie) {
        this.rutaDestinatie = rutaDestinatie;
    }

    public String getPlecare() {
        return plecare;
    }

    public void setPlecare(String plecare) {
        this.plecare = plecare;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }
}
