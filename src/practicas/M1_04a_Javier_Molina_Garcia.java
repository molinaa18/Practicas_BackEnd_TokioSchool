package practicas;

import java.util.Scanner;

public class M1_04a_Javier_Molina_Garcia {

	public static void main(String[] args) {

		System.out.println("Por favor, introduzca un texto de una o varias líneas, escribiendo '.' para finalizar: ");
		Scanner input = new Scanner(System.in);
		int espacios = 0;
		boolean hayPunto = false;
		// Se define "hayPunto" en "false".
		// Mientras sea false, el while seguirá ejecutándose,
		// de manera que el usuario podrá introducir tantas lineas como desee. 
		while (!hayPunto) {
			String texto = input.nextLine();
			for (int i = 0; i < texto.length(); i++) {
				if (texto.charAt(i) == ' ') {
					espacios += 1;
				}
				// Una vez haya un '.', el estado de hayPunto cambiará a true,
				// cerrando así el while.
				if (texto.charAt(i) == '.') {
					hayPunto = true;
				}
			}
		}
		input.close();
		System.out.println("El número de espacios del texto es = " + espacios);
	}

}
