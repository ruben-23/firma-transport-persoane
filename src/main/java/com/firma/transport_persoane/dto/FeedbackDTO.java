package com.firma.transport_persoane.dto;

import java.time.LocalDateTime;

public class FeedbackDTO {
    private Integer idFeedback;
    private String tip;
    private LocalDateTime timpTrimitere;
    private String mesaj;
    private Integer idFirma;

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

    public Integer getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(Integer idFirma) {
        this.idFirma = idFirma;
    }
}