package arquivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MostrandoArquivo {

	public static void main(String[] args) {

		// Instanciando o arquivo
		File file = new File("c:\\eclipse\\in.txt");
		Scanner sc = null;
		try {
			// Abrindo arquivo
			sc = new Scanner(file);
			// Lendo linha a linha do arquivo
			while (sc.hasNextLine()) {
				// Printando a linha atual
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler arqvuio: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
