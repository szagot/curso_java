package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Finally {
	public static void main(String[] args) {
		
		// Preparando um arquivo
		File file = new File("C:\\eclipse\\in.txt");
		Scanner sc = null;
		try {
			// Tenta ler o arquivo
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} 

		// Erro de arquivo não encontrado
		catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		
		// Executa independentemente de se deu ou não erros
		finally {
			if (sc != null) {
				sc.close();
			}
			
			System.out.println("Finally executado!");
		}
		
		System.out.println("Fim do programa!");
	}
}