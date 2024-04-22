package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Produto;

public class GerenciadorDeProdutos {

	public static final String NOME_PRODUTO = "produtos.txt";

	public void verificaECria(String nomeArquivo) {

		File arquivo = new File(nomeArquivo);

		if (arquivo.exists()) {
			System.out.println("Banco funcionando!");
		} else
			try {

				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso!");
			} catch (IOException e) {
				System.err.println("Ocorreu um erro ao criar o arquivo" + e.getMessage());
			}
	}

	public void adicionarUsuario(Produto produto) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_PRODUTO, true))) {

			bw.write(produto.toString());
			bw.newLine();
			System.out.println("PRODUTO CADASTRADO COM SUCESSO");

		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());

		}

	}

	public List<Produto> lerProdutos() {
		List<Produto> produtos = new ArrayList<Produto>();
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_PRODUTO))) {
			String linha;

			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				produtos.add(new Produto(Long.parseLong(partes[0]), partes[1], Double.parseDouble(partes[2]),
						Integer.parseInt(partes[3])));

			}
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return produtos;
	}

	public void deletar(long id) {
		List<Produto> produtos = lerProdutos();
		if (produtos.removeIf(produto -> produto.getId() == id)) {
			reescreverArquivo(produtos);
			System.out.println("Produto deletado com sucesso");
		} else {
			System.err.println("Produto nao encontrado");
		}

	}

	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_PRODUTO))) {
			for (Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}

		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao reescrever o arquivo");
		}
	}

	public void listarProdutos() {

		List<Produto> produtos = lerProdutos();
		if (produtos.isEmpty()) {
			System.err.println("Nenhum produto encontrado!!!");
		} else {
			System.out.println("LISTA DE PRODUTOS INICIADA: ");
			for (Produto produto : produtos) {
				System.out.println("Id:" + produto.getId() + " Nome:" + produto.getNome() + " Preço:"
						+ produto.getPreco() + " Quantidade:" + produto.getQuantidade());
			}
		}

	}

	public void editarProduto(long id, String novoNome, double novoPreco, int novoQuant) {
		List<Produto> produtos = lerProdutos();
		boolean encontrado = false;
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				produto.setNome(novoNome);
				produto.setPreco(novoPreco);
				produto.setQuantidade(novoQuant);
				encontrado = true;
				break;
			}

		}
		if (encontrado) {
			reescreverArquivo(produtos);
			System.out.println("Produto editado com sucesso!!!");
		} else {
			System.err.println("Produto não encontrado");
		}

	}

	public void listarEspecificio(long id) {
		List<Produto> produtos = lerProdutos();
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				System.out.println("INICIANDO LISTA ESPECIFICADA:");
				System.out.println("Id:" + produto.getId() + " Nome:" + produto.getNome() + " Preço:"
						+ produto.getPreco() + " Quantidade:" + produto.getQuantidade());
			}

		}

	}

	public void somar() {
		List<Produto> produtos = lerProdutos();
		double soma = 0;
		for (Produto produto : produtos) {
			soma += produto.getPreco() * (produto.getQuantidade());
		}
		System.out.println(soma);
	}

	public void quantidade() {
		List<Produto> produtos = lerProdutos();
		double soma = 0;
		for (Produto produto : produtos) {
			// +=
			soma += (produto.getQuantidade());
		}
		System.out.println(soma);
	}

}
