package modelo;

public class ContaEspecial extends Conta {
	private double valorLimite = 100;

	public ContaEspecial(int numero, double valorLimite) {
		super(numero);
		this.valorLimite = valorLimite;
	}

	@Override
	public boolean sacar(double valor) {
		if ((super.getSaldo() + this.valorLimite) > valor) {
			return false;
		}
		return super.sacar(valor);
	}

}
