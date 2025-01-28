package practicas;

import java.util.Scanner;

public class M1_03_Javier_Molina_Garcia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Por favor, introduzca la nota de Matemáticas: ");
		Scanner inputDouble = new Scanner(System.in);
		double matematicas = inputDouble.nextDouble();
		System.out.println("Por favor, introduzca la nota de Física: ");
		double fisica = inputDouble.nextDouble();
		System.out.println("Por favor, introduzca la nota de Química: ");
		double quimica = inputDouble.nextDouble();
		System.out.println("Por favor, introduzca la nota de Lenguaje: ");
		double lenguaje = inputDouble.nextDouble();
		System.out.println("Por favor, introduzca la nota de Historia: ");
		double historia = inputDouble.nextDouble();

		double media = media(matematicas, fisica, quimica, lenguaje, historia);

		if (media < 3) {
			System.out.println("La nota final es: Muy Deficiente (" + media + ")");
		} else if (media < 5) {
			System.out.println("La nota final es: Insuficiente (" + media + ")");
		} else if (media < 6) {
			System.out.println("La nota final es: Suficiente (" + media + ")");
		} else if (media < 7) {
			System.out.println("La nota final es: Bien (" + media + ")");
		} else if (media < 9) {
			System.out.println("La nota final es: Notable (" + media + ")");
		} else if (media <= 10) {
			System.out.println("La nota final es: Sobresaliente (" + media + ")");
		}

		inputDouble.close();

	}

	public static double media(double mat, double fis, double qui, double len, double his) {
		return (mat + fis + qui + len + his) / 5;
	}

}
