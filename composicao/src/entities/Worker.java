package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	/**
	 * Adiciona um contrato à lista
	 * 
	 * @param contract
	 */
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	/**
	 * Remove um contrato da lista
	 * 
	 * @param contract
	 */
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	/**
	 * Calcula o valor ganho por um trabalhador em um determinado mês
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public double income(int year, int month) {
		// Inicia a soma com o salário de base do trabalhador
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();

		// Pega os valores ganhos nos contratos daquele mês
		for (HourContract contract : contracts) {
			// Define a data do calendário
			cal.setTime(contract.getDate());

			// O ano e o mês do calendário é o mesmo dos definidos no método?
			if (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month) {
				sum += contract.totalValue();
			}
		}

		return sum;
	}

}
