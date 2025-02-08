package practicas;

import java.util.Arrays;
import java.util.Scanner;

public class M1_07_Javier_Molina_Garcia {

	public static void main(String[] args) {

		System.out.println("¿Cuántos cupones has obtenido?");
		Scanner userInput = new Scanner(System.in);
		int cuponesObtenidos = userInput.nextInt();
		System.out.println(Arrays.toString(candyCalculator(cuponesObtenidos)));
		userInput.close();

	}

	public static int[] candyCalculator(int nCupones) {
		int barrasCaramelo = nCupones / 10;
		int chicles = ((nCupones % 10) / 3);
		int cuponesRestantes = ((nCupones % 10) % 3);
		int[] resultado = new int[3];
		resultado[0] = barrasCaramelo;
		resultado[1] = chicles;
		resultado[2] = cuponesRestantes;

		return resultado;
	}

}
