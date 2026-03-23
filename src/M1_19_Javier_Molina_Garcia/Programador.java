package M1_19_Javier_Molina_Garcia;

public class Programador {
	private String nombre;
	private String apellidos;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public Programador() {
	}

	public void validarNombre(String input) {
		if (input.length() >= 20) {
			throw new IllegalArgumentException("El campo no puede incluir 20 o más caracteres.");
		}
		if (input.matches(".*\\d.*")) {
			throw new IllegalArgumentException("El campo no puede incluir números.");
		}
		setNombre(input);
	}

	public void validarApellidos(String input) {
		if (input.length() >= 20) {
			throw new IllegalArgumentException("El campo no puede incluir 20 o más caracteres.");
		}
		if (input.matches(".*\\d.*")) {
			throw new IllegalArgumentException("El campo no puede incluir números.");
		}
		setApellidos(input);
	}
}