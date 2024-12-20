package com.firma.transport_persoane.service.implementare;

import com.firma.transport_persoane.dto.PretDTO;
import com.firma.transport_persoane.entity.Pret;
import com.firma.transport_persoane.mapper.PretMapper;
import com.firma.transport_persoane.repository.PretRepository;
import com.firma.transport_persoane.service.PretService;
import jakarta.transaction.Transactional;
import org.springframework .beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PretServiceImplementare implements PretService {

    private final PretRepository pretRepository;
    private final PretMapper pretMapper;

    @Autowired
    public PretServiceImplementare(PretRepository pretRepository, PretMapper pretMapper) {
        this.pretRepository = pretRepository;
        this.pretMapper = pretMapper;
    }

    @Override
    public List<Pret> getAllPreturi() {
        return pretRepository.findAll();
    }

    @Override
    public Pret getPretById(Integer id) {
        return pretRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pret nu a fost gasit"));
    }

    @Transactional
    @Override
    public Pret adaugaPret(PretDTO pretDTO) {
        Pret pret = pretMapper.toEntity(pretDTO);
        return pretRepository.save(pret);
    }

    @Transactional
    @Override
    public Pret actualizarePret(Integer id, PretDTO pretDTO) {
        Pret pretActual = getPretById(id);
        pretMapper.updateEntityFromDTO(pretDTO, pretActual);
        return pretRepository.save(pretActual);
    }

    @Override
    public void stergePret(Integer id) {
        pretRepository.delete(getPretById(id));
    }
}