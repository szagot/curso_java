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

		// Agora � permitido o tipo c�rculo pelo uso do caracter curinga delimitado para
		// Shapes
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		// N�o tem mais erro
		System.out.println("�rea Total: " + totalArea(myCircles));

	}

	/**
	 * Retorna a soma das �reas de uma figura
	 * 
	 * <?> Caracter curinga: aceita todo tipo de lista
	 * 
	 * <? extends Shape> Caracter curinga delimitado: aceita apenas tipos de lista
	 * que implementam Shape
	 * 
	 * Listas de tipos curinga s� podem ser acessadas, mas n�o alteradas
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
