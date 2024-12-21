package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.AutobuzDTO;
import com.firma.transport_persoane.entity.Autobuz;
import com.firma.transport_persoane.entity.Firma;
import com.firma.transport_persoane.entity.Ruta;
import com.firma.transport_persoane.service.FirmaService;
import com.firma.transport_persoane.service.RutaService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutobuzMapper {

    private final FirmaService firmaService;
    private final RutaService rutaService;

    public AutobuzMapper(FirmaService firmaService, RutaService rutaService) {
        this.firmaService = firmaService;
        this.rutaService = rutaService;
    }

    public AutobuzDTO toDTO(Autobuz autobuz) {
        if (autobuz == null) {
            return null;
        }

        AutobuzDTO dto = new AutobuzDTO();
        dto.setIdAutobuz(autobuz.getIdAutobuz());
        dto.setNumarInmatriculare(autobuz.getNumarInmatriculare());
        dto.setStatus(autobuz.getStatus());
        dto.setCapacitate(autobuz.getCapacitate());

        dto.setIdRuta(autobuz.getRuta() != null ?
                        autobuz.getRuta().getIdRuta() : null);

        dto.setIdFirma(autobuz.getFirma() != null ?
                        autobuz.getFirma().getIdFirma() : null);

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

        Firma firma = firmaService.getFirmaById(autobuzDTO.getIdFirma());
        Ruta ruta = rutaService.getRutaById(autobuzDTO.getIdRuta());

        Autobuz autobuz = new Autobuz();
        autobuz.setIdAutobuz(autobuzDTO.getIdAutobuz());
        autobuz.setNumarInmatriculare(autobuzDTO.getNumarInmatriculare());
        autobuz.setStatus(autobuzDTO.getStatus());
        autobuz.setCapacitate(autobuzDTO.getCapacitate());
        autobuz.setFirma(firma);
        autobuz.setRuta(ruta);

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