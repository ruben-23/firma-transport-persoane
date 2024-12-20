package com.firma.transport_persoane.service.implementare;

import com.firma.transport_persoane.dto.RutaDTO;
import com.firma.transport_persoane.entity.Ruta;
import com.firma.transport_persoane.mapper.RutaMapper;
import com.firma.transport_persoane.repository.RutaRepository;
import com.firma.transport_persoane.service.RutaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaServiceImplementare implements RutaService {

    private final RutaRepository rutaRepository;
    private final RutaMapper rutaMapper;

    @Autowired
    public RutaServiceImplementare(RutaRepository rutaRepository, RutaMapper rutaMapper) {
        this.rutaRepository = rutaRepository;
        this.rutaMapper = rutaMapper;
    }

    @Override
    public List<Ruta> getAllRute() {
        return rutaRepository.findAll();
    }

    @Override
    public Ruta getRutaById(Integer id) {
        return rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta nu a fost gasita"));
    }

    @Transactional
    @Override
    public Ruta adaugaRuta(RutaDTO rutaDTO) {
        Ruta ruta = rutaMapper.toEntity(rutaDTO);
        return rutaRepository.save(ruta);
    }

    @Transactional
    @Override
    public Ruta actualizareRuta(Integer id, RutaDTO rutaDTO) {
        Ruta rutaActuala = getRutaById(id);
        rutaMapper.updateEntityFromDTO(rutaDTO, rutaActuala);
        return rutaRepository.save(rutaActuala);
    }

    @Override
    public void stergeRuta(Integer id) {
        rutaRepository.delete(getRutaById(id));
    }
}