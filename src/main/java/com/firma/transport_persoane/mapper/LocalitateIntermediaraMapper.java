package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.LocalitateIntermediaraDTO;
import com.firma.transport_persoane.entity.LocalitateIntermediara;
import com.firma.transport_persoane.entity.LocalitateIntermediaraId;
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

    public LocalitateIntermediara toEntity(LocalitateIntermediaraDTO dto) {
        if (dto == null) {
            return null;
        }

        LocalitateIntermediaraId id = new LocalitateIntermediaraId(dto.getIdLocalitate(), dto.getIdRuta());

        LocalitateIntermediara localitateIntermediara = new LocalitateIntermediara();
        localitateIntermediara.setIdLocalitateIntermediara(id);
        localitateIntermediara.setOrdine(dto.getOrdine());
        return localitateIntermediara;
    }

    public void updateEntityFromDTO(LocalitateIntermediaraDTO dto,
                                    LocalitateIntermediara localitateIntermediara) {
        if (dto != null && localitateIntermediara != null) {
            localitateIntermediara.setOrdine(dto.getOrdine());
        }
    }
}