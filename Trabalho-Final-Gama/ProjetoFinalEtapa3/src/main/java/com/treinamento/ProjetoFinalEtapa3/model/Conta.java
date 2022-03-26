package com.treinamento.ProjetoFinalEtapa3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta_corrente")
public class Conta {
	@Id
	@Column(name = "numero")
	private int numero;
	@Column(name = "saldo")
	private double saldo;

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public boolean depositar(double valor) {
		if (valor <= 0) {
			return false;
		}
		this.saldo += valor;
		return true;
	}

	public boolean sacar(double valor) {
		if (valor <= 0) {
			return false;
		}
		this.saldo -= valor;
		return true;
	}

	@Override
	public String toString() {
		return "número da conta: " + numero + ", saldo: R$" + saldo;
	}

}
