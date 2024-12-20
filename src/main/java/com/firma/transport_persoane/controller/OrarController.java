package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.OrarDTO;
import com.firma.transport_persoane.entity.Orar;
import com.firma.transport_persoane.mapper.OrarMapper;
import com.firma.transport_persoane.service.OrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("firma/orare")
public class OrarController {

    private final OrarService orarService;
    private final OrarMapper orarMapper;

    @Autowired
    public OrarController(OrarService orarService, OrarMapper orarMapper) {
        this.orarService = orarService;
        this.orarMapper = orarMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrarDTO>> getAllOrare() {
        List<Orar> orare = orarService.getAllOrare();
        return ResponseEntity.ok(orarMapper.toDTOList(orare));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrarDTO> getOrarById(@PathVariable Integer id) {
        Orar orar = orarService.getOrarById(id);
        return ResponseEntity.ok(orarMapper.toDTO(orar));
    }

    @PostMapping
    public ResponseEntity<OrarDTO> adaugaOrar(@RequestBody OrarDTO orarDTO) {
        Orar orar = orarService.adaugaOrar(orarDTO);
        return ResponseEntity.ok(orarMapper.toDTO(orar));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrarDTO> actualizareOrar(@PathVariable Integer id, @RequestBody OrarDTO orarDTO) {
        orarDTO.setIdOrar(id);
        Orar orar = orarService.actualizareOrar(id, orarDTO);
        return ResponseEntity.ok(orarMapper.toDTO(orar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeOrar(@PathVariable Integer id) {
        orarService.stergeOrar(id);
        return ResponseEntity.noContent().build();
    }
}