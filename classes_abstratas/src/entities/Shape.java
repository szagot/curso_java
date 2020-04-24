package entities;

import entities.enums.Color;

/**
 * Classes abstratas n�o podem ser instanciadas. Servem apenas de base para as
 * subclasses.
 */
public abstract class Shape {

	private Color color;

	public Shape() {
	}

	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * M�todos abstratos servem para garantir o polimorfismo, mas devem ser
	 * implementadas apenas nas subclasses
	 */
	public abstract double area();

}
