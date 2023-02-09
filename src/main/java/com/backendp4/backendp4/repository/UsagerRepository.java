package com.backendp4.backendp4.repository;

import com.backendp4.backendp4.model.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsagerRepository extends JpaRepository<Usager,Long> {
}
