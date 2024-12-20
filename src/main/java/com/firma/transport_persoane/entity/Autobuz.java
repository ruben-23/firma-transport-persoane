package com.firma.transport_persoane.entity;

import jakarta.persistence.*;

@Entity
@Table(name="autobuze")
public class Autobuz {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idAutobuz;

    @Column(nullable=false)
    private String numarInmatriculare;

    @Column(nullable=false)
    private String status;

    @Column(nullable=false)
    private Integer capacitate;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name="firma")
    private Firma firma;

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

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}
