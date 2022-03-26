package com.treinamento.ProjetoFinalEtapa3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.ProjetoFinalEtapa3.dao.ContaDao;
import com.treinamento.ProjetoFinalEtapa3.model.Conta;

@RestController
public class ContaController {
	@Autowired
	private ContaDao dao;

	@GetMapping(path = "/contas/{numero}")
	public Conta recuperar(@PathVariable int numero) {
		return dao.findById(numero).orElse(null);
	}

	@GetMapping(path = "/contas")
	public List<Conta> RecuperarTodas() {
		return (List<Conta>) dao.findAll();
	}

}
