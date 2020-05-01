package entities;

import entities.enums.Color;

/**
 * Classes abstratas não podem ser instanciadas. Servem apenas de base para as
 * subclasses.
 */
public abstract class AbstractShape {

	private Color color;

	public AbstractShape() {
	}

	public AbstractShape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
