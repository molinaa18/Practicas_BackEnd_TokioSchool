package M1_11_Javier_Molina_Garcia;

public class Main {
	public static void main(String[] args) {
		Rectangulo r = new Rectangulo();
		System.out.println("Dado un rectángulo con base (" + r.base + ") y altura (" + r.altura + "):");
		System.out.println("Área: " + r.area());
		System.out.println("Perímetro: " + r.perimetro());
		System.out.println("¿Es cuadrado?: " + r.esCuadrado());

		r.gira();
		System.out.println("Después de girar: Base = " + r.base + ", Altura = " + r.altura);
	}
}
