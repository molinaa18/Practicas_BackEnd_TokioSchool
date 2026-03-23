package M1_18_Javier_Molina_Garcia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
        Scanner input = new Scanner(System.in);
        
        try {
        	System.out.print("Ingrese un valor double (positivo): ");
        	double numero = input.nextDouble();
        	
        	double ln = CalculosNumericos.logaritmoNeperiano(numero);
        	double raiz = CalculosNumericos.raizCuadrada(numero);
        	
        	System.out.println("ln(" + numero + ") = " + ln);
        	System.out.println("sqrt(" + numero + ") = " + raiz);
        	
        } catch (InputMismatchException e) {
        	System.out.println("Error: Debe ingresar un número válido (ejemplo: 10.5).");
        } catch (ArithmeticException e) {
        	System.out.println("Error aritmético: " + e.getMessage());
        } catch (Exception e) {
        	System.out.println("Error inesperado: " + e.getMessage());
        } finally {
        	input.close();
        }
	}
}