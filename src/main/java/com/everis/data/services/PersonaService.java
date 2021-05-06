package com.everis.data.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Persona;
import com.everis.data.repositories.PersonaRepository;
import com.everis.data.repositories.RolRepository;

@Service
public class PersonaService {
	@Autowired
	PersonaRepository pRepository;
	@Autowired
	RolRepository rolRepository;

	public Persona save(Persona persona) {

		Long cantidad = pRepository.count();
		if(cantidad>0) {
			this.saveUser(persona);
		}else {
			this.saveAdmin(persona);
		}
		System.out.println(cantidad);
		
		return persona; //pRepository.save(persona);
	}

	public Persona saveAdmin(Persona persona) {
		 String hashed = BCrypt.hashpw(persona.getPassword(), BCrypt.gensalt());
		 persona.setPassword(hashed);
		 persona.setRoles(rolRepository.findByNombre("ROL_ADMIN"));
		return pRepository.save(persona);
	}
	
	public Persona saveUser(Persona persona) {
		 String hashed = BCrypt.hashpw(persona.getPassword(), BCrypt.gensalt());
		 persona.setPassword(hashed);
		 persona.setRoles(rolRepository.findByNombre("ROL_USER"));
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
