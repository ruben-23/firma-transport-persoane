package com.firma.transport_persoane.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "preturi")
public class Pret {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPret;

    @Column(nullable = false)
    private Double pret;

    @ManyToOne
    @JoinColumn(name = "id_localitate")
    private Localitate localitate;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    @OneToMany(mappedBy = "pret")
    private List<Bilet> bilete;

    public Integer getIdPret() {
        return idPret;
    }

    public void setIdPret(Integer idPret) {
        this.idPret = idPret;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public Localitate getLocalitate() {
        return localitate;
    }

    public void setLocalitate(Localitate localitate) {
        this.localitate = localitate;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public List<Bilet> getBilete() {
        return bilete;
    }

    public void setBilete(List<Bilet> bilete) {
        this.bilete = bilete;
    }
}
