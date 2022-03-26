import java.util.Scanner;

import modelo.ContaCorrente;
import modelo.ContaEspecial;
import util.GerenciaContas;

public class AppContas {

	public static void main(String[] args) {
		GerenciaContas gc = new GerenciaContas();
		ContaCorrente cc;
		ContaEspecial ce;
		Scanner teclado = new Scanner(System.in);

		int opcao = 0;
		int numeroConta;
		while (opcao != 6) {
			System.out.println(
					"O que você deseja fazer?\r\n1: criar conta;\r\n2: deletar conta;\r\n3: buscar;\r\n4: depositar;\r\n5: sacar;\r\n6: sair;");
			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				Boolean criouConta = true;

				System.out.println("Qual o tipo da conta? \r\n1: conta corrente;\r\n2: conta especial;");
				opcao = Integer.parseInt(teclado.nextLine());

				System.out.println("digite o numero para a conta");
				numeroConta = Integer.parseInt(teclado.nextLine());

				switch (opcao) {
				case 1:
					cc = new ContaCorrente(numeroConta);
					if (gc.adicionar(cc) == true) {
						criouConta = true;
					} else {
						criouConta = false;
					}
					break;

				case 2:
					System.out.println("Conta especial. Digite o valor limite");
					int valorLimite = Integer.parseInt(teclado.nextLine());
					ce = new ContaEspecial(numeroConta, valorLimite);
					if (gc.adicionar(ce) == true) {
						criouConta = true;
					} else {
						criouConta = false;
					}
					break;

				default:
					System.out.println("tipo desconhecido");
				}
				if (criouConta == true) {
					System.out.println("conta criada!");
				} else {
					System.out.println("conta com o número informado já existe...");
				}
				break;

			case 2:
				System.out.println("digite o numero da conta");
				numeroConta = Integer.parseInt(teclado.nextLine());
				if (gc.remover(numeroConta) == true) {
					System.out.println("conta deletada!");
				} else {
					System.out.println("erro! Conta não encontrada...");
				}
				break;

			case 3:
				System.out.println("numero da conta para buscar");
				numeroConta = Integer.parseInt(teclado.nextLine());
				System.out.println(gc.mostrarDados(numeroConta));
				break;

			case 4:
				System.out.println("digite o número da conta que será feito o depósito");
				numeroConta = Integer.parseInt(teclado.nextLine());
				System.out.println("valor do depósito");
				double valorADepositar = Double.parseDouble(teclado.nextLine());
				int posicaoDepositar = gc.getPosicao(numeroConta);
				if (posicaoDepositar < 0) {
					System.out.println("erro! conta não encontrada...");
				} else {
					gc.contas.get(posicaoDepositar).depositar(valorADepositar);
					System.out.println("depósito de " + valorADepositar + " realizado");
				}
				break;

			case 5:
				System.out.println("digite o número da conta que será feito o saque");
				numeroConta = Integer.parseInt(teclado.nextLine());
				System.out.println("valor do saque");
				double valorASacar = Double.parseDouble(teclado.nextLine());
				int posicaoSacar = gc.getPosicao(numeroConta);
				if (posicaoSacar < 0) {
					System.out.println("erro! conta não encontrada...");
					break;
				}
				if (gc.contas.get(posicaoSacar).sacar(valorASacar)) {
					System.out.println("saque de " + valorASacar + " realizado");
				} else {
					System.out.println("erro! Saldo insuficiente, ou a conta tem um limite de valor a sacar...");
				}
				break;

			case 6:
				System.out.println("finalizando sistema...");
				break;

			default:
				System.out.println("comando desconhecido");
				break;
			}
		}
		teclado.close();
	}
}
