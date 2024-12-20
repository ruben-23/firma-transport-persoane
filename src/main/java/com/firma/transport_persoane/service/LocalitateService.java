package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.LocalitateDTO;
import com.firma.transport_persoane.entity.Localitate;
import com.firma.transport_persoane.entity.LocalitateIntermediara;
import com.firma.transport_persoane.entity.Pret;

import java.util.List;

public interface LocalitateService {
    List<Localitate> getAllLocalitati();
    Localitate getLocalitateById(Integer id);
    Localitate adaugaLocalitate(LocalitateDTO localitateDTO);
    Localitate actualizareLocalitate(Integer id, LocalitateDTO localitateDTO);
    void stergeLocalitate(Integer id);
}