package com.firma.transport_persoane.dto;

public class RutaDTO {
    private Integer idRuta;
    private Integer idLocalitateInceput;
    private Integer idLocalitateDestinatie;

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Integer getIdLocalitateInceput() {
        return idLocalitateInceput;
    }

    public void setIdLocalitateInceput(Integer idLocalitateInceput) {
        this.idLocalitateInceput = idLocalitateInceput;
    }

    public Integer getIdLocalitateDestinatie() {
        return idLocalitateDestinatie;
    }

    public void setIdLocalitateDestinatie(Integer idLocalitateDestinatie) {
        this.idLocalitateDestinatie = idLocalitateDestinatie;
    }
}