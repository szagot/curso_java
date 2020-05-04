package application;

import entities.Client;

public class Program {

	public static void main(String[] args) {
		/**
		 * object.equals(outroObjeto) compara um objeto a outro. Mais lento, porém mais
		 * exato
		 * 
		 * object.hashCode() == outroObjeto.hashCode() compara um objeto a outro. Mais
		 * rápido, porém se der igualdade, há um risco de coincidentemente eles terem o
		 * mesmo hash porém serem diferentes.
		 * 
		 * Conclusão: Usar o método mais rápido hashCode, mas quando der igualdade, aí
		 * usar o equals para confirmação
		 */

		Client c1 = new Client("Daniel Bispo", "szagot@gmail.com");
		Client c2 = new Client("Daniel Bispo", "szagot@gmail.com");

		// Isso vai dar o mesmo resultado
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		// Isso vai dar verdadeiro
		System.out.println(c1.equals(c2));
		// Isso dará false pq os objetos são diferentes (a referência do objeto na memória é outra)
		System.out.println(c1 == c2);

	}

}
