package com.everis.data.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Categoria;
import com.everis.data.models.Producto;
import com.everis.data.services.CategoriaService;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String inicioProducto(HttpSession session,Model model) {
		productoService.querysJPQL();
		model.addAttribute("listaProductos", productoService.findAll());
		return "producto.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombre") String nombre,
			@RequestParam("desc") String descripcion,
			@RequestParam("precio") String precio
			) {
		Producto prod = new Producto();
		prod.setNombre(nombre);
		prod.setPrecio(Float.parseFloat(precio));
		prod.setDescripcion(descripcion);
		
		productoService.save(prod);
		
		return "redirect:/producto";
	}

	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id,HttpSession session, Model model) {
		Producto prod= productoService.findById(id);
		
		List<Categoria> listaCategorias =  categoriaService.findAll();
		
		model.addAttribute("producto", prod);
		model.addAttribute("listaCategorias", listaCategorias);
		return "editproducto.jsp";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("producto")Producto prod,HttpSession session ) {
		productoService.save(prod);
		return "redirect:/producto";
	}
}
