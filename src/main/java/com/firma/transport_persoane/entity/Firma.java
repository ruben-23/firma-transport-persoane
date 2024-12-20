package com.firma.transport_persoane.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="firma")
public class Firma {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idFirma;

    @Column(nullable=false)
    private String nume;

    @Column(nullable=false)
    private String adresa;

    @Column(nullable=false)
    private String numarTelefon;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "firma")
    private List<Feedback> feedbackuri;

    @OneToMany(mappedBy = "firma")
    private List<Autobuz> autobuze;

    public Integer getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(Integer idFirma) {
        this.idFirma = idFirma;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Feedback> getFeedbackuri() {
        return feedbackuri;
    }

    public void setFeedbackuri(List<Feedback> feedbackuri) {
        this.feedbackuri = feedbackuri;
    }

    public List<Autobuz> getAutobuze() {
        return autobuze;
    }

    public void setAutobuze(List<Autobuz> autobuze) {
        this.autobuze = autobuze;
    }
}
