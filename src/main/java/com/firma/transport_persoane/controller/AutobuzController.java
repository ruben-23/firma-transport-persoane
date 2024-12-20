package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.AutobuzDTO;
import com.firma.transport_persoane.entity.Autobuz;
import com.firma.transport_persoane.mapper.AutobuzMapper;
import com.firma.transport_persoane.service.AutobuzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("firma/autobuze")
public class AutobuzController {

    private final AutobuzService autobuzService;
    private final AutobuzMapper autobuzMapper;

    @Autowired
    public AutobuzController(AutobuzService autobuzService, AutobuzMapper autobuzMapper) {
        this.autobuzService = autobuzService;
        this.autobuzMapper = autobuzMapper;
    }

    @GetMapping
    public ResponseEntity<List<AutobuzDTO>> getAllAutobuze() {
        List<Autobuz> autobuze = autobuzService.getAllAutobuze();
        return ResponseEntity.ok(autobuzMapper.toDTOList(autobuze));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutobuzDTO> getAutobuzById(@PathVariable Integer id) {
        Autobuz autobuz = autobuzService.getAutobuzById(id);
        return ResponseEntity.ok(autobuzMapper.toDTO(autobuz));
    }

    @PostMapping
    public ResponseEntity<AutobuzDTO> adaugaAutobuz(@RequestBody AutobuzDTO autobuzDTO) {
        Autobuz autobuz = autobuzService.adaugaAutobuz(autobuzDTO);
        return ResponseEntity.ok(autobuzMapper.toDTO(autobuz));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutobuzDTO> actualizareAutobuz(@PathVariable Integer id, @RequestBody AutobuzDTO autobuzDTO) {
        autobuzDTO.setIdAutobuz(id);
        Autobuz autobuz = autobuzService.actualizareAutobuz(autobuzDTO);
        return ResponseEntity.ok(autobuzMapper.toDTO(autobuz));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeAutobuz(@PathVariable Integer id) {
        autobuzService.stergeAutobuz(id);
        return ResponseEntity.noContent().build();
    }
}