package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.OrarDTO;
import com.firma.transport_persoane.entity.Orar;

import java.util.List;

public interface OrarService {
    List<Orar> getAllOrare();
    Orar getOrarById(Integer id);
    Orar adaugaOrar(OrarDTO orarDTO);
    Orar actualizareOrar(Integer id, OrarDTO orarDTO);
    void stergeOrar(Integer id);
}