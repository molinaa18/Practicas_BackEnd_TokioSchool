package M1_19_Javier_Molina_Garcia;

import java.util.ArrayList;
import java.util.List;

public class EquipoDeProgramadores {
	private String nombreEquipo;
	private String universidad;
	private String lenguajeProgramacion;
	private int tamanoEquipo;
	private List<Programador> listaProgramadores;

	public EquipoDeProgramadores(String nombreEquipo, String universidad, String lenguajeProgramacion, int tamanoEquipo, List<Programador> listaProgramadores) {
		this.nombreEquipo = nombreEquipo;
		this.universidad = universidad;
		this.lenguajeProgramacion = lenguajeProgramacion;
		this.tamanoEquipo = tamanoEquipo;
		this.listaProgramadores = listaProgramadores;
	}

	public void validarTamanoEquipo(int t) {
		if (t >= 4) {
			throw new IllegalStateException("El equipo no puede tener más de 3 miembros.");
		}
	}
}