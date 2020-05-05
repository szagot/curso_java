package entities;

public class Product {
	private String name;
	private Double value;

	public Product(String name, Double value) {
		setName(name);
		setValue(value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isEmpty()) {
			name = "Nome Não Informado";
		}

		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(double value) {
		if (value < 0) {
			value = 0;
		}

		this.value = value;
	}

	@Override
	public String toString() {
		return "Product [name: " + name + ", value: R$ " + String.format("%.2f", value) + "]";
	}

}
