package com.backendp4.backendp4.repository;

import com.backendp4.backendp4.model.Vpt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VptRepository extends JpaRepository<Vpt,Long> {
}
