package util;

public class Calculator {
	// O 'final' indica que se trata de uma constante
	public static final double PI = 3.14159;

	// Método estático para calculo de circunferência
	public static double circumference(double radius) {
		return 2.0 * PI * radius;
	}

	// Método estático para calculo de volume
	public static double volume(double radius) {
		return 4.0 * PI * Math.pow(radius, 3) / 3.0;
	}
}
