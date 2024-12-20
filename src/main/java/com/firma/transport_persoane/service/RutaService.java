package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.RutaDTO;
import com.firma.transport_persoane.entity.Ruta;

import java.util.List;

public interface RutaService {
    List<Ruta> getAllRute();
    Ruta getRutaById(Integer id);
    Ruta adaugaRuta(RutaDTO rutaDTO);
    Ruta actualizareRuta(Integer id, RutaDTO rutaDTO);
    void stergeRuta(Integer id);
}