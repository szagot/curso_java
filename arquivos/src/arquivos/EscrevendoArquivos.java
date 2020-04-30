package arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrevendoArquivos {

	public static void main(String[] args) {

		// Iniciando um vetor para para as linhas do arquivo a ser criado
		String[] lines = new String[] { "Bom dia!", "Boa tarde!", "Boa noite!" };
		// Caminho do arquivo
		String path = "c:\\eclipse\\out.txt";

		// Inicia recursos
		// new FileWriter(file, true): Cria o arquivo se não existir, mas se existir,
		// coloca o ponteiro no final. new FileWriter(file) recria o arquivo se existir
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

			// Lê o vetor e grava linha a linha
			for (String line : lines) {
				bw.write(line);
				// Quebra a linha
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
