package application.csv;

/**
 * Exemplo de classe que implementa uma interface do tipo Comparable
 */
public class Employee implements Comparable<Employee> {

	private String name;
	private Double salary;

	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * Método padrão para fazer a comparação de um objeto com outro
	 * 
	 * @return int negativo para < | 0 para = | int positivo para >
	 */
	@Override
	public int compareTo(Employee other) {
		// Define que o que deve ser comparado é o nome. Para colocar em ordem
		// decrescente, coloque um "-"na frente
		return -name.compareTo(other.getName());
	}

}
