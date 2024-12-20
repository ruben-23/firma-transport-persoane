package com.firma.transport_persoane.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "localitati_intermediare")
public class LocalitateIntermediara {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idLocalitateIntermediara;

    @ManyToOne
    @JoinColumn(name="id_ruta")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name="id_localitate")
    private Localitate localitate;

    @Column
    private Integer ordine;

    public Integer getIdLocalitateIntermediara() {
        return idLocalitateIntermediara;
    }

    public void setIdLocalitateIntermediara(Integer idLocalitateIntermediara) {
        this.idLocalitateIntermediara = idLocalitateIntermediara;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Localitate getLocalitate() {
        return localitate;
    }

    public void setLocalitate(Localitate localitate) {
        this.localitate = localitate;
    }

    public Integer getOrdine() {
        return ordine;
    }

    public void setOrdine(Integer ordine) {
        this.ordine = ordine;
    }
}
