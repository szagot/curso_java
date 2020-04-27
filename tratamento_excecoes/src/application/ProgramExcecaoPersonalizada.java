package application;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.ReservationExcepetion;

public class ProgramExcecaoPersonalizada {

	public static void main(String[] args) {

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

		try {

			// Número do quarto
			System.out.print("Número do quarto: ");
			int roomNumber = sc.nextInt();

			// Check-in
			System.out.print("Check-in (dd/MM/yyyy): ");
			Date checkIn = Reservation.dateMask.parse(sc.next());

			// Check-out
			System.out.print("Check-out (dd/MM/yyyy): ");
			Date checkOut = Reservation.dateMask.parse(sc.next());

			// Cria reserva
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

			// Atualiza reserva
			reservation.updateDate(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);

		}

		// Se for digitado um número inválido
		catch (InputMismatchException e) {
			System.out.println("Digite um número de quarto válido");
		}

		// Se houver um erro no formato da data informada
		catch (ParseException e) {
			System.out.println("Informe uma data válida");
		}
		
		// Capturando erros personalizados
		catch(ReservationExcepetion e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}

		sc.close();

	}

}
