package sistema;

import java.util.Scanner;

import service.HandleMenuProduto;

public class Sistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		HandleMenuProduto hm = new HandleMenuProduto();

		int opcao = 0;

		do {

			System.out.println();
			System.out.println(
					"1 - Criar Produto\n2 - Editar Produto\n3 - Deletar Produto\n4 - Listar Produtos\n5 - Listar Especifico\n6 - Somar valores\n7 - Quantidade de itens\n9 - Sair ");
			System.out.println();
			System.out.print("Escolha: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1: {
				hm.criarProduto();
				continue;
			}
			case 2:
				hm.editar();
				continue;
			case 3:
				hm.deletar();
				continue;
			case 4:
				hm.listar();
				continue;
			case 5:
				hm.listarEspecifico();
				continue;
			case 6:
				hm.somar();
				continue;
			case 7:
				hm.quant();
				continue;
			case 9:
				System.out.println("Sistema encerrado... Obrigado!");
				break;
			default:
				System.err.println("Por favor, digite uma opção válida!");

			}

		} while (opcao != 9);
		sc.close();

	}

}
