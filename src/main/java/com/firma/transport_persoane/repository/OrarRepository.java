package com.firma.transport_persoane.repository;

import com.firma.transport_persoane.entity.Orar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrarRepository extends JpaRepository<Orar, Integer> {
}