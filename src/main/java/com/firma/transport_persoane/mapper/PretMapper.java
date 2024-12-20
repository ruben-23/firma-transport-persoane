package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.PretDTO;
import com.firma.transport_persoane.entity.Pret;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PretMapper {

    public PretDTO toDTO(Pret pret) {
        if (pret == null) {
            return null;
        }
        PretDTO dto = new PretDTO();
        dto.setIdPret(pret.getIdPret());
        dto.setPret(pret.getPret());
        dto.setIdLocalitate(pret.getLocalitate().getIdLocalitate());
        dto.setIdRuta(pret.getRuta().getIdRuta());
        return dto;
    }

    public List<PretDTO> toDTOList(List<Pret> preturi) {
        List<PretDTO> pretDTOs = new ArrayList<>();
        for (Pret pret : preturi) {
            pretDTOs.add(toDTO(pret));
        }
        return pretDTOs;
    }

    public Pret toEntity(PretDTO pretDTO) {
        if (pretDTO == null) {
            return null;
        }
        Pret pret = new Pret();
        pret.setIdPret(pretDTO.getIdPret());
        pret.setPret(pretDTO.getPret());
        return pret;
    }

    public void updateEntityFromDTO(PretDTO pretDTO, Pret pret) {
        if (pretDTO != null && pret != null) {
            pret.setPret(pretDTO.getPret());
        }
    }
}