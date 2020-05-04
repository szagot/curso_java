package services;

import java.util.List;

public class CalculationService {

	/**
	 * Calcula o m�ximo de uma lista
	 * Estende de Comparable para permitir o comparador de arquivos
	 * 
	 * List<?> � o super tipo de qualquer tipo de lista
	 * 
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		// A lista est� vazia?
		if (list.isEmpty()) {
			throw new IllegalStateException("A lista n�o pode ser vazia");
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
