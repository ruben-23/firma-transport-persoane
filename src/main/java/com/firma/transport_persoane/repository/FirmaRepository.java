package com.firma.transport_persoane.repository;

import com.firma.transport_persoane.entity.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmaRepository extends JpaRepository<Firma, Integer> {
}