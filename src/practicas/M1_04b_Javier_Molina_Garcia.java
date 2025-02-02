package practicas;

import java.io.IOException;

public class M1_04b_Javier_Molina_Garcia {

	public static void main(String[] args) throws IOException {
		int contadorEspacios = 0;
		char caracter;

		System.out.println("Por favor, introduzca un texto de una o varias líneas, escribiendo '.' para finalizar: ");
		// Uso de do...while para asegurar que se ejecuta al menos una vez.
		do {
			// Cada ejecución actualiza la var "caracter" con el byte leído.
			caracter = (char) System.in.read();

			if (caracter == ' ') {
				contadorEspacios++;
			}
		// El bucle se sigue ejecutando siempre que el byte leído no sea '.'
		} while (caracter != '.');

		System.out.println("El número de espacios del texto es = " + contadorEspacios);
	}
}
