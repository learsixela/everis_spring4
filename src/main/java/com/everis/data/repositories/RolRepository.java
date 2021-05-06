package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Rol;
@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	
	List<Rol> findAll();
	
	List<Rol> findByNombre(String name);

}
