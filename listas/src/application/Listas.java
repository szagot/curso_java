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
		// Mostrando a posição de um nome
		System.out.println("Posição do nome Filipe: " + nomes.indexOf("Filipe"));

		System.out.println("--------");
		
		// Gerando uma lista nova apenas com nomes que comecem com A
		List<String> nomesA = nomes.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
		for (String nome : nomesA) {
			System.out.println(nome);
		}

		System.out.println("--------");
		
		// Pegando o primeiro nome com a letra X
		String nomeF = nomes.stream().filter(x -> x.charAt(0) == 'X').findFirst().orElse("Não Existe nomes começados com X");
		System.out.println(nomeF);

		System.out.println("--------");
				
		// Inserindo novo elemento em uma posição específica
		nomes.add(2, "Sofia");

		// Remove a primeira ocorrência equivalente
		nomes.remove("Daniel");

		// Remove pela posição
		nomes.remove(1);

		// Remove pelo predicado (lambda): todos os nomes começados com A
		nomes.removeIf(x -> x.charAt(0) == 'A');

		// Lendo lista
		for (String nome : nomes) {
			System.out.println(nome);
		}

	}

}
