package com.ufpe.Escola.domain.util;

public class StringUtil {

	private StringUtil() {
		super();
	}

	
	public static boolean valorPreenchido(String valor) {

		return ((valor != null) && (valor.trim().length() != 0));

	}

	
	public static String valorNullRetornaVazio(String valor) {

		if (valor != null) {
			return valor.trim();
		}

		return "";
	}

	public static String completaStringCaracterEsquerda(String palavra,
			char caracter, int tamanho) {

		int count = tamanho - palavra.length();

		for (int i = 0; i < count; i++) {
			palavra = caracter + palavra;
		}
		return palavra;
	}

	public static String removePonto(String string) {

		String stringAux;

		stringAux = (string.contains(".") || string.contains(",")) ? string
				.replace(".", "") : string;

		return stringAux;
	}
}