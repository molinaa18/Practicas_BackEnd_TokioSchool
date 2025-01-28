package practicas;

import java.util.Scanner;

public class M1_04a_Javier_Molina_Garcia {

	public static void main(String[] args) {

		System.out.println("Por favor, introduzca un texto de una o varias líneas, escribiendo '.' para finalizar: ");
		Scanner input = new Scanner(System.in);
		int espacios = 0;
		boolean hayPunto = false;

		while (!hayPunto) {
			String frase = input.nextLine();
			for (int i = 0; i < frase.length(); i++) {
				if (frase.charAt(i) == ' ') {
					espacios += 1;
				}
				if (frase.charAt(i) == '.') {
					hayPunto = true;
				}
			}
		}
		input.close();
		System.out.println("El número de espacios de la frase es = " + espacios);
	}

}
