package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.AutobuzDTO;
import com.firma.transport_persoane.entity.Autobuz;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutobuzMapper {

    public AutobuzDTO toDTO(Autobuz autobuz) {
        if (autobuz == null) {
            return null;
        }

        AutobuzDTO dto = new AutobuzDTO();
        dto.setIdAutobuz(autobuz.getIdAutobuz());
        dto.setNumarInmatriculare(autobuz.getNumarInmatriculare());
        dto.setStatus(autobuz.getStatus());
        dto.setCapacitate(autobuz.getCapacitate());
        dto.setIdRuta(autobuz.getRuta().getIdRuta());
        dto.setIdFirma(autobuz.getFirma().getIdFirma());

        return dto;
    }

    public List<AutobuzDTO> toDTOList(List<Autobuz> autobuze) {
        List<AutobuzDTO> autobuzDTOs = new ArrayList<>();
        for (Autobuz autobuz : autobuze) {
            autobuzDTOs.add(toDTO(autobuz));
        }
        return autobuzDTOs;
    }

    public Autobuz toEntity(AutobuzDTO autobuzDTO) {
        if (autobuzDTO == null) {
            return null;
        }
        Autobuz autobuz = new Autobuz();
        autobuz.setIdAutobuz(autobuzDTO.getIdAutobuz());
        autobuz.setNumarInmatriculare(autobuzDTO.getNumarInmatriculare());
        autobuz.setStatus(autobuzDTO.getStatus());
        autobuz.setCapacitate(autobuzDTO.getCapacitate());
        return autobuz;
    }

    public void updateEntityFromDTO(AutobuzDTO autobuzDTO, Autobuz autobuz) {
        if (autobuzDTO != null && autobuz != null) {
            autobuz.setNumarInmatriculare(autobuzDTO.getNumarInmatriculare());
            autobuz.setStatus(autobuzDTO.getStatus());
            autobuz.setCapacitate(autobuzDTO.getCapacitate());

        }
    }
}