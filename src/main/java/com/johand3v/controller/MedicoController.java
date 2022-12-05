package com.johand3v.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johand3v.exception.ModelNotFoundException;
import com.johand3v.model.Medico;
import com.johand3v.service.IMedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private IMedicoService service;

	@PostMapping
	public ResponseEntity<Medico> registrar(@RequestBody @Valid Medico t) throws Exception {
		return new ResponseEntity<>(service.registrar(t), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Medico> modificar(@RequestBody @Valid Medico t) throws Exception {
		return new ResponseEntity<>(service.modificar(t), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Medico>> listar() throws Exception {
		return new ResponseEntity<> (service.listar(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medico> listarPorId(@PathVariable Integer id) throws Exception {
		
		Medico obj = service.listarPorId(id);
		
		if (obj == null) {
			throw new ModelNotFoundException("Medico no encontrado con el ID " + id);
		}
		
		return new ResponseEntity<>(service.listarPorId(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable Integer id) throws Exception {
		
		Medico obj = service.listarPorId(id);
		
		if (obj == null) {
			throw new ModelNotFoundException("Medico no encontrado con el ID " + id);
		}
		service.eliminarPorId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
}
