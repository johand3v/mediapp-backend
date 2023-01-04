package com.johand3v.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.johand3v.exception.ModelNotFoundException;
import com.johand3v.model.Paciente;
import com.johand3v.service.IPacienteService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;

	@PostMapping
	public ResponseEntity<Paciente> registrar(@RequestBody @Valid Paciente t) throws Exception {

		Paciente obj = service.registrar(t);
		//localhost:8080/pacientes/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdPaciente()).toUri();
		
		//return new ResponseEntity<>(service.registrar(t), HttpStatus.CREATED);
		return ResponseEntity.created(location).build();

	}

	@PutMapping
	public ResponseEntity<Paciente> modificar(@RequestBody @Valid Paciente t) throws Exception {
		return new ResponseEntity<>(service.modificar(t), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Paciente>> listar() throws Exception {
		return new ResponseEntity<> (service.listar(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable Integer id) throws Exception {
		
		Paciente obj = service.listarPorId(id);
		
		if (obj == null) {
			throw new ModelNotFoundException("Paciente no encontrado con el ID " + id);
		}
		
		return new ResponseEntity<>(service.listarPorId(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable Integer id) throws Exception {
		
		Paciente obj = service.listarPorId(id);
		
		if (obj == null) {
			throw new ModelNotFoundException("Paciente no encontrado con el ID " + id);
		}
		service.eliminarPorId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hateoas/{id}")
	public EntityModel<Paciente> listarHateosPorId(@PathVariable Integer id) throws Exception {
		
		Paciente obj = service.listarPorId(id);
		
		if (obj == null) {
			throw new ModelNotFoundException("Paciente no encontrado con el ID " + id);
		}
		
		//localhost:8080/paciente/1
		EntityModel<Paciente> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarHateosPorId(id));
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).listarHateosPorId(2));
		recurso.add(link1.withRel("paciente-recurso1"));
		recurso.add(link2.withRel("paciente-recurso1"));
		return recurso;
	}

	
}
