package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.LocalitateIntermediaraDTO;
import com.firma.transport_persoane.entity.LocalitateIntermediara;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocalitateIntermediaraMapper {

    public LocalitateIntermediaraDTO toDTO(LocalitateIntermediara localitateIntermediara) {
        if (localitateIntermediara == null) {
            return null;
        }
        LocalitateIntermediaraDTO dto = new LocalitateIntermediaraDTO();
        dto.setIdLocalitateIntermediara(localitateIntermediara.getIdLocalitateIntermediara());
        dto.setIdRuta(localitateIntermediara.getRuta().getIdRuta());
        dto.setIdLocalitate(localitateIntermediara.getLocalitate().getIdLocalitate());
        dto.setOrdine(localitateIntermediara.getOrdine());
        return dto;
    }

    public List<LocalitateIntermediaraDTO> toDTOList(List<LocalitateIntermediara> localitatiIntermediare) {
        List<LocalitateIntermediaraDTO> localitateIntermediaraDTOs = new ArrayList<>();
        for (LocalitateIntermediara localitateIntermediara : localitatiIntermediare) {
            localitateIntermediaraDTOs.add(toDTO(localitateIntermediara));
        }
        return localitateIntermediaraDTOs;
    }

    public LocalitateIntermediara toEntity(LocalitateIntermediaraDTO localitateIntermediaraDTO) {
        if (localitateIntermediaraDTO == null) {
            return null;
        }
        LocalitateIntermediara localitateIntermediara = new LocalitateIntermediara();
        localitateIntermediara.setIdLocalitateIntermediara(localitateIntermediaraDTO.getIdLocalitateIntermediara());
        localitateIntermediara.setOrdine(localitateIntermediaraDTO.getOrdine());
        return localitateIntermediara;
    }

    public void updateEntityFromDTO(LocalitateIntermediaraDTO localitateIntermediaraDTO, LocalitateIntermediara localitateIntermediara) {
        if (localitateIntermediaraDTO != null && localitateIntermediara != null) {
            localitateIntermediara.setOrdine(localitateIntermediaraDTO.getOrdine());
        }
    }
}