package M1_13_Javier_Molina_Garcia;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CuentaBancaria miCuenta = new CuentaBancaria(0f, 0.06f);
		
		miCuenta.ingresar(1000);
		miCuenta.retirar(2000);
		miCuenta.retirar(450);
		miCuenta.extractoMensual();
		miCuenta.imprimir();
		
		System.out.println("....................................");
		
		CuentaAhorro miCuentaAhorro = new CuentaAhorro(500f, 0.12f);
		
		
		miCuentaAhorro.ingresar(1000);
		miCuentaAhorro.retirar(75);
		miCuentaAhorro.retirar(300);
		miCuentaAhorro.retirar(75);
		miCuentaAhorro.retirar(650);
		miCuentaAhorro.retirar(75);
		miCuentaAhorro.retirar(100);
		miCuentaAhorro.retirar(175);
		miCuentaAhorro.ingresar(5000);
		miCuentaAhorro.ingresar(3000);
		miCuentaAhorro.retirar(650);


		miCuentaAhorro.extractoMensual();
		miCuentaAhorro.imprimir();
		
		System.out.println("....................................");

		CuentaCorriente miCuentaCorriente = new CuentaCorriente (100f, 0.6f);
		
		miCuentaCorriente.ingresar(200);
		miCuentaCorriente.retirar(50);
		miCuentaCorriente.retirar(450);
		miCuentaCorriente.ingresar(50);
		miCuentaCorriente.retirar(450);
		miCuentaCorriente.ingresar(500);
		miCuentaCorriente.retirar(450);
		miCuentaCorriente.ingresar(50);
		miCuentaCorriente.ingresar(700);
		miCuentaCorriente.extractoMensual();
		miCuentaCorriente.imprimir();
		
	}

}
