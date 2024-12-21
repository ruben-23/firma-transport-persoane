package com.firma.transport_persoane.repository;

import com.firma.transport_persoane.entity.LocalitateIntermediara;
import com.firma.transport_persoane.entity.LocalitateIntermediaraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalitateIntermediaraRepository extends JpaRepository<LocalitateIntermediara, LocalitateIntermediaraId> {
}