package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;

	public void save(Producto curso) {
		productoRepository.save(curso);
	}
	
	public List<Producto> findAll() {
		
		return productoRepository.findAll();
	}

	public Producto findById(Long id) {
		return productoRepository.findById(id).get();
	}

	
	public void querysJPQL() {
		//JPQL
		List<Producto> lista1 =productoRepository.findAllProductos();
		List<String> lista2 = productoRepository.findAllProductosNombres();
		List<Producto> lista3 = productoRepository.getProductoWhereId(2L);
		Producto prod= productoRepository.getSingleProductoWhereId(3L);
		//modificar
		int respuesta=productoRepository.setNombreForOne("Mouse", 2L);
		int respuesta2=productoRepository.setNombreForAll("Notebook");
		int respuesta3=productoRepository.deleteOneProducto(2L);
		
		/**
		 * Querys nativas
		 */
		
		List<Object[]> oProductos = productoRepository.findAllProductosWithfilter();
		Object[] vProducto = oProductos.get(0);//cargara el primer producto
		Object productoId= vProducto[0];
		Object productoNombre= vProducto[1];
		System.out.println(productoId+" - "+productoNombre);
	}
}
