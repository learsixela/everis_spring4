package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Categoria;
import com.everis.data.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;

	public void save(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	public List<Categoria> findAll() {
		
		return categoriaRepository.findAll();
	}

}
