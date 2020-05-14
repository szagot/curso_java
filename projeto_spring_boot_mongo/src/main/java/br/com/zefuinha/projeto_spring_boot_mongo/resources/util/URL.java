package br.com.zefuinha.projeto_spring_boot_mongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	/**
	 * Converte um texto em httpcode para texto comum
	 * 
	 * Exemplo: "bom%20dia" => "bom dia"
	 * 
	 * @param text
	 * @return
	 */
	public static String decodeParam(String text) {

		try {
			// Tenta decodificar do padrão httpcode para texto comum
			return URLDecoder.decode(text, "UTF-8");

		} catch (UnsupportedEncodingException e) {

			return "";

		}

	}
}
