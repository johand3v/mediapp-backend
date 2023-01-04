package com.johand3v.service;

import com.johand3v.dto.ConsultaListExamenDTO;
import com.johand3v.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta, Integer>{

	Consulta registrarTransaccional(ConsultaListExamenDTO dto) throws Exception;
}
