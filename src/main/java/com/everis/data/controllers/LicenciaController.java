package com.everis.data.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.data.services.LicenciaService;
import com.everis.data.services.PersonaService;
//import com.everis.data.models.Persona;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {
	
	@Autowired
	LicenciaService lService;
	@Autowired
	PersonaService pService;
	
	@RequestMapping("")
	public String inicioLicencia(Model model) {
		//obtener todas las personas
		//List<Persona> listaPersonas = pService.findAll();
		model.addAttribute("listaPersonas", pService.findAll());
		return "licencia.jsp";
	}

}
