package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Curso;
import com.everis.data.repositories.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepo;

	public void save(Curso curso) {
		cursoRepo.save(curso);
	}
	
	public List<Curso> findAll() {
		
		return cursoRepo.findAll();
	}

}
