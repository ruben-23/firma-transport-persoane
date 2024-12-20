package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.LocalitateDTO;
import com.firma.transport_persoane.entity.Localitate;
import com.firma.transport_persoane.mapper.LocalitateMapper;
import com.firma.transport_persoane.service.LocalitateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("localitati")
public class LocalitateController {

    private final LocalitateService localitateService;
    private final LocalitateMapper localitateMapper;

    @Autowired
    public LocalitateController(LocalitateService localitateService, LocalitateMapper localitateMapper) {
        this.localitateService = localitateService;
        this.localitateMapper = localitateMapper;
    }

    @GetMapping
    public ResponseEntity<List<LocalitateDTO>> getAllLocalitati() {
        List<Localitate> localitati = localitateService.getAllLocalitati();
        return ResponseEntity.ok(localitateMapper.toDTOList(localitati));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalitateDTO> getLocalitateById(@PathVariable Integer id) {
        Localitate localitate = localitateService.getLocalitateById(id);
        return ResponseEntity.ok(localitateMapper.toDTO(localitate));
    }

    @PostMapping
    public ResponseEntity<LocalitateDTO> adaugaLocalitate(@RequestBody LocalitateDTO localitateDTO) {
        Localitate localitate = localitateService.adaugaLocalitate(localitateDTO);
        return ResponseEntity.ok(localitateMapper.toDTO(localitate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalitateDTO> actualizareLocalitate(@PathVariable Integer id, @RequestBody LocalitateDTO localitateDTO) {
        localitateDTO.setIdLocalitate(id);
        Localitate localitate = localitateService.actualizareLocalitate(id, localitateDTO);
        return ResponseEntity.ok(localitateMapper.toDTO(localitate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeLocalitate(@PathVariable Integer id) {
        localitateService.stergeLocalitate(id);
        return ResponseEntity.noContent().build();
    }
}