package com.firma.transport_persoane.service.implementare;

import com.firma.transport_persoane.dto.BiletDTO;
import com.firma.transport_persoane.entity.Bilet;
import com.firma.transport_persoane.mapper.BiletMapper;
import com.firma.transport_persoane.repository.BiletRepository;
import com.firma.transport_persoane.service.BiletService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiletServiceImplementare implements BiletService {

    private final BiletRepository biletRepository;
    private final BiletMapper biletMapper;

    @Autowired
    public BiletServiceImplementare(BiletRepository biletRepository, BiletMapper biletMapper) {
        this.biletRepository = biletRepository;
        this.biletMapper = biletMapper;
    }

    @Override
    public List<Bilet> getAllBilete() {
        return biletRepository.findAll();
    }

    @Override
    public Bilet getBiletById(Integer id) {
        return biletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bilet nu a fost gasit"));
    }

    @Transactional
    @Override
    public Bilet adaugaBilet(BiletDTO biletDTO) {
        Bilet bilet = biletMapper.toEntity(biletDTO);
        return biletRepository.save(bilet);
    }

    @Transactional
    @Override
    public Bilet actualizareBilet(Integer id, BiletDTO biletDTO) {
        Bilet biletActual = getBiletById(id);
        biletMapper.updateEntityFromDTO(biletDTO, biletActual);
        return biletRepository.save(biletActual);
    }

    @Override
    public void stergeBilet(Integer id) {
        biletRepository.delete(getBiletById(id));
    }
}