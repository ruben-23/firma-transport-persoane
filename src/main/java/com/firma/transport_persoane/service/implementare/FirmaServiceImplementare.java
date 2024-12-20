package com.firma.transport_persoane.service.implementare;

import com.firma.transport_persoane.dto.FirmaDTO;
import com.firma.transport_persoane.entity.Firma;
import com.firma.transport_persoane.mapper.FirmaMapper;
import com.firma.transport_persoane.repository.FirmaRepository;
import com.firma.transport_persoane.service.FirmaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmaServiceImplementare implements FirmaService {

    private final FirmaRepository firmaRepository;
    private final FirmaMapper firmaMapper;

    @Autowired
    public FirmaServiceImplementare(FirmaRepository firmaRepository, FirmaMapper firmaMapper) {
        this.firmaRepository = firmaRepository;
        this.firmaMapper = firmaMapper;
    }

    @Override
    public List<Firma> getAllFirme() {
        return firmaRepository.findAll();
    }

    @Override
    public Firma getFirmaById(Integer id) {
        return firmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Firma nu a fost gasita"));
    }

    @Transactional
    @Override
    public Firma adaugaFirma(FirmaDTO firmaDTO) {
        Firma firma = firmaMapper.toEntity(firmaDTO);
        return firmaRepository.save(firma);
    }

    @Transactional
    @Override
    public Firma actualizareFirma(Integer id, FirmaDTO firmaDTO) {
        Firma firmaActuala = getFirmaById(id);
        firmaMapper.updateEntityFromDTO(firmaDTO, firmaActuala);
        return firmaRepository.save(firmaActuala);
    }

    @Override
    public void stergeFirma(Integer id) {
        firmaRepository.delete(getFirmaById(id));
    }
}