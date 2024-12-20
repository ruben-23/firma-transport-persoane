package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.RutaDTO;
import com.firma.transport_persoane.entity.Localitate;
import com.firma.transport_persoane.entity.Ruta;
import com.firma.transport_persoane.service.LocalitateService;
import com.firma.transport_persoane.service.RutaService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RutaMapper {

    private final LocalitateService localitateService;

    public RutaMapper( LocalitateService localitateService) {
        this.localitateService = localitateService;
    }

    public RutaDTO toDTO(Ruta ruta) {
        if (ruta == null) {
            return null;
        }

        RutaDTO dto = new RutaDTO();
        dto.setIdRuta(ruta.getIdRuta());
        dto.setIdLocalitateInceput(ruta.getLocalitateInceput().getIdLocalitate());
        dto.setIdLocalitateDestinatie(ruta.getLocalitateDestinatie().getIdLocalitate());
        return dto;
    }

    public List<RutaDTO> toDTOList(List<Ruta> rute) {
        List<RutaDTO> rutaDTOs = new ArrayList<>();
        for (Ruta ruta : rute) {
            rutaDTOs.add(toDTO(ruta));
        }
        return rutaDTOs;
    }

    public Ruta toEntity(RutaDTO rutaDTO) {
        if (rutaDTO == null) {
            return null;
        }
        Ruta ruta = new Ruta();
        ruta.setIdRuta(rutaDTO.getIdRuta());
        return ruta;
    }

    public void updateEntityFromDTO(RutaDTO rutaDTO, Ruta ruta) {
        if (rutaDTO != null && ruta != null) {

        Localitate localitateInceput = localitateService.getLocalitateById(ruta.getLocalitateInceput().getIdLocalitate());
        Localitate localitateDestinatie = localitateService.getLocalitateById(ruta.getLocalitateDestinatie().getIdLocalitate());

        ruta.setLocalitateInceput(localitateInceput);
        ruta.setLocalitateDestinatie(localitateDestinatie);
        }
    }
}