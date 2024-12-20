package com.firma.transport_persoane.service.implementare;

import com.firma.transport_persoane.dto.LocalitateIntermediaraDTO;
import com.firma.transport_persoane.entity.LocalitateIntermediara;
import com.firma.transport_persoane.mapper.LocalitateIntermediaraMapper;
import com.firma.transport_persoane.repository.LocalitateIntermediaraRepository;
import com.firma.transport_persoane.service.LocalitateIntermediaraService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalitateIntermediaraServiceImpl implements LocalitateIntermediaraService {

    private final LocalitateIntermediaraRepository repository;
    private final LocalitateIntermediaraMapper mapper;

    @Autowired
    public LocalitateIntermediaraServiceImpl(LocalitateIntermediaraRepository repository,
                                             LocalitateIntermediaraMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<LocalitateIntermediara> getAllLocalitatiIntermediare() {
        return repository.findAll();
    }

    @Override
    public LocalitateIntermediara getLocalitateIntermediaraById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Localitate Intermediara nu a fost gasita"));
    }

    @Transactional
    @Override
    public LocalitateIntermediara adaugaLocalitateIntermediara(LocalitateIntermediaraDTO dto) {
        LocalitateIntermediara localitate = mapper.toEntity(dto);
        return repository.save(localitate);
    }

    @Transactional
    @Override
    public LocalitateIntermediara actualizareLocalitateIntermediara(Integer id, LocalitateIntermediaraDTO dto) {
        LocalitateIntermediara localitateActuala = getLocalitateIntermediaraById(id);
        mapper.updateEntityFromDTO(dto, localitateActuala);
        return repository.save(localitateActuala);
    }

    @Override
    public void stergeLocalitateIntermediara(Integer id) {
        repository.delete(getLocalitateIntermediaraById(id));
    }
}