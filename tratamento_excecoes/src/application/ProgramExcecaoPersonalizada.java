package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class ProgramExcecaoPersonalizada {

	public static void main(String[] args) throws ParseException {

		/**
		 * Fazer um programa para ler os dados de uma reserva de hotel (número do
		 * quarto, data de entrada e data de saída) e mostrar os dados da reserva,
		 * inclusive sua duração em dias. Em seguida, ler novas datas de entrada e
		 * saída, atualizar a reserva, e mostrar novamente a reserva com os dados
		 * atualizados. O programa não deve aceitar dados inválidos para a reserva,
		 * conforme as seguintes regras: - Alterações de reserva só podem ocorrer para
		 * datas futuras - A data de saída deve ser maior que a data de entrada
		 */

		Scanner sc = new Scanner(System.in);

		// Número do quarto
		System.out.print("Número do quarto: ");
		int roomNumber = sc.nextInt();

		// Check-in
		System.out.print("Check-in (dd/MM/yyyy): ");
		Date checkIn = Reservation.dateMask.parse(sc.next());

		// Check-out
		System.out.print("Check-out (dd/MM/yyyy): ");
		Date checkOut = Reservation.dateMask.parse(sc.next());

		// Fazendo as exceções por aqui (errado):
		// Se o check-out não for maior que o check-in
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data do check-out precisa ser posterior a data do check-in");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);

			// Atualização da reserva
			System.out.println("\n Entre com a atualização da reserva");

			// Check-in
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = Reservation.dateMask.parse(sc.next());

			// Check-out
			System.out.print("Check-out (dd/MM/yyyy): ");
			checkOut = Reservation.dateMask.parse(sc.next());

			// Analisando se as novas datas são posteriores a hoje
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na atualização da reserva: A datas devem ser futuras.");
			}

			// Verificando novamente!
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na atualização da reserva: A data do check-out precisa ser posterior a data do check-in");
			}

			// Atualiza reserva
			else {
				reservation.updateDate(checkIn, checkOut);
				System.out.println("Reserva: " + reservation);
			}

		}

		sc.close();

	}

}
