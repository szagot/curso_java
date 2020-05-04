package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		/**
		 * HashMap - mais rápido (operações O(1) em tabela hash) e não ordenado
		 * 
		 * TreeMap - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado
		 * pelo compareTo do objeto (ou Comparator)
		 * 
		 * LinkedHashMap - velocidade intermediária e elementos na ordem em que são
		 * adicionados
		 */

		// Inicia uma lista do tipo Map
		Map<String, String> cookie = new TreeMap<>();

		// Adiciona os dados
		cookie.put("name", "Daniel Bispo");
		cookie.put("email", "szagot@gmai.com");
		cookie.put("phone", "1997014416");

		// Removendo uma chave
		cookie.remove("email");

		// Se houver repetição de chave, o valor é sobrescrito
		cookie.put("phone", "1996707272");

		// Verifica se contem uma chave
		System.out.println("Contem a chave phone? " + cookie.containsKey("phone"));

		// Quando uma chave não existe,o get retorna nulo
		System.out.println("Email: " + cookie.get("email"));

		// Tamanho
		System.out.println("Tamanho: " + cookie.size());

		// Lendo
		System.out.println("\nImprindo Cookies:");
		for (String key : cookie.keySet()) {
			System.out.println(key + ": " + cookie.get(key));
		}

	}

}
