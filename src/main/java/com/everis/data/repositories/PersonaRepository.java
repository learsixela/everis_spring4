package com.everis.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
