package util;

public class Calculator {
	// O 'final' indica que se trata de uma constante
	public static final double PI = 3.14159;

	// M�todo est�tico para calculo de circunfer�ncia
	public static double circumference(double radius) {
		return 2.0 * PI * radius;
	}

	// M�todo est�tico para calculo de volume
	public static double volume(double radius) {
		return 4.0 * PI * Math.pow(radius, 3) / 3.0;
	}
}
