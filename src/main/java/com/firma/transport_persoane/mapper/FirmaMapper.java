package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.FirmaDTO;
import com.firma.transport_persoane.entity.Firma;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FirmaMapper {

    public FirmaDTO toDTO(Firma firma) {
        if (firma == null) {
            return null;
        }
        FirmaDTO dto = new FirmaDTO();
        dto.setIdFirma(firma.getIdFirma());
        dto.setNume(firma.getNume());
        dto.setAdresa(firma.getAdresa());
        dto.setNumarTelefon(firma.getNumarTelefon());
        dto.setEmail(firma.getEmail());

        return dto;
    }

    public List<FirmaDTO> toDTOList(List<Firma> firme) {
        List<FirmaDTO> firmaDTOs = new ArrayList<>();
        for (Firma firma : firme) {
            firmaDTOs.add(toDTO(firma));
        }
        return firmaDTOs;
    }

    public Firma toEntity(FirmaDTO firmaDTO) {
        if (firmaDTO == null) {
            return null;
        }
        Firma firma = new Firma();
        firma.setIdFirma(firmaDTO.getIdFirma());
        firma.setNume(firmaDTO.getNume());
        firma.setAdresa(firmaDTO.getAdresa());
        firma.setNumarTelefon(firmaDTO.getNumarTelefon());
        firma.setEmail(firmaDTO.getEmail());
        return firma;
    }

    public void updateEntityFromDTO(FirmaDTO firmaDTO, Firma firma) {
        if (firmaDTO != null && firma != null) {
            firma.setNume(firmaDTO.getNume());
            firma.setAdresa(firmaDTO.getAdresa());
            firma.setNumarTelefon(firmaDTO.getNumarTelefon());
            firma.setEmail(firmaDTO.getEmail());
        }
    }
}