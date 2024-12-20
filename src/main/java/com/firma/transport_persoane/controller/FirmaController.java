package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.FirmaDTO;
import com.firma.transport_persoane.entity.Firma;
import com.firma.transport_persoane.mapper.FirmaMapper;
import com.firma.transport_persoane.service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("firma")
public class FirmaController {

    private final FirmaService firmaService;
    private final FirmaMapper firmaMapper;

    @Autowired
    public FirmaController(FirmaService firmaService, FirmaMapper firmaMapper) {
        this.firmaService = firmaService;
        this.firmaMapper = firmaMapper;
    }

    @GetMapping
    public ResponseEntity<List<FirmaDTO>> getAllFirme() {
        List<Firma> firme = firmaService.getAllFirme();
        return ResponseEntity.ok(firmaMapper.toDTOList(firme));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FirmaDTO> getFirmaById(@PathVariable Integer id) {
        Firma firma = firmaService.getFirmaById(id);
        return ResponseEntity.ok(firmaMapper.toDTO(firma));
    }

    @PostMapping
    public ResponseEntity<FirmaDTO> adaugaFirma(@RequestBody FirmaDTO firmaDTO) {
        Firma firma = firmaService.adaugaFirma(firmaDTO);
        return ResponseEntity.ok(firmaMapper.toDTO(firma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FirmaDTO> actualizareFirma(@PathVariable Integer id, @RequestBody FirmaDTO firmaDTO) {
        firmaDTO.setIdFirma(id);
        Firma firma = firmaService.actualizareFirma(id, firmaDTO);
        return ResponseEntity.ok(firmaMapper.toDTO(firma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeFirma(@PathVariable Integer id) {
        firmaService.stergeFirma(id);
        return ResponseEntity.noContent().build();
    }
}