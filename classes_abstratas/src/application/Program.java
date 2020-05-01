package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.AbstractShape;
import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<AbstractShape> shapes = new ArrayList<>();

		System.out.print("Entre o número de figuras: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.printf("Dados da figura #%d\n", i);
			System.out.print("Retângulo ou Circulo(r/c)? ");
			char ch = sc.next().charAt(0);

			System.out.print("Cor (PRETO/AZUL/VERMELHO): ");
			Color color = Color.valueOf(sc.next());

			if (ch == 'r') {
				System.out.print("Largura: ");
				double width = sc.nextDouble();
				System.out.print("Altura: ");
				double height = sc.nextDouble();

				shapes.add(new Rectangle(color, width, height));
			} else {
				System.out.print("Raio: ");
				double radius = sc.nextDouble();

				shapes.add(new Circle(color, radius));
			}
		}

		System.out.println("----------------");

		System.out.println("Áreas das Figuras");
		for (AbstractShape shape : shapes) {
			System.out.print(((shape instanceof Circle) ? "Círculo" : "Retângulo") + " (cor " + shape.getColor() + "): ");
			System.out.println(String.format("%.2f", ((Shape) shape).area()));
		}

		sc.close();

	}

}
