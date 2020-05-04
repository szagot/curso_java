package services;

import java.util.List;

public class CalculationService {

	/**
	 * Calcula o máximo de uma lista
	 * Estende de Comparable para permitir o comparador de arquivos
	 * 
	 * List<?> é o super tipo de qualquer tipo de lista
	 * 
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		// A lista está vazia?
		if (list.isEmpty()) {
			throw new IllegalStateException("A lista não pode ser vazia");
		}

		// Procura pelo maior
		T max = list.get(0);
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}

		return max;
	}
}
