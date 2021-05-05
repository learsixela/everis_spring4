package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Persona;
import com.everis.data.services.CursoService;
import com.everis.data.services.PersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	PersonaService pService;
	@Autowired
	CursoService cService;
	
	@RequestMapping("")
	public String inicioPersona(Model model) {
		model.addAttribute("listaCursos", cService.findAll());
		return "persona.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("email") String email,
			@RequestParam("password") String password
			){
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEmail(email);
		persona.setPassword(password);
		
		persona= pService.save(persona);
		
		
		return "redirect:/licencia";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		
		//boolean respuesta = pService.autenticacion(email, password);
		
		if(pService.autenticacion(email, password)) {
			return "index.jsp";
		}else {
			model.addAttribute("mensaje", "Datos erroneos");
			return "login.jsp";
		}
		
		
	}

}
