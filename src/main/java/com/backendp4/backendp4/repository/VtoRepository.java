package com.backendp4.backendp4.repository;

import com.backendp4.backendp4.model.Vto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VtoRepository extends JpaRepository<Vto,Long> {
}
