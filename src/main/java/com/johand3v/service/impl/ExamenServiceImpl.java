package com.johand3v.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johand3v.model.Examen;
import com.johand3v.repo.IGenericRepo;
import com.johand3v.repo.IExamenRepo;
import com.johand3v.service.IExamenService;

@Service
public class ExamenServiceImpl extends ICRUDImpl<Examen, Integer>
implements IExamenService{

	@Autowired
	private IExamenRepo repo;
	
	@Override
	protected IGenericRepo<Examen, Integer> getRepo() {
		return repo;
	}

}
