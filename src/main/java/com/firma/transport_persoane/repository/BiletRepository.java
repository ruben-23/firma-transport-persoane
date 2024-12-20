package com.firma.transport_persoane.repository;

import com.firma.transport_persoane.entity.Bilet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiletRepository extends JpaRepository<Bilet, Integer> {
}