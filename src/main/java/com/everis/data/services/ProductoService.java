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

}
