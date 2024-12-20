package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.LocalitateIntermediaraDTO;
import com.firma.transport_persoane.entity.LocalitateIntermediara;
import com.firma.transport_persoane.mapper.LocalitateIntermediaraMapper;
import com.firma.transport_persoane.service.LocalitateIntermediaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("firma/localitati-intermediare")
public class LocalitateIntermediaraController {

    private final LocalitateIntermediaraService service;
    private final LocalitateIntermediaraMapper mapper;

    @Autowired
    public LocalitateIntermediaraController(LocalitateIntermediaraService service,
                                            LocalitateIntermediaraMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<LocalitateIntermediaraDTO>> getAllLocalitatiIntermediare() {
        List<LocalitateIntermediara> localitati = service.getAllLocalitatiIntermediare();
        return ResponseEntity.ok(mapper.toDTOList(localitati));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalitateIntermediaraDTO> getLocalitateIntermediaraById(@PathVariable Integer id) {
        LocalitateIntermediara localitate = service.getLocalitateIntermediaraById(id);
        return ResponseEntity.ok(mapper.toDTO(localitate));
    }

    @PostMapping
    public ResponseEntity<LocalitateIntermediaraDTO> adaugaLocalitateIntermediara(@RequestBody LocalitateIntermediaraDTO dto) {
        LocalitateIntermediara localitate = service.adaugaLocalitateIntermediara(dto);
        return ResponseEntity.ok(mapper.toDTO(localitate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalitateIntermediaraDTO> actualizareLocalitateIntermediara(@PathVariable Integer id,
                                                                                       @RequestBody LocalitateIntermediaraDTO dto) {
        dto.setIdLocalitateIntermediara(id);
        LocalitateIntermediara localitate = service.actualizareLocalitateIntermediara(id, dto);
        return ResponseEntity.ok(mapper.toDTO(localitate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeLocalitateIntermediara(@PathVariable Integer id) {
        service.stergeLocalitateIntermediara(id);
        return ResponseEntity.noContent().build();
    }
}