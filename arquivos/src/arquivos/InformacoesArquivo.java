package arquivos;

import java.io.File;
import java.util.Scanner;

public class InformacoesArquivo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o caminho do arquivo: ");
		String strPath = sc.nextLine();

		File path = new File(strPath);

		// Pegando o nome do arquivo
		System.out.println("getName..: " + path.getName());

		// Pegando a pasta do arquivo
		System.out.println("getParent: " + path.getParent());

		// Pegando o caminho completo do arquivo
		System.out.println("getPath..: " + path.getPath());

		sc.close();
	}

}
