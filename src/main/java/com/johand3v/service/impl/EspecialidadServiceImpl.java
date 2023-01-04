package com.johand3v.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johand3v.model.Especialidad;
import com.johand3v.repo.IGenericRepo;
import com.johand3v.repo.IEspecialidadRepo;
import com.johand3v.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl extends ICRUDImpl<Especialidad, Integer>
implements IEspecialidadService{

	@Autowired
	private IEspecialidadRepo repo;
	
	@Override
	protected IGenericRepo<Especialidad, Integer> getRepo() {
		return repo;
	}

}
