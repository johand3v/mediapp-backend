package com.johand3v.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johand3v.model.Paciente;
import com.johand3v.repo.IGenericRepo;
import com.johand3v.repo.IPacienteRepo;
import com.johand3v.service.IPacienteService;

@Service
public class PacienteServiceImpl extends ICRUDImpl<Paciente, Integer>
implements IPacienteService{

	@Autowired
	private IPacienteRepo repo;
	
	@Override
	protected IGenericRepo<Paciente, Integer> getRepo() {
		return repo;
	}

}
