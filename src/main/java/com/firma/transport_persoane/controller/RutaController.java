package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.LocalitatePretRutaDTO;
import com.firma.transport_persoane.dto.RutaDTO;
import com.firma.transport_persoane.entity.Ruta;
import com.firma.transport_persoane.mapper.RutaMapper;
import com.firma.transport_persoane.service.LocalitateService;
import com.firma.transport_persoane.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("firma/rute")
public class RutaController {

    private final RutaService rutaService;
    private final RutaMapper rutaMapper;
    private final LocalitateService localitateService;

    @Autowired
    public RutaController(RutaService rutaService, RutaMapper rutaMapper, LocalitateService localitateService) {
        this.rutaService = rutaService;
        this.rutaMapper = rutaMapper;
        this.localitateService = localitateService;
    }

    @GetMapping
    public ResponseEntity<List<RutaDTO>> getAllRute() {
        List<Ruta> rute = rutaService.getAllRute();
        return ResponseEntity.ok(rutaMapper.toDTOList(rute));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaDTO> getRutaById(@PathVariable Integer id) {
        Ruta ruta = rutaService.getRutaById(id);
        return ResponseEntity.ok(rutaMapper.toDTO(ruta));
    }

    @GetMapping("/{idRuta}/localitati/preturi")
    public ResponseEntity<List<LocalitatePretRutaDTO>> getLocalitatiSiPreturiRuta(@PathVariable Integer idRuta) {
        return ResponseEntity.ok(localitateService.getLocalitatiSiPreturiRuta(idRuta));
    }

    @PostMapping
    public ResponseEntity<RutaDTO> adaugaRuta(@RequestBody RutaDTO rutaDTO) {
        Ruta ruta = rutaService.adaugaRuta(rutaDTO);
        return ResponseEntity.ok(rutaMapper.toDTO(ruta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutaDTO> actualizareRuta(@PathVariable Integer id, @RequestBody RutaDTO rutaDTO) {
        rutaDTO.setIdRuta(id);
        Ruta ruta = rutaService.actualizareRuta(id, rutaDTO);
        return ResponseEntity.ok(rutaMapper.toDTO(ruta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeRuta(@PathVariable Integer id) {
        rutaService.stergeRuta(id);
        return ResponseEntity.noContent().build();
    }
}