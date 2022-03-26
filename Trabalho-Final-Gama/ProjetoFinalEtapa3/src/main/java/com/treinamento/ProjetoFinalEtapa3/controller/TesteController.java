package com.treinamento.ProjetoFinalEtapa3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	@GetMapping(path = "/teste")
	public String testando() {
		return "esse é um teste";
	}

}
