package practicas;

import java.text.DecimalFormat;

public class M1_06_Javier_Molina_Garcia {

	public static void main(String[] args) {

		int metro = 0;
		DecimalFormat format = new DecimalFormat("#.00");
		// Índice definido en 1 para evitar un salto de linea inicial, pues % de 0
		// aplicaría el if.
		// Formateado a #0.00 por motivos estéticos y de legibilidad.
		for (int i = 1; i < 145; i++) {
			System.out.println((metro += 1) + " metros = " + format.format(metro * 39.37) + " pulgadas");
			if (i % 12 == 0) {
				System.out.println();
			}

		}
	}
}
