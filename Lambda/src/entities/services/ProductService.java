package entities.services;

import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class ProductService {

	/**
	 * Faz a soma dos valores dos produtos conforme o crit�rio
	 * 
	 * @param list
	 * @param criteria
	 * @return
	 */
	public static Double filteredSum(List<Product> list, Predicate<Product> criteria) {
		Double sum = 0.0;
		for (Product p : list) {
			// Atinge o crit�rio do predicado?
			if (criteria.test(p)) {
				sum += p.getValue();
			}
		}

		return sum;
	}

}
