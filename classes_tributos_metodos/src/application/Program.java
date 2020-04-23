package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Triangle;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		Triangle x, y;

		x = new Triangle();
		y = new Triangle();

		System.out.println("Digite as medidas do tri�ngulo X:");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		System.out.println("Digite as medidas do tri�ngulo Y:");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();

		// Calculando �rea do triangulo
		double areaX = x.area();
		double areaY = y.area();
		
		System.out.printf("�rea do tri�ngulo X: %.4f\n", areaX);
		System.out.printf("�rea do tri�ngulo Y: %.4f\n", areaY);

		System.out.println("A �rea maior � a do tri�ngulo: " + (areaX > areaY ? "X" : "Y"));

		sc.close();

	}

}
