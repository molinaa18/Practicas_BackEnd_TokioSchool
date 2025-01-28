package practicas;

import java.util.Scanner;

public class M1_02_Javier_Molina_Garcia {

	public static void main(String[] args) {

		System.out.println("Por favor, introduzca tres números enteros: ");
		Scanner inputInt = new Scanner(System.in);
		int a = inputInt.nextInt();
		int b = inputInt.nextInt();
		int c = inputInt.nextInt();
		System.out.println(a * b / c);
		System.out.println((a * c) % b);
		System.out.println(2 * (a + c - b) / (b * c));
		System.out.println(((a * c) + (b % a)) / a - c);

		System.out.println("Por favor, introduzca tres números con decimales: ");
		Scanner inputDouble = new Scanner(System.in);
		double x = inputDouble.nextDouble();
		double y = inputDouble.nextDouble();
		double z = inputDouble.nextDouble();
		System.out.println(x * y / z);
		System.out.println((x * z) % y);
		System.out.println(2 * (x + z - y) / (y * z));
		System.out.println(((x * z) + (y % x)) / x - z);
		inputInt.close();
		inputDouble.close();

	}

}