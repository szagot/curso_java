package application;

import java.util.ArrayList;
import java.util.List;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class Program {

	public static void main(String args[]) {

		/**
		 * M�dulo para retornar a soma das �reas de uma lista de figuras
		 */

		List<Shape> myShapes = new ArrayList<>();
		myShapes.add(new Rectangle(3.0, 2.0));
		myShapes.add(new Circle(2.0));

		System.out.println("�rea Total: " + totalArea(myShapes));

		// Se a minha lista for do tipo C�rculo, haver� um erro com essa implementa��o,
		// mesmo ela sendo uma implementa��o de Figuras
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		// O erro ser� gerado nessa linha abaixo comentada
		// System.out.println("�rea Total: " + totalArea(myCircles));

	}

	/**
	 * Retorna a soma das �reas de uma figura
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
