package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Exemplos {

	public static void main(String[] args) throws ParseException {

		// Formatos de datas
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		// Formato de data para outro fuso horário (UTC)
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		// Iniciando uma data com dia/horário atual
		Date x1 = new Date();
		// ou
		Date x2 = new Date(System.currentTimeMillis());
		
		// Iniciando uma data específica usando o formato pré definido
		Date y1 = sdf1.parse("20/05/2020");
		Date y2 = sdf2.parse("25/06/2020 15:42:07");
		
		// Iniciando data no formato padrão ISO 8601 (o Z indica horário UTC - 0)
		Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		// Imprimindo as datas no formato padrão
		System.out.println("x1: " + x1);
		System.out.println("x2: " + x2);
		System.out.println("y1: " + y1);
		System.out.println("y2: " + y2);
		System.out.println("y3: " + y3);

		// Imprimindo as datas no formato escolhido
		System.out.println("--------------------");
		System.out.println("x1: " + sdf2.format(x1));
		System.out.println("x2: " + sdf2.format(x2));
		System.out.println("y1: " + sdf2.format(y1));
		System.out.println("y2: " + sdf2.format(y2));
		System.out.println("y3: " + sdf2.format(y3));

		// Imprimindo as datas no formato escolhido, porém no fuso UTC
		System.out.println("--------------------");
		System.out.println("x1: " + sdf3.format(x1));
		System.out.println("x2: " + sdf3.format(x2));
		System.out.println("y1: " + sdf3.format(y1));
		System.out.println("y2: " + sdf3.format(y2));
		System.out.println("y3: " + sdf3.format(y3));

	}

}
