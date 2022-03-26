package com.treinamento.ProjetoFinalEtapa3.dao;

import org.springframework.data.repository.CrudRepository;

import com.treinamento.ProjetoFinalEtapa3.model.Conta;

public interface ContaDao extends CrudRepository<Conta, Integer> {

}
