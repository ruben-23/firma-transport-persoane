package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.OrarDTO;
import com.firma.transport_persoane.entity.Localitate;
import com.firma.transport_persoane.entity.Orar;
import com.firma.transport_persoane.entity.Ruta;
import com.firma.transport_persoane.service.LocalitateService;
import com.firma.transport_persoane.service.RutaService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrarMapper {

    private final LocalitateService localitateService;
    private final RutaService rutaService;

    public OrarMapper(LocalitateService localitateService, RutaService rutaService) {
        this.localitateService = localitateService;
        this.rutaService = rutaService;
    }

    public OrarDTO toDTO(Orar orar) {
        if (orar == null) {
            return null;
        }
        OrarDTO dto = new OrarDTO();
        dto.setIdOrar(orar.getIdOrar());
        dto.setOraPlecare(orar.getOraPlecare());
        dto.setZi(orar.getZi());
        dto.setIdLocalitatePlecare(orar.getLocalitatePlecare().getIdLocalitate());
        dto.setIdRuta(orar.getRuta().getIdRuta());
        return dto;
    }

    public List<OrarDTO> toDTOList(List<Orar> orare) {
        List<OrarDTO> orarDTOs = new ArrayList<>();
        for (Orar orar : orare) {
            orarDTOs.add(toDTO(orar));
        }
        return orarDTOs;
    }

    public Orar toEntity(OrarDTO orarDTO) {
        if (orarDTO == null) {
            return null;
        }
        Orar orar = new Orar();
        orar.setIdOrar(orarDTO.getIdOrar());
        orar.setOraPlecare(orarDTO.getOraPlecare());
        orar.setZi(orarDTO.getZi());
        return orar;
    }

    public void updateEntityFromDTO(OrarDTO orarDTO, Orar orar) {
        if (orarDTO != null && orar != null) {

            Localitate localitate = localitateService.getLocalitateById(orarDTO.getIdLocalitatePlecare());
            Ruta ruta  = rutaService.getRutaById(orarDTO.getIdRuta());

            orar.setOraPlecare(orarDTO.getOraPlecare());
            orar.setZi(orarDTO.getZi());
            orar.setRuta(ruta);
            orar.setLocalitatePlecare(localitate);
        }
    }
}