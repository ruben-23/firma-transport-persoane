package com.firma.transport_persoane.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bilete")
public class Bilet {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idBilet;

    private LocalDateTime timpCumparare;

    @ManyToOne
    @JoinColumn(name = "id_pret")
    private Pret pret;

    @ManyToOne
    @JoinColumn(name = "id_orar")
    private Orar orar;

    @OneToMany(mappedBy = "pret")
    private List<Pret> preturi;

    public Integer getIdBilet() {
        return idBilet;
    }

    public void setIdBilet(Integer idBilet) {
        this.idBilet = idBilet;
    }

    public Orar getOrar() {
        return orar;
    }

    public void setOrar(Orar orar) {
        this.orar = orar;
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }

    public LocalDateTime getTimpCumparare() {
        return timpCumparare;
    }

    public void setTimpCumparare(LocalDateTime timpCumparare) {
        this.timpCumparare = timpCumparare;
    }

}
