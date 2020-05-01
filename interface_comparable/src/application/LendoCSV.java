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
		 * Faça um programa para ler um arquivo contendo funcionários (nome e salário)
		 * no formato .csv, armazenando-os em uma lista. Depois, ordenar a lista por
		 * nome e mostrar o resultado na tela. Nota: o caminho do arquivo pode ser
		 * informado "hardcode".
		 */
		List<Employee> list = new ArrayList<>();
		String path = "C:\\eclipse\\salarios.txt";

		// Começa a leitura do arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String employee;
			while ((employee = br.readLine()) != null) {
				// Vetor com cada posição sendo um campo
				String[] fields = employee.split(",");

				// Adiciona cada linha à lista
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
			}

			// Isso não é aceito para ordenar a lista, pois não serve para uma lista com 2
			// campos. Para isso a classe precisa ser do tipo [Comparable] 
			Collections.sort(list);

			// Mostra a lista ordenada
			for (Employee s : list) {
				System.out.println("Nome: " + s.getName());
				System.out.println("Salário: " + String.format("%.2f", s.getSalary()));
				System.out.println();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
