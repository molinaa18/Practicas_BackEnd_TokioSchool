package practicas;

import java.util.Scanner;

public class M1_09_Javier_Molina_Garcia {

	public static void main(String[] args) {
		int numVocales = 0;
		System.out.println("Por favor, introduce una frase: ");
		Scanner input = new Scanner(System.in);
		String texto = input.nextLine();
		for (int i = 0; i < texto.length(); i++) {
			char caracter = texto.charAt(i);
			if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'
					|| caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U') {
				numVocales += 1;
			}
		}
		input.close();
		System.out.println("El número de vocales de la frase es: " + numVocales);
	}
}
