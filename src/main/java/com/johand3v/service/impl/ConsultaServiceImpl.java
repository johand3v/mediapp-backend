package com.johand3v.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johand3v.dto.ConsultaListExamenDTO;
import com.johand3v.model.Consulta;
import com.johand3v.repo.IGenericRepo;
import com.johand3v.repo.IConsultaExamenRepo;
import com.johand3v.repo.IConsultaRepo;
import com.johand3v.service.IConsultaService;

@Service
public class ConsultaServiceImpl extends ICRUDImpl<Consulta, Integer>
implements IConsultaService{

	@Autowired
	private IConsultaRepo repo;
	
	@Autowired
	private IConsultaExamenRepo ceRepo;
	
	@Override
	protected IGenericRepo<Consulta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListExamenDTO dto) throws Exception {
		dto.getConsulta().getDetalleConsulta().forEach(det -> det.setConsulta(dto.getConsulta()));
		 repo.save(dto.getConsulta());
		 dto.getLstExamen().forEach(ex -> ceRepo.registrar(dto.getConsulta().getIdConsulta(), ex.getIdExamen()));
		 
		 return dto.getConsulta(); 
	}

}
