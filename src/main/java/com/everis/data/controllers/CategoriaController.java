package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Categoria;
import com.everis.data.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String inicioCategoria(HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
			return "categoria.jsp";
		}
		return "login.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombre") String nombre) {
		Categoria categoria = new Categoria();
		categoria.setNombre(nombre);
		
		categoriaService.save(categoria);
		
		return "redirect:/categoria";
	}

}
