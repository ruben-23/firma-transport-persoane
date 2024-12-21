package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.LocalitateIntermediaraDTO;
import com.firma.transport_persoane.entity.LocalitateIntermediara;
import com.firma.transport_persoane.entity.LocalitateIntermediaraId;

import java.util.List;

public interface LocalitateIntermediaraService {
    List<LocalitateIntermediara> getAllLocalitatiIntermediare();
    LocalitateIntermediara getLocalitateIntermediaraById(LocalitateIntermediaraId id);
    LocalitateIntermediara adaugaLocalitateIntermediara(LocalitateIntermediaraDTO dto);
    LocalitateIntermediara actualizareLocalitateIntermediara(LocalitateIntermediaraDTO dto);
    void stergeLocalitateIntermediara(LocalitateIntermediaraId id);
}