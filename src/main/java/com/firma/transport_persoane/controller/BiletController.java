package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.BiletDTO;
import com.firma.transport_persoane.entity.Bilet;
import com.firma.transport_persoane.mapper.BiletMapper;
import com.firma.transport_persoane.service.BiletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("firma/bilete")
public class BiletController {

    private final BiletService biletService;
    private final BiletMapper biletMapper;

    @Autowired
    public BiletController(BiletService biletService, BiletMapper biletMapper) {
        this.biletService = biletService;
        this.biletMapper = biletMapper;
    }

    @GetMapping
    public ResponseEntity<List<BiletDTO>> getAllBilete() {
        List<Bilet> bilete = biletService.getAllBilete();
        return ResponseEntity.ok(biletMapper.toDTOList(bilete));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BiletDTO> getBiletById(@PathVariable Integer id) {
        Bilet bilet = biletService.getBiletById(id);
        return ResponseEntity.ok(biletMapper.toDTO(bilet));
    }

    @PostMapping
    public ResponseEntity<BiletDTO> adaugaBilet(@RequestBody BiletDTO biletDTO) {
        Bilet bilet = biletService.adaugaBilet(biletDTO);
        return ResponseEntity.ok(biletMapper.toDTO(bilet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BiletDTO> actualizareBilet(@PathVariable Integer id, @RequestBody BiletDTO biletDTO) {
        biletDTO.setIdBilet(id);
        Bilet bilet = biletService.actualizareBilet(id, biletDTO);
        return ResponseEntity.ok(biletMapper.toDTO(bilet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeBilet(@PathVariable Integer id) {
        biletService.stergeBilet(id);
        return ResponseEntity.noContent().build();
    }
}