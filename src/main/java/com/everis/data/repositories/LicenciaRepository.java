package com.everis.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Licencia;

@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Long> {

}
