package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LendoTXT {

	public static void main(String[] args) {
		/**
		 * Faça um programa para ler um arquivo contendo nomes de pessoas (um nome por
		 * linha), armazenando-os em uma lista. Depois, ordenar os dados dessa lista e
		 * mostra-los ordenadamente na tela. Nota: o caminho do arquivo pode ser
		 * informado "hardcode".
		 */

		List<String> list = new ArrayList<>();
		String path = "C:\\eclipse\\nomes.txt";
		
		// Começa a leitura do arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String name;
			while ((name = br.readLine()) != null) {
				// Adiciona cada linha à lista
				list.add(name);
			}

			// Organiza a lista
			Collections.sort(list);
			
			// Mostra a lista ordenada
			for (String s : list) {
				System.out.println(s);
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
