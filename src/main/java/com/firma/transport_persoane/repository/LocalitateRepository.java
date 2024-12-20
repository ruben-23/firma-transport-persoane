package com.firma.transport_persoane.repository;

import com.firma.transport_persoane.entity.Localitate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalitateRepository extends JpaRepository<Localitate, Integer> {
}