package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.LocalitateDTO;
import com.firma.transport_persoane.entity.Localitate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class LocalitateMapper {

    public LocalitateDTO toDTO(Localitate localitate) {
        if (localitate == null) {
            return null;
        }
        LocalitateDTO dto = new LocalitateDTO();
        dto.setIdLocalitate(localitate.getIdLocalitate());
        dto.setNume(localitate.getNume());
        return dto;
    }

    public List<LocalitateDTO> toDTOList(List<Localitate> localitati) {
        List<LocalitateDTO> loclitateDTOs = new ArrayList<>();

        for(Localitate localitate : localitati) {
            loclitateDTOs.add(toDTO(localitate));
        }

        return loclitateDTOs;
    }

    public Localitate toEntity(LocalitateDTO localitateDTO) {
        if (localitateDTO == null) {
            return null;
        }
        Localitate localitate = new Localitate();
        localitate.setIdLocalitate(localitateDTO.getIdLocalitate());
        localitate.setNume(localitateDTO.getNume());
        return localitate;
    }

    public void updateEntityFromDTO(LocalitateDTO localitateDTO, Localitate localitate) {
        if (localitateDTO != null && localitate != null) {
            localitate.setNume(localitateDTO.getNume());
        }
    }
}