import java.util.Scanner;

import modelo.ContaCorrente;
import modelo.ContaEspecial;
import util.GerenciaContas;

public class AppContas {

	static private GerenciaContas gc = new GerenciaContas();
	static private ContaCorrente cc;
	static private ContaEspecial ce;
	static private Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0;
		int numeroConta;
		String menu = "O que você deseja fazer?\r\n1: criar conta;\r\n2: deletar conta;\r\n3: buscar;\r\n4: depositar;\r\n5: sacar;\r\n6: sair;";
		String menuCriarConta = "Qual o tipo da conta? \r\n1: conta corrente;\r\n2: conta especial;";

		while (opcao != 6) {
			System.out.println(menu);
			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1: {
				Boolean criouConta = true;

				System.out.println(menuCriarConta);
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
			}
				break;

			case 2: {
				System.out.println("digite o numero da conta");
				numeroConta = Integer.parseInt(teclado.nextLine());
				if (gc.remover(numeroConta) == true) {
					System.out.println("conta deletada!");
				} else {
					System.out.println("erro! Conta não encontrada...");
				}
				break;
			}

			case 3: {
				System.out.println("numero da conta para buscar");
				numeroConta = Integer.parseInt(teclado.nextLine());
				System.out.println(gc.mostrarDados(numeroConta));
				break;
			}

			case 4: {
				System.out.println("digite o número da conta que será feito o depósito");
				numeroConta = Integer.parseInt(teclado.nextLine());
				System.out.println("valor do depósito");
				double valorADepositar = Double.parseDouble(teclado.nextLine());
				int posicao = gc.getPosicao(numeroConta);
				if (posicao < 0) {
					System.out.println("erro! conta não encontrada...");
				} else {
					gc.contas.get(posicao).depositar(valorADepositar);
					System.out.println("depósito de " + valorADepositar + " realizado");
				}
				break;
			}

			case 5: {
				System.out.println("digite o número da conta que será feito o saque");
				numeroConta = Integer.parseInt(teclado.nextLine());
				System.out.println("valor do saque");
				double valorASacar = Double.parseDouble(teclado.nextLine());
				int posicao = gc.getPosicao(numeroConta);
				if (posicao < 0) {
					System.out.println("erro! conta não encontrada...");
					break;
				}
				if (gc.contas.get(posicao).sacar(valorASacar)) {
					System.out.println("saque de " + valorASacar + " realizado");
				} else {
					System.out.println("limite da conta não permite este saque...");
				}
				break;
			}

			case 6: {
				System.out.println("finalizando sistema...");
				break;
			}

			default: {
				System.out.println("comando desconhecido");
				break;
			}
			}
		}
	}
}