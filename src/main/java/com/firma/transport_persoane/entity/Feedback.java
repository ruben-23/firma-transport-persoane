package com.firma.transport_persoane.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="feedbackuri")
public class Feedback {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idFeedback;

    @Column(nullable=false)
    private String tip;

    @Column(nullable=false)
    private LocalDateTime timpTrimitere;

    @Lob
    @Column(nullable=false)
    private String mesaj;

    @ManyToOne
    @JoinColumn(name = "id_firma")
    private Firma firma;

    public Integer getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public LocalDateTime getTimpTrimitere() {
        return timpTrimitere;
    }

    public void setTimpTrimitere(LocalDateTime timpTrimitere) {
        this.timpTrimitere = timpTrimitere;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}
