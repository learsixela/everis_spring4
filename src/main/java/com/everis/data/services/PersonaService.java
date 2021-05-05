package com.everis.data.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Persona;
import com.everis.data.repositories.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	PersonaRepository pRepository;

	public Persona save(Persona persona) {
		 String hashed = BCrypt.hashpw(persona.getPassword(), BCrypt.gensalt());
		 System.out.println("password hashed "+hashed);
		 persona.setPassword(hashed);
		return pRepository.save(persona);
	}

	public List<Persona> findAll() {
		
		return pRepository.findAll();
	}
	
	public Persona findByEmail(String email) {
		return pRepository.findByEmail(email);
	}
	
	public boolean autenticacion(String email,String password) {
		Persona persona = pRepository.findByEmail(email);
		
		//existencia de la persona
		if(persona == null) {
			return false;
		}else {
			if(BCrypt.checkpw(password, persona.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}

}
