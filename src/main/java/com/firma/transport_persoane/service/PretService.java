package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.PretDTO;
import com.firma.transport_persoane.entity.Pret;

import java.util.List;

public interface PretService {
    List<Pret> getAllPreturi();
    Pret getPretById(Integer id);
    Pret adaugaPret(PretDTO pretDTO);
    Pret actualizarePret(Integer id, PretDTO pretDTO);
    void stergePret(Integer id);
}