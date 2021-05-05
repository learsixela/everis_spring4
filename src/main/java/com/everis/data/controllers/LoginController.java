package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Login;
import com.everis.data.services.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("")
	public String login() {
		return "login.jsp";
	}

	@RequestMapping("/guardar")
	public String guardarLogin(@RequestParam("email") String email,
			@RequestParam("password") String password
			) {
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		
		loginService.registrar(login);
		
		return "redirect:/";
	}
	
	
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		
		//boolean respuesta = pService.autenticacion(email, password);
		
		if(loginService.autenticacion(email, password)) {
			return "index.jsp";
		}else {
			model.addAttribute("mensaje", "Datos erroneos");
			return "login.jsp";
		}
		
		
	}
}
