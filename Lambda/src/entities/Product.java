package entities;

import javax.naming.directory.InvalidAttributesException;

public class Product {
	private String name;
	private Double value;

	public Product(String name, Double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
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
