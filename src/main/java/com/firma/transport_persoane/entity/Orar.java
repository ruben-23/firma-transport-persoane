package com.firma.transport_persoane.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "orare")
public class Orar {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idOrar;

    @Column(nullable = false)
    private LocalTime oraPlecare;

    @Column(nullable = false)
    private String zi;

    @ManyToOne
    @JoinColumn(name = "id_localitate_plecare")
    private Localitate localitatePlecare;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    @OneToMany(mappedBy = "orar")
    private List<Bilet> bilete;


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

    public Localitate getLocalitatePlecare() {
        return localitatePlecare;
    }

    public void setLocalitatePlecare(Localitate localitatePlecare) {
        this.localitatePlecare = localitatePlecare;
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
