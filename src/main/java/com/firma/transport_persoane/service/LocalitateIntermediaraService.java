package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.LocalitateIntermediaraDTO;
import com.firma.transport_persoane.entity.LocalitateIntermediara;

import java.util.List;

public interface LocalitateIntermediaraService {
    List<LocalitateIntermediara> getAllLocalitatiIntermediare();
    LocalitateIntermediara getLocalitateIntermediaraById(Integer id);
    LocalitateIntermediara adaugaLocalitateIntermediara(LocalitateIntermediaraDTO dto);
    LocalitateIntermediara actualizareLocalitateIntermediara(Integer id, LocalitateIntermediaraDTO dto);
    void stergeLocalitateIntermediara(Integer id);
}