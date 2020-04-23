import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		String nome = "Daniel";
		
		System.out.print("Olá " + nome + "! ");
		System.out.println("Bom dia!");
		
		// Imprindo um numero de ponto flutuante com 2 casas decimais
		double n = 10.35784;
		
		// O \n (ou %n) quebra a linha e o %.2f indica que haverá 2 casas decimais, arredondando
		System.out.printf("%.2f\n", n);
		System.out.printf("%.4f\n", n);
		
		// %f = float | %s = string | %d = integer
		int idade = 38;
		double renda = 1500.389;
		System.out.printf("%s tem %d anos e ganha R$%.2f de salário\n", nome, idade, renda);		

		// ALterando a saída de dados para usar o padrão americano
		Locale.setDefault(Locale.US);
		System.out.printf("Resultado = %.2f metros\n", n);
		
		// Se calcular dois numeros inteiros, o resultado corta as casas decimais. Use (double) para isso não ocorrer
		int a,b;
		double resultado;
		a = 5;
		b = 2;
		resultado = (double) a / b;
		System.out.println(resultado);
		
		// Ao converter um número de double para inteiro, use (int) para forçar a conversão
		double x = 5.2;
		int y = 2;
		y = (int) x;
		System.out.println(y);
		
	}

}
