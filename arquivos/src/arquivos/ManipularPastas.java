package arquivos;

import java.io.File;
import java.util.Scanner;

public class ManipularPastas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o caminho da pasta: ");
		String strPath = sc.nextLine();
		System.out.println();

		// Pode ser tanto o caminho de um arquivo como de uma pasta
		File path = new File(strPath);

		// Cria um vetor com todas as pastas que est�o dentro do path informado
		File[] folders = path.listFiles(File::isDirectory);

		// L� o vetor de pastas
		System.out.println("Conte�do da pasta " + strPath);
		System.out.println("----------------------------");
		for (File folder : folders) {
			System.out.println("+ " + folder.getName());
		}

		// Faz o mesmo para arquivos
		File[] files = path.listFiles(File::isFile);
		for (File file : files) {
			System.out.println(" " + file.getName());
		}
		
		System.out.println();

		// Criando um subdiret�rio
		boolean success = new File(strPath + "\\diretorio_teste").mkdir();
		System.out.println(success ? "Diret�rio criado com sucesso" : "Diret�rio n�o criado");

		sc.close();
	}

}
