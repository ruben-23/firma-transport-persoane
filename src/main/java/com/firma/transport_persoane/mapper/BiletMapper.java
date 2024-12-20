package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.BiletDTO;
import com.firma.transport_persoane.entity.Bilet;
import com.firma.transport_persoane.entity.Orar;
import com.firma.transport_persoane.entity.Pret;
import com.firma.transport_persoane.service.OrarService;
import com.firma.transport_persoane.service.PretService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BiletMapper {

    private final PretService pretService;
    private final OrarService orarService;

    public BiletMapper(PretService pretService, OrarService orarService) {
        this.pretService = pretService;
        this.orarService = orarService;
    }

    public BiletDTO toDTO(Bilet bilet) {
        if (bilet == null) {
            return null;
        }
        BiletDTO dto = new BiletDTO();
        dto.setIdBilet(bilet.getIdBilet());
        dto.setTimpCumparare(bilet.getTimpCumparare());
        dto.setIdPret(bilet.getPret().getIdPret());
        dto.setIdOrar(bilet.getOrar().getIdOrar());
        return dto;
    }

    public List<BiletDTO> toDTOList(List<Bilet> bilete) {
        List<BiletDTO> biletDTOs = new ArrayList<>();
        for (Bilet bilet : bilete) {
            biletDTOs.add(toDTO(bilet));
        }
        return biletDTOs;
    }

    public Bilet toEntity(BiletDTO biletDTO) {
        if (biletDTO == null) {
            return null;
        }
        Bilet bilet = new Bilet();
        bilet.setIdBilet(biletDTO.getIdBilet());
        bilet.setTimpCumparare(biletDTO.getTimpCumparare());
        return bilet;
    }

    public void updateEntityFromDTO(BiletDTO biletDTO, Bilet bilet) {
        if (biletDTO != null && bilet != null) {

            Pret pret = pretService.getPretById(biletDTO.getIdPret());
            Orar orar = orarService.getOrarById(biletDTO.getIdOrar());

            bilet.setTimpCumparare(biletDTO.getTimpCumparare());
            bilet.setPret(pret);
            bilet.setOrar(orar);
        }
    }
}