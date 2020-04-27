package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public static SimpleDateFormat dateMask = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	/**
	 * Diferen�a em dias entre duas datas
	 * 
	 * @return
	 */
	public long duration() {
		// Pega a diferen�a das datas em milissegundos
		long diff = checkOut.getTime() - checkIn.getTime();

		// Convertendo os milissegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	/**
	 * M�todo para atualiza��o de datas
	 * 
	 * @param checkIn
	 * @param checkOut
	 */
	public void updateDate(Date checkIn, Date checkOut) {
		// Analisando se as novas datas s�o posteriores a hoje
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			// Lan�ando uma exce��o para o tipo de exce��o: Argumentos inv�lidos
			throw new IllegalArgumentException("As datas devem ser futuras.");
		}

		// Verificando se a data da check-in � < check-out
		if (!checkOut.after(checkIn)) {
			throw new IllegalArgumentException("A data do check-out precisa ser posterior a data do check-in");
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Quarto " + roomNumber + ", Check-in: " + dateMask.format(checkIn) + ", Check-out: "
				+ dateMask.format(checkOut) + ", " + duration() + " noites";
	}

}
