package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.AutobuzDTO;
import com.firma.transport_persoane.entity.Autobuz;

import java.util.List;

public interface AutobuzService {
    List<Autobuz> getAllAutobuze();
    Autobuz getAutobuzById(Integer id);
    Autobuz actualizareAutobuz(AutobuzDTO autobuzDTO);
    Autobuz adaugaAutobuz(AutobuzDTO autobuzDTO);
    void stergeAutobuz(Integer id);
}
