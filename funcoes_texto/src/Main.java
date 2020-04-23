
public class Main {

	public static void main(String[] args) {

		String original = "abcde ABCDE ����� ����� aeuio abcde    ";

		System.out.printf("Original.......: |%s|\n", original);
		System.out.printf("Minusculas.....: |%s|\n", original.toLowerCase());
		System.out.printf("Mai�sculas.....: |%s|\n", original.toUpperCase());
		System.out.printf("Mai�sculas.....: |%s|\n", original.toUpperCase());
		System.out.printf("Sem Espa�o.....: |%s|\n", original.trim());

		// Pegando a partir da posi��o 2
		System.out.printf("Cortando...: |%s|\n", original.substring(2));
		// Pegando a partir da posi��o 2 at� a posi��o 9
		System.out.printf("Cortando.......: |%s|\n", original.substring(2, 9));

		// Trocando caracteres
		System.out.printf("Cortando.......: |%s|\n", original.replace("a", "x"));
		
		// Trazendo a posi��o de um caracter ou conjunto de carateres
		System.out.printf("Primeiro bc....: |%d|\n", original.indexOf("bc"));
		// Trazendo a �ltima posi��o de um caracter ou conjunto de carateres
		System.out.printf("�ltimo bc......: |%d|\n", original.lastIndexOf("bc"));
		
		// Separando por vetores
		String[] vetor = original.split(" ");
		System.out.printf("Segunda palavra: |%s|\n", vetor[1]);
		System.out.printf("Qtd Palavras...: |%d|\n", vetor.length);
	}

}
