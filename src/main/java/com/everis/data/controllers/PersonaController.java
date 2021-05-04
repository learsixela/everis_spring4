package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Persona;
import com.everis.data.services.PersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	PersonaService pService;
	
	@RequestMapping("")
	public String inicioPersona() {
		return "persona.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido){
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		
		persona= pService.save(persona);
		
		
		return "redirect:/licencia";
	}

}
