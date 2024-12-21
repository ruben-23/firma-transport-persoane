package com.firma.transport_persoane.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clasa folosita ca si cheie primara compusa pentru entitatea LocalitateIntermediara
 */

@Embeddable
public class LocalitateIntermediaraId implements Serializable {
    private Integer idLocalitate;
    private Integer idRuta;

    public LocalitateIntermediaraId() {}

    public LocalitateIntermediaraId(Integer idLocalitate, Integer idRuta) {
        this.idLocalitate = idLocalitate;
        this.idRuta = idRuta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // referinta catre acelasi obiect
        if (o == null || getClass() != o.getClass()) return false; // tipuri diferite

        LocalitateIntermediaraId that = (LocalitateIntermediaraId) o;
        return idLocalitate.equals(that.idLocalitate) &&
                idRuta.equals(that.idRuta);
    }

    // pentru a genera un hash unic bazat pe id-urile ce compun cheia
    @Override
    public int hashCode() {
        return Objects.hash(idLocalitate, idRuta);
    }

    public Integer getIdLocalitate() {
        return idLocalitate;
    }

    public void setIdLocalitate(Integer idLocalitate) {
        this.idLocalitate = idLocalitate;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }
}
