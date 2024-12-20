package com.firma.transport_persoane.dto;

import java.time.LocalTime;

public class OrarDTO {
    private Integer idOrar;
    private LocalTime oraPlecare;
    private String zi;
    private Integer idLocalitatePlecare;
    private Integer idRuta;

    public Integer getIdOrar() {
        return idOrar;
    }

    public void setIdOrar(Integer idOrar) {
        this.idOrar = idOrar;
    }

    public LocalTime getOraPlecare() {
        return oraPlecare;
    }

    public void setOraPlecare(LocalTime oraPlecare) {
        this.oraPlecare = oraPlecare;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public Integer getIdLocalitatePlecare() {
        return idLocalitatePlecare;
    }

    public void setIdLocalitatePlecare(Integer idLocalitatePlecare) {
        this.idLocalitatePlecare = idLocalitatePlecare;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }
}