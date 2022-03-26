package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.ContaCorrente;

class ContaCorrenteTest {
	ContaCorrente cc;

	@BeforeEach
	void setUp() {
		cc = new ContaCorrente(1234);
	}

	@Test
	void sacarDeveRetornarTrue() {
		cc.depositar(500);
		boolean resultado = cc.sacar(500);
		assert (resultado);
	}

	@Test
	void sacarDeveRetornarFalse() {
		boolean resultado = cc.sacar(400);
		assert (resultado == false);
	}

	@Test
	void depositarDeveRetornarTrue() {
		boolean resultado = cc.depositar(100);
		assert (resultado);
	}

	@Test
	void depositarDeveRetornarFalse() {
		boolean resultado = cc.depositar(0);
		assert (resultado == false);
	}
}
