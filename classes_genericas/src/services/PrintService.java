package services;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Uma classe do tipo Generics permite determinar um tipo de objeto padr�o a ser
 * usado na classe. Semelhante ao que � feito em listas
 *
 * @param <Type>
 */
public class PrintService<Type> {
	private List<Type> list = new ArrayList<>();

	/**
	 * Adiciona um item do tipo gen�rico
	 * 
	 * @param value
	 */
	public void addValue(Type value) {
		list.add(value);
	}

	/**
	 * Imprime a lista
	 * 
	 * @return
	 */
	public void print() {
		if (list.isEmpty()) {
			System.out.println("[]");
		}

		String texto = "[ " + first();

		if (list.size() > 1) {
			for (int i = 1; i < list.size(); i++) {
				texto += ", " + list.get(i);
			}
		}

		System.out.println(texto + " ]");
	}

	/**
	 * Devolve o primeiro item do tipo gen�rico
	 * 
	 * @return
	 */
	public Type first() {
		if (list.isEmpty()) {
			throw new InvalidParameterException("A lista est� vazia");
		}

		return list.get(0);
	}
}
