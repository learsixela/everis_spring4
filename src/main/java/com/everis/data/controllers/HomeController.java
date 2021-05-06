package com.everis.data.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.data.models.Persona;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		//session.invalidate();
		session.setAttribute("registrado",0);
		return "login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@Valid @ModelAttribute("persona") Persona persona) {
		
		//Persona persona2 = new Persona();
		
		return "registro.jsp";
	}
	
}
