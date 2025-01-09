package com.firma.transport_persoane.dto;


public class LocalitatePretRutaDTO {

    private Integer idLocalitate;
    private String localitate;
    private Double pret;
    private Integer ordine;

    public LocalitatePretRutaDTO( Integer idLocalitate, String localitate, Double pret, Integer ordine) {
        this.pret = pret;
        this.ordine = ordine;
        this.localitate = localitate;
        this.idLocalitate = idLocalitate;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public Integer getOrdine() {
        return ordine;
    }

    public void setOrdine(Integer ordine) {
        this.ordine = ordine;
    }

    public Integer getIdLocalitate() {
        return idLocalitate;
    }

    public void setIdLocalitate(Integer idLocalitate) {
        this.idLocalitate = idLocalitate;
    }
}
