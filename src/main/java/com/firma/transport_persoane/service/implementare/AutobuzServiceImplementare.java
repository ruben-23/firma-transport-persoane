package com.firma.transport_persoane.service.implementare;

import com.firma.transport_persoane.dto.AutobuzDTO;
import com.firma.transport_persoane.entity.Autobuz;
import com.firma.transport_persoane.mapper.AutobuzMapper;
import com.firma.transport_persoane.repository.AutobuzRepository;
import com.firma.transport_persoane.service.AutobuzService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutobuzServiceImplementare implements AutobuzService {

    private final AutobuzRepository autobuzRepository;
    private final AutobuzMapper autobuzMapper;

    @Autowired
    public AutobuzServiceImplementare(AutobuzRepository autobuzRepository, AutobuzMapper autobuzMapper) {
        this.autobuzRepository = autobuzRepository;
        this.autobuzMapper = autobuzMapper;
    }

    @Override
    public List<Autobuz> getAllAutobuze() {
        return autobuzRepository.findAll();
    }

    @Override
    public Autobuz getAutobuzById(Integer id) {
        return autobuzRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autobuz nu a fost gasit"));
    }

    @Transactional
    @Override
    public Autobuz actualizareAutobuz(AutobuzDTO autobuzDTO) {
        Autobuz autobuzActual = getAutobuzById(autobuzDTO.getIdAutobuz());
        autobuzMapper.updateEntityFromDTO(autobuzDTO, autobuzActual);
        return autobuzRepository.save(autobuzActual);
    }

    @Transactional
    @Override
    public Autobuz adaugaAutobuz(AutobuzDTO autobuzDTO) {
        Autobuz autobuz = autobuzMapper.toEntity(autobuzDTO);
        return autobuzRepository.save(autobuz);
    }

    @Override
    public void stergeAutobuz(Integer id) {
        autobuzRepository.delete(getAutobuzById(id));
    }
}