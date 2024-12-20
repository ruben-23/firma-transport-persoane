package com.firma.transport_persoane.service.implementare;

import com.firma.transport_persoane.dto.OrarDTO;
import com.firma.transport_persoane.entity.Orar;
import com.firma.transport_persoane.mapper.OrarMapper;
import com.firma.transport_persoane.repository.OrarRepository;
import com.firma.transport_persoane.service.OrarService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrarServiceImplementare implements OrarService {

    private final OrarRepository orarRepository;
    private final OrarMapper orarMapper;

    @Autowired
    public OrarServiceImplementare(OrarRepository orarRepository, OrarMapper orarMapper) {
        this.orarRepository = orarRepository;
        this.orarMapper = orarMapper;
    }

    @Override
    public List<Orar> getAllOrare() {
        return orarRepository.findAll();
    }

    @Override
    public Orar getOrarById(Integer id) {
        return orarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orar nu a fost gasit"));
    }

    @Transactional
    @Override
    public Orar adaugaOrar(OrarDTO orarDTO) {
        Orar orar = orarMapper.toEntity(orarDTO);
        return orarRepository.save(orar);
    }

    @Transactional
    @Override
    public Orar actualizareOrar(Integer id, OrarDTO orarDTO) {
        Orar orarActual = getOrarById(id);
        orarMapper.updateEntityFromDTO(orarDTO, orarActual);
        return orarRepository.save(orarActual);
    }

    @Override
    public void stergeOrar(Integer id) {
        orarRepository.delete(getOrarById(id));
    }
}