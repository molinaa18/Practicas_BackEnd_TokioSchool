package practicas;

class Rectangulo {
	int base;
	int altura;

	public Rectangulo(int b, int h) {
		this.base = Math.abs(b);
		this.altura = Math.abs(h);
	}

	public Rectangulo() {
		this(2, 1);
	}

	public boolean esCuadrado() {
		return base == altura;
	}

	public int area() {
		return base * altura;
	}

	public int perimetro() {
		return 2 * (base + altura);
	}

	public void gira() {
		int baseCopia = base;
		base = altura;
		altura = baseCopia;
	}
}

public class M1_11_Javier_Molina_Garcia {
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
