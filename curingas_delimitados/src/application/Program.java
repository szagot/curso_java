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

		// Agora é permitido o tipo círculo pelo uso do caracter curinga delimitado para
		// Shapes
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		// Não tem mais erro
		System.out.println("Área Total: " + totalArea(myCircles));

	}

	/**
	 * Retorna a soma das áreas de uma figura
	 * 
	 * <?> Caracter curinga: aceita todo tipo de lista
	 * 
	 * <? extends Shape> Caracter curinga delimitado: aceita apenas tipos de lista
	 * que implementam Shape
	 * 
	 * Listas de tipos curinga só podem ser acessadas, mas não alteradas
	 * 
	 * @param list
	 * @return
	 */
	public static double totalArea(List<? extends Shape> list) {
		double sum = 0.0;
		for (Shape s : list) {
			sum += s.area();
		}

		return sum;
	}

}
