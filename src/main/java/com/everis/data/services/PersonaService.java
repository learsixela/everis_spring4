package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Persona;
import com.everis.data.repositories.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	PersonaRepository pRepository;

	public Persona save(Persona persona) {
		return pRepository.save(persona);
	}

	public List<Persona> findAll() {
		
		return pRepository.findAll();
	}
	
	

}
