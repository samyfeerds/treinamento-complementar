package modelo;

public abstract class Conta {
	private int numero;
	private double saldo;

	public Conta(int numero) {
		this.numero = numero;
		this.saldo = 0;
	}

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
