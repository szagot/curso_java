package application;

import entities.Client;

public class Program {

	public static void main(String[] args) {
		/**
		 * object.equals(outroObjeto) compara um objeto a outro. Mais lento, por�m mais
		 * exato
		 * 
		 * object.hashCode() == outroObjeto.hashCode() compara um objeto a outro. Mais
		 * r�pido, por�m se der igualdade, h� um risco de coincidentemente eles terem o
		 * mesmo hash por�m serem diferentes.
		 * 
		 * Conclus�o: Usar o m�todo mais r�pido hashCode, mas quando der igualdade, a�
		 * usar o equals para confirma��o
		 */

		Client c1 = new Client("Daniel Bispo", "szagot@gmail.com");
		Client c2 = new Client("Daniel Bispo", "szagot@gmail.com");

		// Isso vai dar o mesmo resultado
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		// Isso vai dar verdadeiro
		System.out.println(c1.equals(c2));
		// Isso dar� false pq os objetos s�o diferentes (a refer�ncia do objeto na mem�ria � outra)
		System.out.println(c1 == c2);

	}

}
