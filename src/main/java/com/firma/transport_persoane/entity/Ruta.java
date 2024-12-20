package com.firma.transport_persoane.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="rute")
public class Ruta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idRuta;

    @ManyToOne
    @JoinColumn(name = "id_localitate_inceput")
    private Localitate localitateInceput;

    @ManyToOne
    @JoinColumn(name = "id_localitate_destinatie")
    private Localitate localitateDestinatie;

    @OneToMany(mappedBy = "ruta")
    private List<LocalitateIntermediara> localitatiIntermediare;

    @OneToMany(mappedBy = "ruta")
    private List<Autobuz> autobuze;

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Localitate getLocalitateInceput() {
        return localitateInceput;
    }

    public void setLocalitateInceput(Localitate localitateInceput) {
        this.localitateInceput = localitateInceput;
    }

    public Localitate getLocalitateDestinatie() {
        return localitateDestinatie;
    }

    public void setLocalitateDestinatie(Localitate localitateDestinatie) {
        this.localitateDestinatie = localitateDestinatie;
    }

    public List<LocalitateIntermediara> getLocalitatiIntermediare() {
        return localitatiIntermediare;
    }

    public void setLocalitatiIntermediare(List<LocalitateIntermediara> localitatiIntermediare) {
        this.localitatiIntermediare = localitatiIntermediare;
    }

    public List<Autobuz> getAutobuze() {
        return autobuze;
    }

    public void setAutobuze(List<Autobuz> autobuze) {
        this.autobuze = autobuze;
    }
}

