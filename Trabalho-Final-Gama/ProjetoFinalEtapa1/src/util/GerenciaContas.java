package util;

import java.util.ArrayList;

import modelo.Conta;

public class GerenciaContas {
	public ArrayList<Conta> contas;

	public GerenciaContas() {
		contas = new ArrayList<>();
	}

	public boolean adicionar(Conta c) {
		int getPosicao = getPosicao(c.getNumero());
		if (getPosicao >= 0) {
			return false;
		}
		contas.add(c);
		return true;
	}

	public boolean remover(int numero) {
		int getPosicao = getPosicao(numero);
		if (getPosicao < 0) {
			return false;
		}
		contas.remove(getPosicao);
		return true;
	}

	public int getPosicao(int numero) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNumero() == numero) {
				return i;
			}
		}
		return -1;
	}

	public String mostrarDados(int numero) {
		int getPosicao = getPosicao(numero);
		if (getPosicao < 0) {
			return "Erro! Conta não encontrada...";
		}
		return contas.get(getPosicao(numero)).toString();
	}

}
