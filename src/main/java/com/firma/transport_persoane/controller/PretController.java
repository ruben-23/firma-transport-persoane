package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.PretDTO;
import com.firma.transport_persoane.entity.Pret;
import com.firma.transport_persoane.mapper.PretMapper;
import com.firma.transport_persoane.service.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("firma/preturi")
public class PretController {

    private final PretService pretService;
    private final PretMapper pretMapper;

    @Autowired
    public PretController(PretService pretService, PretMapper pretMapper) {
        this.pretService = pretService;
        this.pretMapper = pretMapper;
    }

    @GetMapping
    public ResponseEntity<List<PretDTO>> getAllPreturi() {
        List<Pret> preturi = pretService.getAllPreturi();
        return ResponseEntity.ok(pretMapper.toDTOList(preturi));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PretDTO> getPretById(@PathVariable Integer id) {
        Pret pret = pretService.getPretById(id);
        return ResponseEntity.ok(pretMapper.toDTO(pret));
    }

    @PostMapping
    public ResponseEntity<PretDTO> adaugaPret(@RequestBody PretDTO pretDTO) {
        Pret pret = pretService.adaugaPret(pretDTO);
        return ResponseEntity.ok(pretMapper.toDTO(pret));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PretDTO> actualizarePret(@PathVariable Integer id, @RequestBody PretDTO pretDTO) {
        pretDTO.setIdPret(id);
        Pret pret = pretService.actualizarePret(id, pretDTO);
        return ResponseEntity.ok(pretMapper.toDTO(pret));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergePret(@PathVariable Integer id) {
        pretService.stergePret(id);
        return ResponseEntity.noContent().build();
    }
}