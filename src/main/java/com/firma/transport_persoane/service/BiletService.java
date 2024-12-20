package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.BiletDTO;
import com.firma.transport_persoane.entity.Bilet;

import java.util.List;

public interface BiletService {
    List<Bilet> getAllBilete();
    Bilet getBiletById(Integer id);
    Bilet adaugaBilet(BiletDTO biletDTO);
    Bilet actualizareBilet(Integer id, BiletDTO biletDTO);
    void stergeBilet(Integer id);
}