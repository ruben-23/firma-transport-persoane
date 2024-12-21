package com.firma.transport_persoane.dto;

import com.firma.transport_persoane.entity.LocalitateIntermediaraId;

public class LocalitateIntermediaraDTO {
    private LocalitateIntermediaraId idLocalitateIntermediara;
    private Integer idRuta;
    private Integer idLocalitate;
    private Integer ordine;

    public LocalitateIntermediaraId getIdLocalitateIntermediara() {
        return idLocalitateIntermediara;
    }

    public void setIdLocalitateIntermediara(LocalitateIntermediaraId idLocalitateIntermediara) {
        this.idLocalitateIntermediara = idLocalitateIntermediara;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Integer getIdLocalitate() {
        return idLocalitate;
    }

    public void setIdLocalitate(Integer idLocalitate) {
        this.idLocalitate = idLocalitate;
    }

    public Integer getOrdine() {
        return ordine;
    }

    public void setOrdine(Integer ordine) {
        this.ordine = ordine;
    }



}