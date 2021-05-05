package com.everis.data.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	
	private static final int CANT_PRODUCTOS = 4;
	
	@RequestMapping("")
	public String inicioProducto(HttpSession session,Model model) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
			productoService.querysJPQL();
			model.addAttribute("listaProductos", productoService.findAll());
			//model.addAttribute("listaProductos", productoService.productosPaginados(1,CANT_PRODUCTOS));
			
			Page<Producto> productos= productoService.productosPaginados(0, CANT_PRODUCTOS);
			
			int totalPagina= productos.getTotalPages();
			model.addAttribute("totalPagina", totalPagina);
			model.addAttribute("productos", productos);
			return "producto.jsp";
		}
		
		return "login.jsp";
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
	
	/**
	 * Paginacion
	 * */
	@RequestMapping("/paginacion/{numeroPagina}")
	public String getProductosPagina(@PathVariable("numeroPagina") int numeroPagina,
			Model model) {
		//paginas iterable comienzan en 0 cero. 1 a maxPag (ultima pagina)
		Page<Producto> productos= productoService.productosPaginados(numeroPagina-1, CANT_PRODUCTOS);
		
		int totalPagina= productos.getTotalPages();
		model.addAttribute("totalPagina", totalPagina);
		model.addAttribute("productos", productos);
		
		return "producto.jsp";
	}
	
	
	
}
