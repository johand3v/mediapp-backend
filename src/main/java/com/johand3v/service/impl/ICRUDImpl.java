package com.johand3v.service.impl;

import java.util.List;

import com.johand3v.repo.IGenericRepo;
import com.johand3v.service.ICRUD;

public abstract class ICRUDImpl<T,ID> implements ICRUD<T, ID>{

	protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public T registrar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminarPorId(ID id) throws Exception {
		getRepo().deleteById(id);
	}

}
