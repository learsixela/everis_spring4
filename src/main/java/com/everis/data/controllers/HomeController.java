package com.everis.data.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.data.models.Persona;
import com.everis.data.services.PersonaService;

@Controller
public class HomeController {
	@Autowired
	PersonaService pService;

	@RequestMapping("/")
	public String index(HttpSession session) {
		//session.invalidate();
		session.setAttribute("registrado",0);
		return "login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@Valid @ModelAttribute("persona") Persona persona,Model model) {
		model.addAttribute("persona", new Persona());
		System.out.println("Registro");
//diferenciar segun rol
//existencia de usuario por email
//validar contraseñas
		

		
		return "registro.jsp";
	}
	
}
