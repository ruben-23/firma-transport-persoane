package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.FirmaDTO;
import com.firma.transport_persoane.entity.Firma;

import java.util.List;

public interface FirmaService {
    List<Firma> getAllFirme();
    Firma getFirmaById(Integer id);
    Firma adaugaFirma(FirmaDTO firmaDTO);
    Firma actualizareFirma(Integer id, FirmaDTO firmaDTO);
    void stergeFirma(Integer id);
}