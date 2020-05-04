package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		/**
		 * M�todo para copiar os elementos de uma lista para outra que pode ser de um
		 * tipo mais gen�rico que a primeira
		 */

		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjects = new ArrayList<Object>();

		copy(myInts, myObjects);
		copy(myDoubles, myObjects);
		
		printList(myObjects);

	}

	/**
	 * Permite copiar de qualquer tipo num�rico (extends Number - covari�ncia) para
	 * qualquer tipo mais gen�rico de Number (super Number - contravari�ncia)
	 * 
	 * @param source
	 * @param destiny
	 */
	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
	}

	/**
	 * Imprime uma lista de qualquer tipo
	 * 
	 * @param list
	 */
	public static void printList(List<?> list) {
		System.out.print("[");
		for (Object item : list) {
			System.out.print(item + " ");
		}
		System.out.println("]");
	}
}
