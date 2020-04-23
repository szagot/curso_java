package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		/**
		 * Proposta: Ler os dados de um trabalhador com N contratos (N fornecido pelo
		 * usuário). Depois, solicitar do usuário um mês e mostrar qual foi o salário do
		 * funcionário nesse mês
		 */

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");

		System.out.print("Departamento: ");
		String dept = sc.nextLine();

		System.out.println("");
		System.out.println("--------------------");
		System.out.println("Dados do Trabalhador");
		System.out.println("--------------------");

		System.out.print("Nome: ");
		String name = sc.nextLine();

		System.out.print("Level (JUNIOR, MID_LEVEL, SENIOR): ");
		String level = sc.nextLine();

		System.out.print("Salário Base: $ ");
		Double baseSalary = sc.nextDouble();

		// Instanciando trabalhador
		Worker worker = new Worker(
				// Nome do trabalhador
				name,
				// Level do trabalhador
				WorkerLevel.valueOf(level),
				// Salário de base
				baseSalary,
				// Departamento
				new Department(dept));

		// Verificando contratos
		System.out.print("Esse trabalhador possui contratos? (s/n): ");
		char isContinue = sc.next().charAt(0);
		int contractNum = 0;

		while (isContinue == 'S' || isContinue == 's') {
			contractNum++;
			System.out.println("--------------------");
			System.out.println("Dados do contrato #" + contractNum);

			// Data
			System.out.print("Data (dd/mm/yyyy): ");
			Date contractDate = sdf1.parse(sc.next());

			// Valor por hora
			System.out.print("Valor por Hora: $ ");
			double valuePerHour = sc.nextDouble();

			// Duração
			System.out.print("Horas do contrato: ");
			int hours = sc.nextInt();

			// Adicionando contrato
			worker.addContract(new HourContract(contractDate, valuePerHour, hours));

			System.out.println("--------------------");
			System.out.print("Tem mais contratos? (s/n): ");
			isContinue = sc.next().charAt(0);
		}

		System.out.println("--------------------");
		System.out.print("Entre com o mês que deseja calcular o salário do trabalhador (mm/yyyy): ");
		Date calculateDate = sdf2.parse(sc.next());
		Calendar cal = Calendar.getInstance();
		cal.setTime(calculateDate);

		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.printf("Salário para o mês %s: $ %.2f", sdf2.format(calculateDate),
				worker.income(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)));

		sc.close();

	}

}
