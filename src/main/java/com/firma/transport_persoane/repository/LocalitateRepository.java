package com.firma.transport_persoane.repository;

import com.firma.transport_persoane.dto.LocalitatePretRutaDTO;
import com.firma.transport_persoane.entity.Localitate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalitateRepository extends JpaRepository<Localitate, Integer> {

    // returneaza toate localitatile, pretul si ordinea(pentru cele intermediare) pentru o anumita ruta
    @Query("SELECT new com.firma.transport_persoane.dto.LocalitatePretRutaDTO(l.idLocalitate, l.nume, p.pret, li.ordine) " +
            "FROM Localitate l " +
            "LEFT JOIN Pret p ON l.idLocalitate = p.localitate.idLocalitate AND p.ruta.idRuta = :idRuta " +
            "LEFT JOIN LocalitateIntermediara li ON l.idLocalitate = li.localitate.idLocalitate AND li.ruta.idRuta = :idRuta " +
            "WHERE l.idLocalitate IN (SELECT r.localitateInceput.idLocalitate FROM Ruta r WHERE r.idRuta = :idRuta " +
            "UNION SELECT r.localitateDestinatie.idLocalitate FROM Ruta r WHERE r.idRuta = :idRuta " +
            "UNION SELECT li.localitate.idLocalitate FROM LocalitateIntermediara li WHERE li.ruta.idRuta = :idRuta)")
    List<LocalitatePretRutaDTO> findLocalitatiSiPretPentruRuta(@Param("idRuta") Integer idRuta);

}