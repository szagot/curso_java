package application;

import java.util.ArrayList;
import java.util.List;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class Program {

	public static void main(String args[]) {

		/**
		 * Módulo para retornar a soma das áreas de uma lista de figuras
		 */

		List<Shape> myShapes = new ArrayList<>();
		myShapes.add(new Rectangle(3.0, 2.0));
		myShapes.add(new Circle(2.0));

		System.out.println("Área Total: " + totalArea(myShapes));

		// Se a minha lista for do tipo Círculo, haverá um erro com essa implementação,
		// mesmo ela sendo uma implementação de Figuras
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		// O erro será gerado nessa linha abaixo comentada
		// System.out.println("Área Total: " + totalArea(myCircles));

	}

	/**
	 * Retorna a soma das áreas de uma figura
	 * 
	 * @param list
	 * @return
	 */
	public static double totalArea(List<Shape> list) {
		double sum = 0.0;
		for (Shape s : list) {
			sum += s.area();
		}

		return sum;
	}

}
