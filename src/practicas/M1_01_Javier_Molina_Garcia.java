package practicas;

import java.util.Scanner;

public class M1_01_Javier_Molina_Garcia {

	public static void main(String[] args) {

		System.out.println("Este es un programa que calcula cuál sería el peso de un objeto en la luna.\n"
				+ "Introduzca a continuación el peso del objeto en cuestión:");
		Scanner teclado = new Scanner(System.in);
		double peso = teclado.nextDouble();
		System.out.println("El peso equivalente en la luna sería de " + calculadora(peso) + "kg");
		teclado.close();

	}

	public static double calculadora(double pesoObjeto) {
		return pesoObjeto / 100 * 17;
	}
}