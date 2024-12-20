package com.firma.transport_persoane.repository;

import com.firma.transport_persoane.entity.Autobuz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutobuzRepository extends JpaRepository<Autobuz, Integer> {
}