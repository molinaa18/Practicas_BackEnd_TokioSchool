package practicas;

import java.util.Arrays;

public class M1_08_Javier_Molina_Garcia {

	public static void main(String[] args) {

		int[] arrayNum = new int[10];
		for (int i = 0; i < arrayNum.length; i++) {
			arrayNum[i] = (int) (Math.random() * 10);
		}
		System.out.println("Dado el siguiente array de 10 número aleatorios: " + Arrays.toString(arrayNum));
		System.out.println("Los números repetidos son: ");
		for (int i = 0; i < arrayNum.length; i++) {
			for (int j = i + 1; j < arrayNum.length; j++) {
				int pos1 = arrayNum[i];
				int pos2 = arrayNum[j];
				if (pos1 == pos2) {
					System.out.print(pos1 + " ");
					break;
				}
			}

		}
		System.out.println();
		System.out.println("Fin del programa");
	}

}
