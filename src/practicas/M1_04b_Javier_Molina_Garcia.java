package practicas;

import java.io.IOException;

public class M1_04b_Javier_Molina_Garcia {

	public static void main(String[] args) throws IOException {
		int contadorEspacios = 0;
		char caracter;

		System.out.println("Introduce caracteres o frases completas. Escribe '.' para finalizar.");

		do {
			caracter = (char) System.in.read();

			if (caracter == ' ') {
				contadorEspacios++;
			}

		} while (caracter != '.');

		System.out.println("Número total de espacios: " + contadorEspacios);
	}
}
