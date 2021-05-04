package com.everis.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.repositories.LicenciaRepository;

@Service
public class LicenciaService {

	@Autowired
	LicenciaRepository lRepository;
}
