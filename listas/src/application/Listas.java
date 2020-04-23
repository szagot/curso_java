package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Listas {

	public static void main(String[] args) {

		// Criando uma lista
		List<String> nomes = new ArrayList<>();

		// Adicionando nomes
		nomes.add("Daniel");
		nomes.add("Alini");
		nomes.add("Filipe");
		nomes.add("Alejandro");

		// Lendo lista
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		System.out.println("--------");

		// Mostrando tamanho da lista
		System.out.println("Quantidade de nomes: " + nomes.size());
		// Mostrando a posi��o de um nome
		System.out.println("Posi��o do nome Filipe: " + nomes.indexOf("Filipe"));

		System.out.println("--------");
		
		// Gerando uma lista nova apenas com nomes que comecem com A
		List<String> nomesA = nomes.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
		for (String nome : nomesA) {
			System.out.println(nome);
		}

		System.out.println("--------");
		
		// Pegando o primeiro nome com a letra X
		String nomeF = nomes.stream().filter(x -> x.charAt(0) == 'X').findFirst().orElse("N�o Existe nomes come�ados com X");
		System.out.println(nomeF);

		System.out.println("--------");
				
		// Inserindo novo elemento em uma posi��o espec�fica
		nomes.add(2, "Sofia");

		// Remove a primeira ocorr�ncia equivalente
		nomes.remove("Daniel");

		// Remove pela posi��o
		nomes.remove(1);

		// Remove pelo predicado (lambda): todos os nomes come�ados com A
		nomes.removeIf(x -> x.charAt(0) == 'A');

		// Lendo lista
		for (String nome : nomes) {
			System.out.println(nome);
		}

	}

}
