package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.ContaEspecial;

class ContaEspecialTest {
	private ContaEspecial ce;

	@BeforeEach
	void setUp() {
		ce = new ContaEspecial(1234, 500);
	}

	@Test
	void sacarDeveRetornarTrue() {
		ce.depositar(500);
		boolean resultado = ce.sacar(1000);
		assert (resultado);
	}

	@Test
	void sacarDeveRetornarFalse() {
		ce.depositar(500);
		boolean resultado = ce.sacar(900);
		assert (resultado == false);
	}

	@Test
	void depositarDeveRetornarTrue() {
		boolean resultado = ce.depositar(500);
		assert (resultado);
	}

	@Test
	void depositarDeveRetornarFalse() {
		boolean resultado = ce.depositar(00);
		assert (resultado == false);
	}
}
