package application;

public class VetorForEach {

	public static void main(String[] args) {

		// Instanciando vetor e já definindo valores
		String[] nomes = new String[] { "Daniel", "Alini", "Filipe", "Alejandro" };

		// Lendo do modo convencional
		for (int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);
		}
		System.out.println("---------");

		// Lendo com for each
		for (String nome : nomes) {
			System.out.println(nome);
		}

	}

}
