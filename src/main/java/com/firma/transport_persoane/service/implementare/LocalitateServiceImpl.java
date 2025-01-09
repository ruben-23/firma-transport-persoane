package com.firma.transport_persoane.service.implementare;

import com.firma.transport_persoane.dto.LocalitateDTO;
import com.firma.transport_persoane.dto.LocalitatePretRutaDTO;
import com.firma.transport_persoane.entity.Localitate;
import com.firma.transport_persoane.mapper.LocalitateMapper;
import com.firma.transport_persoane.repository.LocalitateRepository;
import com.firma.transport_persoane.service.LocalitateService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalitateServiceImpl implements LocalitateService {

    private final LocalitateRepository localitateRepository;
    private final LocalitateMapper localitateMapper;

    @Autowired
    public LocalitateServiceImpl(LocalitateRepository localitateRepository, LocalitateMapper localitateMapper) {
        this.localitateRepository = localitateRepository;
        this.localitateMapper = localitateMapper;
    }

    @Override
    public List<Localitate> getAllLocalitati() {
        return localitateRepository.findAll();
    }

    @Override
    public Localitate getLocalitateById(Integer id) {
        return localitateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Localitate nu a fost gasita"));
    }

    @Transactional
    @Override
    public Localitate actualizareLocalitate(Integer id, LocalitateDTO localitateDTO) {
        Localitate localitateActuala = getLocalitateById(id);
        localitateMapper.updateEntityFromDTO(localitateDTO, localitateActuala);
        return localitateRepository.save(localitateActuala);
    }

    @Transactional
    @Override
    public Localitate adaugaLocalitate(LocalitateDTO localitateDTO) {
        Localitate localitate = localitateMapper.toEntity(localitateDTO);
        return localitateRepository.save(localitate);
    }

    @Override
    public void stergeLocalitate(Integer id) {
        localitateRepository.delete(getLocalitateById(id));
    }

    @Override
    public List<LocalitatePretRutaDTO> getLocalitatiSiPreturiRuta(Integer idRuta){
        return localitateRepository.findLocalitatiSiPretPentruRuta(idRuta);
    }


}