package arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MostrandoArquivosBufferManual {

	public static void main(String[] args) {

		String path = "c:\\eclipse\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Estabelece uma sequencia de leitura (stream) a partir do arquivo
			fr = new FileReader(path);
			// Estabelece o stream com o buffer para deixar mais rápida a leitura
			br = new BufferedReader(fr);

			// Lendo linha a linha do arquivo
			String line = null;
			while ((line = br.readLine()) != null) {
				// Mostra o conteúdo da linha
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler arqvuio: " + e.getMessage());
		} finally {
			// Fecha streams
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
