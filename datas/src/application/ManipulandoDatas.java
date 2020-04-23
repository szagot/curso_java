package application;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ManipulandoDatas {

	public static void main(String[] args) {

		// Iniciando formato de data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// For�ando fuso do servidor para S�o Paulo (para aplica��es,
		// melhor n�o fazer isso para deixar o padr�o da m�quina do usu�rio)
		sdf.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));

		// Iniciando data
		Date d1 = Date.from(Instant.parse("2020-04-24T12:50:05Z"));

		// Mostrando Data Instanciada
		System.out.println("Data original: " + sdf.format(d1));

		// -- Manipulando a data --
		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);

		// Adicionando 4 horas � data
		cal.add(Calendar.HOUR_OF_DAY, 4);
		Date d2 = cal.getTime();
		System.out.println("Data +4 horas: " + sdf.format(d2));

		// Obtendo os minutos e o m�s de uma data/hora
		int minutes = cal.get(Calendar.MINUTE);
		int month = 1 + cal.get(Calendar.MONTH); // Janeiro � o m�s 0, por isso tem de acrescentar 1
		System.out.println("Qtd Minutos..: " + minutes);
		System.out.println("Qual o m�s...: " + month);

	}

}
