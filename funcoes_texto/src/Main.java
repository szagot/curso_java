
public class Main {

	public static void main(String[] args) {

		String original = "abcde ABCDE áéíóú ÁÉÍÓÚ aeuio abcde    ";

		System.out.printf("Original.......: |%s|\n", original);
		System.out.printf("Minusculas.....: |%s|\n", original.toLowerCase());
		System.out.printf("Maiúsculas.....: |%s|\n", original.toUpperCase());
		System.out.printf("Maiúsculas.....: |%s|\n", original.toUpperCase());
		System.out.printf("Sem Espaço.....: |%s|\n", original.trim());

		// Pegando a partir da posição 2
		System.out.printf("Cortando...: |%s|\n", original.substring(2));
		// Pegando a partir da posição 2 até a posição 9
		System.out.printf("Cortando.......: |%s|\n", original.substring(2, 9));

		// Trocando caracteres
		System.out.printf("Cortando.......: |%s|\n", original.replace("a", "x"));
		
		// Trazendo a posição de um caracter ou conjunto de carateres
		System.out.printf("Primeiro bc....: |%d|\n", original.indexOf("bc"));
		// Trazendo a última posição de um caracter ou conjunto de carateres
		System.out.printf("Último bc......: |%d|\n", original.lastIndexOf("bc"));
		
		// Separando por vetores
		String[] vetor = original.split(" ");
		System.out.printf("Segunda palavra: |%s|\n", vetor[1]);
		System.out.printf("Qtd Palavras...: |%d|\n", vetor.length);
	}

}
