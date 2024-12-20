package com.firma.transport_persoane.dto;

import java.time.LocalDateTime;

public class BiletDTO {
    private Integer idBilet;
    private LocalDateTime timpCumparare;
    private Integer idPret;
    private Integer idOrar;

    public Integer getIdBilet() {
        return idBilet;
    }

    public void setIdBilet(Integer idBilet) {
        this.idBilet = idBilet;
    }

    public LocalDateTime getTimpCumparare() {
        return timpCumparare;
    }

    public void setTimpCumparare(LocalDateTime timpCumparare) {
        this.timpCumparare = timpCumparare;
    }

    public Integer getIdPret() {
        return idPret;
    }

    public void setIdPret(Integer idPret) {
        this.idPret = idPret;
    }

    public Integer getIdOrar() {
        return idOrar;
    }

    public void setIdOrar(Integer idOrar) {
        this.idOrar = idOrar;
    }
}