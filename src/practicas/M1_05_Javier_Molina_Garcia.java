package practicas;

import java.util.Scanner;

public class M1_05_Javier_Molina_Garcia {

	public static void main(String[] args) {

		System.out.println("Por favor, introduce continuación un número: ");
		Scanner input = new Scanner(System.in);
		String userNum = input.nextLine();
		// Definido en String para facilitar el conteo de caracteres con length.
		int cifras = userNum.length();
		double suma = 0;
		for (int i = 0; i < cifras; i++) {
			// Cada ciclo del bucle recoge un caracter del input en "digito"
			int digito = userNum.charAt(i) - '0';
			// La variable "suma" va aumentando su valor, sumando el dígito/caracter elevado
			// al número de caracteres.
			suma += Math.pow(digito, cifras);
		}

		if (Double.parseDouble(userNum) == suma) {
			System.out.println("Es un número Armstrong.");
		} else {
			System.out.println("No es un número Armstrong.");
		}
		input.close();
	}

}
