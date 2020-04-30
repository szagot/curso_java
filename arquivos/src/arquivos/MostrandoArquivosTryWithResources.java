package arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MostrandoArquivosTryWithResources {

	public static void main(String[] args) {

		String path = "c:\\eclipse\\in.txt";

		// Inicia o try com os recursos necessários para o mesmo
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			// Lendo linha a linha do arquivo
			String line = null;
			while ((line = br.readLine()) != null) {
				// Mostra o conteúdo da linha
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler arqvuio: " + e.getMessage());
		}

	}

}
