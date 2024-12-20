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

    @OneToMany(mappedBy = "localitateInceput")
    private List<Localitate> localitatiInceput;

    @OneToMany(mappedBy = "localitateDestinatie")
    private List<Localitate> localitatiDestinatie;

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

    public List<Localitate> getLocalitatiInceput() {
        return localitatiInceput;
    }

    public void setLocalitatiInceput(List<Localitate> localitatiInceput) {
        this.localitatiInceput = localitatiInceput;
    }

    public List<Localitate> getLocalitatiDestinatie() {
        return localitatiDestinatie;
    }

    public void setLocalitatiDestinatie(List<Localitate> localitatiDestinatie) {
        this.localitatiDestinatie = localitatiDestinatie;
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
