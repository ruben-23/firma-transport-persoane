package com.firma.transport_persoane.repository;

import com.firma.transport_persoane.entity.Pret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PretRepository extends JpaRepository<Pret, Integer> {
}