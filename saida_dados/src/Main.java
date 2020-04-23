import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		String nome = "Daniel";
		
		System.out.print("Ol� " + nome + "! ");
		System.out.println("Bom dia!");
		
		// Imprindo um numero de ponto flutuante com 2 casas decimais
		double n = 10.35784;
		
		// O \n (ou %n) quebra a linha e o %.2f indica que haver� 2 casas decimais, arredondando
		System.out.printf("%.2f\n", n);
		System.out.printf("%.4f\n", n);
		
		// %f = float | %s = string | %d = integer
		int idade = 38;
		double renda = 1500.389;
		System.out.printf("%s tem %d anos e ganha R$%.2f de sal�rio\n", nome, idade, renda);		

		// ALterando a sa�da de dados para usar o padr�o americano
		Locale.setDefault(Locale.US);
		System.out.printf("Resultado = %.2f metros\n", n);
		
		// Se calcular dois numeros inteiros, o resultado corta as casas decimais. Use (double) para isso n�o ocorrer
		int a,b;
		double resultado;
		a = 5;
		b = 2;
		resultado = (double) a / b;
		System.out.println(resultado);
		
		// Ao converter um n�mero de double para inteiro, use (int) para for�ar a convers�o
		double x = 5.2;
		int y = 2;
		y = (int) x;
		System.out.println(y);
		
	}

}
