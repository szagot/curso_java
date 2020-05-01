package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import application.csv.Employee;

public class LendoCSV {

	public static void main(String[] args) {
		/**
		 * Fa�a um programa para ler um arquivo contendo funcion�rios (nome e sal�rio)
		 * no formato .csv, armazenando-os em uma lista. Depois, ordenar a lista por
		 * nome e mostrar o resultado na tela. Nota: o caminho do arquivo pode ser
		 * informado "hardcode".
		 */
		List<Employee> list = new ArrayList<>();
		String path = "C:\\eclipse\\salarios.txt";

		// Come�a a leitura do arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String employee;
			while ((employee = br.readLine()) != null) {
				// Vetor com cada posi��o sendo um campo
				String[] fields = employee.split(",");

				// Adiciona cada linha � lista
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
			}

			// Isso n�o � aceito para ordenar a lista, pois n�o serve para uma lista com 2
			// campos. Para isso a classe precisa ser do tipo [Comparable] 
			Collections.sort(list);

			// Mostra a lista ordenada
			for (Employee s : list) {
				System.out.println("Nome: " + s.getName());
				System.out.println("Sal�rio: " + String.format("%.2f", s.getSalary()));
				System.out.println();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
