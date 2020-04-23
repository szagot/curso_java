import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x, soma = 0;

		// Enquanto o x não for zero, ele soma e continua
		System.out.println("Vá digitando os números a serem somados. Digite 0 para parar.");
		while ((x = sc.nextInt()) != 0) {
			soma += x;
		}

		System.out.println(soma);

		// Repetir N vezes a soma
		soma = 0;
		System.out.print("Digite quantos números você quer somar:");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			soma += sc.nextInt();
		}

		System.out.println(soma);

		sc.close();
		
		// Sintaxe do faça enquanto: 
		// do { comandos } while( condicao );

	}

}
