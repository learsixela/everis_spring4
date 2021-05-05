package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

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
		
		
		return "redirect:/persona/login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session,
			Model model) {
		
		//boolean respuesta = pService.autenticacion(email, password);
		
		if(pService.autenticacion(email, password)) {
			session.setAttribute("email", email);
			session.setAttribute("registrado",1);//boolean
			session.setAttribute("contador",100);
			
			String mail = (String) session.getAttribute("email");
			Integer registrado = (Integer) session.getAttribute("registrado");
			Integer contador = (Integer) session.getAttribute("contador");
		
			System.out.println(mail+" - "+registrado+" - "+contador);
			
			model.addAttribute("registrado", true);
			return "index.jsp";
		}else {
			session.removeAttribute("registrado");
			//session.invalidate();
			model.addAttribute("mensaje", "Datos erroneos");
			return "login.jsp";
		}
		
		
	}

}
