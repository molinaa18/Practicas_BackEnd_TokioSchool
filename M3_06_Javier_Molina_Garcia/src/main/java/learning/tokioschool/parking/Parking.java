package learning.tokioschool.parking;

import learning.tokioschool.parking.db.ManagerDbImplement;
import java.util.Map;

public class Parking {

	// Cambiamos el Map en memoria por nuestro gestor de base de datos
	private final ManagerDbImplement db;

	public Parking() {
		db = new ManagerDbImplement();
		// Al instanciar el Parking, nos aseguramos de que la tabla exista
		try {
			db.crearTabla();
		} catch (Exception e) {
			System.err.println("Error crítico al inicializar la base de datos: " + e.getMessage());
		}
	}

	/**
	 * Metodo que comprueba si existe un coche en el sistema
	 *
	 * @param matricula
	 * @return
	 */
	public boolean existeCoche(final String matricula) {
		// Si la búsqueda devuelve distinto de null, es que existe
		return db.search(matricula) != null;
	}

	/**
	 * Metodo que obtiene un coche del sistema
	 *
	 * @param matricula
	 * @return
	 */
	public Coche getCoche(final String matricula) {
		return db.search(matricula);
	}

	/**
	 * Metodo que añade un coche al sistema
	 *
	 * @param matricula
	 * @param coche
	 */
	public void putCoche(final String matricula, final Coche coche) {
		db.insert(matricula, coche);
	}

	/**
	 * Método extra (opcional pero recomendado)
	 * En un Map, si cambiabas la hora del coche en memoria, se actualizaba solo.
	 * En una BD, necesitas llamar explícitamente al UPDATE cuando el coche salga.
	 */
	public void registrarSalidaCoche(final String matricula, java.time.LocalDateTime horaSalida) {
		db.update(matricula, horaSalida);
	}

	/**
	 * Metodo que imprime todos los coches del sistema, tanto los que estan dentro del parking como los que no.
	 */
	public void imprimirCochesSistema() {
		try {
			// Recuperamos el mapa desde la BD y luego lo iteramos
			Map<String, Coche> todosLosCoches = db.searchAll();
			todosLosCoches.forEach((k, v) -> {
				System.out.println("Matricula: " + k + " Datos del " + v);
			});
		} catch (Exception ex) {
			System.out.println("Error al imprimir coches en el sistema");
		}
	}

	/**
	 * Metodo que imprime los coches que estan dentro del parking (horaSalida = null)
	 */
	public void imprimirCochesParking() {
		try {
			// Usamos directamente el método que filtra en la base de datos
			Map<String, Coche> cochesDentro = db.searchAllFilterHoraSalida();
			cochesDentro.forEach((k, v) -> {
				System.out.println("Matricula: " + k + " Datos del " + v);
			});
		} catch (Exception ex) {
			System.out.println("Error al imprimir coches en el parking");
		}
	}

	/**
	 * Método que calcula la cantidad a pagar por un coche según el tiempo que ha estado dentro del parking
	 * @param matricula
	 */
	public void cantidadAPagar(final String matricula) {
		if (matricula != null) {
			Coche coche = db.search(matricula);
			if (coche != null && coche.getHoraSalida() != null) {
				System.out.println("Cantidad a pagar " + coche.cantidadAPagar());
			} else {
				System.out.println("El coche no existe o aún no ha registrado su hora de salida.");
			}
		}
	}
}