package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		/**
		 * HashMap - mais r�pido (opera��es O(1) em tabela hash) e n�o ordenado
		 * 
		 * TreeMap - mais lento (opera��es O(log(n)) em �rvore rubro-negra) e ordenado
		 * pelo compareTo do objeto (ou Comparator)
		 * 
		 * LinkedHashMap - velocidade intermedi�ria e elementos na ordem em que s�o
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

		// Se houver repeti��o de chave, o valor � sobrescrito
		cookie.put("phone", "1996707272");

		// Verifica se contem uma chave
		System.out.println("Contem a chave phone? " + cookie.containsKey("phone"));

		// Quando uma chave n�o existe,o get retorna nulo
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
