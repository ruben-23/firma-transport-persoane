package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.LocalitateIntermediaraDTO;
import com.firma.transport_persoane.entity.LocalitateIntermediara;
import com.firma.transport_persoane.entity.LocalitateIntermediaraId;
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

    @GetMapping("/{idLocalitate}/{idRuta}")
    public ResponseEntity<LocalitateIntermediaraDTO> getLocalitateIntermediaraById(@PathVariable Integer idLocalitate,
                                                                                   @PathVariable Integer idRuta) {
        LocalitateIntermediara localitate =
                service.getLocalitateIntermediaraById(new LocalitateIntermediaraId(idLocalitate, idRuta));

        return ResponseEntity.ok(mapper.toDTO(localitate));
    }

    @PostMapping
    public ResponseEntity<LocalitateIntermediaraDTO> adaugaLocalitateIntermediara(@RequestBody LocalitateIntermediaraDTO dto) {
        LocalitateIntermediara localitate = service.adaugaLocalitateIntermediara(dto);
        return ResponseEntity.ok(mapper.toDTO(localitate));
    }

    @PutMapping("/{idLocalitate}/{idRuta}")
    public ResponseEntity<LocalitateIntermediaraDTO> actualizareLocalitateIntermediara(@PathVariable Integer idLocalitate, @PathVariable Integer idRuta,
                                                                                       @RequestBody LocalitateIntermediaraDTO dto) {
        dto.setIdLocalitateIntermediara(new LocalitateIntermediaraId(idLocalitate, idRuta));
        LocalitateIntermediara localitate = service.actualizareLocalitateIntermediara(dto);
        return ResponseEntity.ok(mapper.toDTO(localitate));
    }

    @DeleteMapping("/{idLocalitate}/{idRuta}")
    public ResponseEntity<Void> stergeLocalitateIntermediara(@PathVariable Integer idLocalitate,
                                                             @PathVariable Integer idRuta) {
        service.stergeLocalitateIntermediara(new LocalitateIntermediaraId(idLocalitate, idRuta));
        return ResponseEntity.noContent().build();
    }
}