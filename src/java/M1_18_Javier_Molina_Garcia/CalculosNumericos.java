package M1_18_Javier_Molina_Garcia;


public class CalculosNumericos {

    
	public static double logaritmoNeperiano(double valor) {
		if (valor <= 0) {
			throw new ArithmeticException("El valor debe ser positivo para calcular ln(valor).");
		}
		return Math.log(valor);
	}
	
	public static double raizCuadrada(double valor) {
		if (valor <= 0) {
			throw new ArithmeticException("El valor debe ser positivo para calcular sqrt(valor).");
		}
		return Math.sqrt(valor);
	}
}