package practicas;

class Persona {

	String nombre;
	String apellido;
	String dni;
	int aNacimiento;
	
	public Persona(String nombre, String apellido, String dni, int aNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.aNacimiento = aNacimiento;
	}
	
	public void mostrarInfo() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("DNI: " + dni);
		System.out.println("Año de nacimiento: " + aNacimiento);
	}
}

public class M1_10_Javier_Molina_Garcia {

	public static void main(String[] args) {
		Persona persona1 = new Persona("Manuel", "García", "12345678A", 1990);
		Persona persona2 = new Persona("María", "Pérez", "87654321Z", 1995);

		persona1.mostrarInfo();
		System.out.println("----");
		persona2.mostrarInfo();

	}

}
