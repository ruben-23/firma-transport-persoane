package com.firma.transport_persoane.repository;

import com.firma.transport_persoane.dto.OrarRutaDTO;
import com.firma.transport_persoane.entity.Orar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrarRepository extends JpaRepository<Orar, Integer> {

    @Query("SELECT new com.firma.transport_persoane.dto.OrarRutaDTO(o.zi, " +
            "r.localitateInceput.nume, r.localitateDestinatie.nume, " +
            "o.localitatePlecare.nume, o.oraPlecare, p.pret) " +
            "FROM Orar o " +
            "JOIN o.ruta r " +
            "JOIN Pret p ON p.ruta.idRuta = r.idRuta AND " +
            "p.localitate.idLocalitate = o.localitatePlecare.idLocalitate ")
    List<OrarRutaDTO> findOrareRute();


}