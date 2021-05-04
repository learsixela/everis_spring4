package com.everis.data.controllers;

import java.util.Date;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Licencia;
import com.everis.data.models.Persona;
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
	
	@RequestMapping("/insertar")
	public String insertarLicencia(@RequestParam("numero") String numero,
	@RequestParam("estado") String estado,
	@RequestParam("fecha") Date fecha,
	@RequestParam("persona") Persona persona) {

		boolean state;
		Licencia licencia = new Licencia();
		licencia.setNumero(numero);
		if(estado.equals("1")) {
			state=true;
		}else {
			state=false;
		}
		licencia.setEstado(state);
		licencia.setExpiracion(fecha);
		//Agregar persona
		licencia.setPersona(persona);

		//licencia= licenciaService.save(licencia);
		
		
		
		return "redirect:/licencia";
	}

}
