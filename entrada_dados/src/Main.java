import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Para fazer entrada de dados, usa-se o objeto Scanner

		// System.in � o teclado no console
		Scanner sc = new Scanner(System.in);
		String x, nome, sobrenome, texto1, texto2, texto3;
		int n;
		double p;
		char c;

		// O .next() permite que o usu�rio digite uma string que ser� armazenado na
		// vari�vel
		System.out.print("Digite algo: ");
		x = sc.next();
		System.out.println("Voc� digitou " + x);

		// O .nextInt() permite a entrada de valores inteiros
		System.out.print("Digite um numero: ");
		n = sc.nextInt();
		System.out.println("Voc� digitou o numero " + n);

		// O .nextDouble() permite a entrada de valores de ponto flutuante (padr�o do
		// sistema). Para usar o "." no terminal como separador de decimal, use antes:
		// Locale.setDefault(Locale.US)
		System.out.print("Digite um numero: ");
		p = sc.nextDouble();
		System.out.printf("Voc� digitou o numero %.2f \n", p);

		// Para pegar apenas um caracter, use o .charAt(0), que pega o 1o caracter da
		// string
		System.out.print("Digite algo: ");
		c = sc.next().charAt(0);
		System.out.println("Voc� digitou " + c);

		// Para ler v�rios dados na mesma linha separados por espa�o, apenas use o next
		// apropriado
		System.out.print("Digite o nome e o sobrenome: ");
		nome = sc.next();
		sobrenome = sc.next();
		System.out.println("Voc� digitou: ");
		System.out.println(nome);
		System.out.println(sobrenome);

		// Para ler um texto at� a quebra de linha, use .nextLine(). Se houverem outras
		// entradas anteriores, use um .nextLine() em branco para consumir a quebra de
		// linha j� usada
		System.out.println("Digite 3 linhas de texto: ");
		sc.nextLine(); // Limpa o buffer de leitura (pq antes teve outros dados entrados)
		texto1 = sc.nextLine();
		texto2 = sc.nextLine();
		texto3 = sc.nextLine();
		System.out.println("Voc� digitou:");
		System.out.println(texto1);
		System.out.println(texto2);
		System.out.println(texto3);

		// � necess�rio finalizar
		sc.close();

	}

}
