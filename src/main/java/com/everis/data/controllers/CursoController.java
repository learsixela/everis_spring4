package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Curso;
import com.everis.data.services.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	CursoService cService;
	
	@RequestMapping("")
	public String inicioCurso(HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
			return "curso.jsp";
		}
		return "login.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("curso") String nombre) {
		Curso curso = new Curso();
		curso.setNombre(nombre);
		
		cService.save(curso);
		
		return "redirect:/persona";
	}

}
