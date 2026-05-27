package M1_10_Javier_Molina_Garcia;

public class Main {

	public static void main(String[] args) {
		Persona persona1 = new Persona("Manuel", "García", "12345678A", 1990);
		Persona persona2 = new Persona("María", "Pérez", "87654321Z", 1995);

		persona1.mostrarInfo();
		System.out.println("----");
		persona2.mostrarInfo();

	}

}
