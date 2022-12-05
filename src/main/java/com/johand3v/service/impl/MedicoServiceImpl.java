package com.johand3v.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johand3v.model.Medico;
import com.johand3v.repo.IGenericRepo;
import com.johand3v.repo.IMedicoRepo;
import com.johand3v.service.IMedicoService;

@Service
public class MedicoServiceImpl extends ICRUDImpl<Medico, Integer>
implements IMedicoService{

	@Autowired
	private IMedicoRepo repo;
	
	@Override
	protected IGenericRepo<Medico, Integer> getRepo() {
		return repo;
	}

}
