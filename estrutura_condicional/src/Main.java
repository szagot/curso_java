import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int horas;

		// IF
		System.out.println("Que horas são?");
		horas = sc.nextInt();

		if (horas < 12) {
			System.out.println("Bom dia!");
		} else if (horas < 18) {
			System.out.println("Boa tarde");
		} else {
			System.out.println("Boa noite");
		}

		// CASE
		int dia;
		String diaTexto;

		System.out.println("Digite o número do dia:");
		dia = sc.nextInt();

		switch (dia) {
		case 1:
			diaTexto = "domingo";
			break;
		case 2:
			diaTexto = "segunda-feira";
			break;
		case 3:
			diaTexto = "terça-feira";
			break;
		case 4:
			diaTexto = "quarta-feira";
			break;
		case 5:
			diaTexto = "quinta-feira";
			break;
		case 6:
			diaTexto = "sexta-feira";
			break;
		case 7:
			diaTexto = "sábado";
			break;
		default:
			diaTexto = "Valor Inválido";
		}

		System.out.println("Hoje é " + diaTexto);

		sc.close();

	}

}
