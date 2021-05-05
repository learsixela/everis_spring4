package com.everis.data.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

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
	public String inicioLicencia(Model model,HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
			//obtener todas las personas
			//List<Persona> listaPersonas = pService.findAll();
			model.addAttribute("listaPersonas", pService.findAll());
			//consultar objeto por Lazy
			//Licencia licencia = lService.finById(1L);
			return "licencia.jsp";
		}

		return "login.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertarLicencia(@RequestParam("numero") String numero,
	@RequestParam("estado") String estado,
	@RequestParam("expiracion") String expiracion,
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
		
		//fechas de String a Date
		try {
			Date fecha=new SimpleDateFormat("yyyy-MM-dd").parse(expiracion);
			licencia.setExpiracion(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(""+e);
		}
		
		//Agregar persona
		licencia.setPersona(persona);

		lService.save(licencia);
		
		return "redirect:/licencia";
	}

}
