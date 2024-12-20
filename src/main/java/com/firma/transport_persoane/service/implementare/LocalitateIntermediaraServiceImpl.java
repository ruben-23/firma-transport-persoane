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

    private final LocalitateIntermediaraRepository localitateIntermediaraRepository;
    private final LocalitateIntermediaraMapper localitateIntermediaraMapper;

    @Autowired
    public LocalitateIntermediaraServiceImpl(LocalitateIntermediaraRepository localitateIntermediaraRepository, LocalitateIntermediaraMapper localitateIntermediaraMapper) {
        this.localitateIntermediaraRepository = localitateIntermediaraRepository;
        this.localitateIntermediaraMapper = localitateIntermediaraMapper;
    }

    @Override
    public List<LocalitateIntermediara> getAllLocalitatiIntermediare() {
        return localitateIntermediaraRepository.findAll();
    }

    @Override
    public LocalitateIntermediara getLocalitateIntermediaraById(Integer id) {
        return localitateIntermediaraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Localitate Intermediara nu a fost gasita"));
    }

    @Transactional
    @Override
    public LocalitateIntermediara adaugaLocalitateIntermediara(LocalitateIntermediaraDTO localitateIntermediaraDTO) {
        LocalitateIntermediara localitateIntermediara = localitateIntermediaraMapper.toEntity(localitateIntermediaraDTO);
        return localitateIntermediaraRepository.save(localitateIntermediara);
    }

    @Transactional
    @Override
    public LocalitateIntermediara actualizareLocalitateIntermediara(Integer id, LocalitateIntermediaraDTO localitateIntermediaraDTO) {
        LocalitateIntermediara localitateIntermediaraActuala = getLocalitateIntermediaraById(id);
        localitateIntermediaraMapper.updateEntityFromDTO(localitateIntermediaraDTO, localitateIntermediaraActuala);
        return localitateIntermediaraRepository.save(localitateIntermediaraActuala);
    }

    @Override
    public void stergeLocalitateIntermediara(Integer id) {
        localitateIntermediaraRepository.delete(getLocalitateIntermediaraById(id));
    }
}