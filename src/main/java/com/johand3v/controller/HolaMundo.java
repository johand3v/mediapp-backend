package com.johand3v.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {

	@GetMapping("/")
	public String holaMundo() {
		return "Hola Mundo";
	}
}
