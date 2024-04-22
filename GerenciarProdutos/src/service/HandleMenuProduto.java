package service;

import java.util.List;
import java.util.Scanner;
import models.Produto;
import utils.GerenciadorDeProdutos;

public class HandleMenuProduto {

	Scanner sc = new Scanner(System.in);

	GerenciadorDeProdutos gp = new GerenciadorDeProdutos();

	public HandleMenuProduto() {
		gp.verificaECria("produtos.txt");
	}

	public void criarProduto() {

		System.out.println("INICIANDO CADASTRO DE PRODUTO");
		System.out.println();

		System.out.print("Digite o nome do produto: ");
		String nome = sc.next();

		System.out.print("Digite o preço do produto: ");
		double preco = sc.nextDouble();

		System.out.print("Digite a quantidade: ");
		int quant = sc.nextInt();
		System.out.println();

		long id = getNextId();

		Produto p = new Produto(id, nome, preco, quant);
		gp.adicionarUsuario(p);
	}

	public void editar() {
		System.out.print("Digite o id do produto que deseja editar: ");
		long id = sc.nextLong();
		System.out.print("Digite o novo nome: ");
		String nome = sc.next();
		System.out.print("Digite o novo preço: ");
		double preco = sc.nextDouble();
		System.out.print("Digite a nova quantidade: ");
		int quant = sc.nextInt();
		gp.editarProduto(id, nome, preco, quant);

	}

	public void deletar() {
		System.out.println("Digite o Id do produto a ser deletado: ");
		long id = sc.nextLong();
		gp.deletar(id);
	}

	public void listar() {
		gp.listarProdutos();

	}

	public void listarEspecifico() {
		System.out.print("Digite o id do produto que deseja ver: ");
		long id = sc.nextLong();
		gp.listarEspecificio(id);
	}

	public long getNextId() {
		List<Produto> produtos = gp.lerProdutos();
		long maxId = 0;
		for (Produto produto : produtos) {
			long id = produto.getId();

			if (id > maxId) {
				maxId = id;
			}
		}
		return maxId + 1;
	}

	public void somar() {
		System.out.print("Esse é o total dos valores dos produtos: ");
		gp.somar();

	}

	public void quant() {
		System.out.print("Essa é a quantidade de itens: ");
		gp.quantidade();

	}

}
