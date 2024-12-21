package com.firma.transport_persoane.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="localitati")
public class Localitate {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idLocalitate;

    @Column(nullable=false)
    private String nume;

    // rute care au ca punct de plecare localitatea
    @OneToMany(mappedBy = "localitateInceput")
    private List<Ruta> ruteLocalitatiInceput;

    // rute care au ca destinatie localitatea
    @OneToMany(mappedBy = "localitateDestinatie")
    private List<Ruta> ruteLocalitatiDestinatie;

    @OneToMany(mappedBy = "localitate")
    private List<LocalitateIntermediara> localitatiIntermediare;

    @OneToMany(mappedBy = "localitate")
    private List<Pret> preturi;

    public Integer getIdLocalitate() {
        return idLocalitate;
    }

    public void setIdLocalitate(Integer idLocalitate) {
        this.idLocalitate = idLocalitate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Ruta> getRuteLocalitatiInceput() {
        return ruteLocalitatiInceput;
    }

    public void setRuteLocalitatiInceput(List<Ruta> ruteLocalitatiInceput) {
        this.ruteLocalitatiInceput = ruteLocalitatiInceput;
    }

    public List<Ruta> getRuteLocalitatiDestinatie() {
        return ruteLocalitatiDestinatie;
    }

    public void setLocalitatiDestinatie(List<Ruta> ruteLocalitatiDestinatie) {
        this.ruteLocalitatiDestinatie = ruteLocalitatiDestinatie;
    }

    public List<LocalitateIntermediara> getLocalitatiIntermediare() {
        return localitatiIntermediare;
    }

    public void setLocalitatiIntermediare(List<LocalitateIntermediara> localitatiIntermediare) {
        this.localitatiIntermediare = localitatiIntermediare;
    }

    public List<Pret> getPreturi() {
        return preturi;
    }

    public void setPreturi(List<Pret> preturi) {
        this.preturi = preturi;
    }
}
