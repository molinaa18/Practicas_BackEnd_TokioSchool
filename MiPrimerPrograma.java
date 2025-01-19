package principal;

import java.util.Scanner;

public class MiPrimerPrograma {

	public static void main(String[] args) {
		
	Scanner sca = new Scanner(System.in);
	
	System.out.println("Escribe una palabra");
	
	String cadena = sca.nextLine();
	
	System.out.println("Hola Mundo. La palabra es: "+cadena.toUpperCase());
	
	sca.close();
	}

}
