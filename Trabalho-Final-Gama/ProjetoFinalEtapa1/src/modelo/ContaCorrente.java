package modelo;

public class ContaCorrente extends Conta {

	public ContaCorrente(int numero) {
		super(numero);
	}

	@Override
	public boolean sacar(double valor) {
		if (super.getSaldo() <= 0) {
			return false;
		}
		return super.sacar(valor);
	}

}
