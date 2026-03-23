package M1_19_Javier_Molina_Garcia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido a la inscripción para el torneo de programación.");
		System.out.println("Por favor, introduzca un nombre de equipo:");
		String nombreEquipo = sc.nextLine();
		System.out.println("Por favor, introduzca la universidad representada:");
		String universidad = sc.nextLine();
		System.out.println("Por favor, introduzca el lenguaje de programación que van a utilizar:");
		String lenguajeProgramacion = sc.nextLine();
		
		List<Programador> lista = new ArrayList<>();
		int tamanoEquipo = 0;
		EquipoDeProgramadores equipoA = new EquipoDeProgramadores(nombreEquipo, universidad, lenguajeProgramacion, tamanoEquipo, lista);
		
		while (true) {
			System.out.println("¿Cuántos miembros tendrá el equipo?");
			tamanoEquipo = sc.nextInt();
			sc.nextLine();
			try {
				equipoA.validarTamanoEquipo(tamanoEquipo);
				break;
			} catch (IllegalStateException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		
		for (int i = 0; i < tamanoEquipo; i++) {
			Programador programador = new Programador();
			
			while (true) {
				System.out.println("Introduzca nombre del miembro " + (i + 1));
				String nombreProgramador = sc.nextLine();
				try {
					programador.validarNombre(nombreProgramador);
					break;
				} catch (IllegalArgumentException ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}
			
			while (true) {
				System.out.println("Introduzca apellidos del miembro " + (i + 1));
				String apellidosProgramador = sc.nextLine();
				try {
					programador.validarApellidos(apellidosProgramador);
					break;
				} catch (IllegalArgumentException ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}
			lista.add(programador);
		}
		
		System.out.println("La inscripción se ha completado con éxito. ¡Suerte en el torneo! :)");
		sc.close();
	}
}