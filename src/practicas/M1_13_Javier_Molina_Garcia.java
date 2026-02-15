package practicas;

class CuentaBancaria {
	protected float saldo;
	protected int numIngresos = 0;
	protected int numRetiros = 0;
	protected float tasaAnual;
	protected float comisionMensual = 0;
	
	/**Constructor*/
	public CuentaBancaria(float saldo, float tasaAnual) {
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
	}
	
	
	/**Getters&Setters*/
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public int getNumIngresos() {
		return numIngresos;
	}
	public void setNumIngresos(int numIngresos) {
		this.numIngresos = numIngresos;
	}
	public int getNumRetiros() {
		return numRetiros;
	}
	public void setNumRetiros(int numRetiros) {
		this.numRetiros = numRetiros;
	}
	public float getTasaAnual() {
		return tasaAnual;
	}
	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}
	public float getComisionMensual() {
		return comisionMensual;
	}
	public void setComisionMensual(float comisionMensual) {
		this.comisionMensual = comisionMensual;
	}

	
	
	public void ingresar(float cantidad) {
		saldo += cantidad;
		numIngresos++;
	    }

	public void retirar(float cantidad) {
		if (cantidad > saldo) {
			System.out.println("No dispone de saldo suficiente.");
			return;
		}
		saldo -= cantidad;
		numRetiros++;
	}
	    
	public void calcIntMensual() {
		float tasaMensual = tasaAnual / 12f;
		saldo += Math.round((saldo * tasaMensual)*100f)/100f;
	}

	public void extractoMensual() {
		saldo -= comisionMensual;
		calcIntMensual();
	}

	public void imprimir() {
		System.out.println("Saldo: " + saldo);
		System.out.println("Ingresos realizados: " + numIngresos);
		System.out.println("Retiros realizados: " + numRetiros);
		System.out.println("Tasa anual: " + tasaAnual);
		System.out.println("Comisión mensual: " + comisionMensual);
	}
	
}


class CuentaAhorro extends CuentaBancaria {

	private boolean cuentaActiva;

    public CuentaAhorro(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        actualizarEstado();
    }

    private void actualizarEstado() {
        cuentaActiva = saldo >= 100;
    }

    @Override
    public void ingresar(float cantidad) {
        if (cuentaActiva) {
            super.ingresar(cantidad);
        } else {
            System.out.println("Cuenta inactiva. No se pueden hacer ingresos.");
        }
        actualizarEstado();
    }

    @Override
    public void retirar(float cantidad) {
        if (cuentaActiva) {
            super.retirar(cantidad);
        } else {
            System.out.println("Cuenta inactiva. No se pueden hacer retiros.");
        }
        actualizarEstado();
    }

    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1.5;
        }

        super.extractoMensual();
        actualizarEstado();

        System.out.println("¿Está la cuenta activa? " + cuentaActiva);
    }
	
	@Override
	public void imprimir() {
		System.out.println("Saldo: " + saldo);
		System.out.println("Comisión mensual: " + comisionMensual);
		System.out.println("Transacciones realizadas: " + (numIngresos + numRetiros));		
	}
}

class CuentaCorriente extends CuentaBancaria {

    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            super.retirar(cantidad);
        } else {
            float faltante = cantidad - saldo;
            saldo = 0;
            sobregiro += faltante;
            numRetiros++;
        }
    }

    @Override
    public void ingresar(float cantidad) {

        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                float sobrante = cantidad - sobregiro;
                sobregiro = 0;
                super.ingresar(sobrante);
            }
            else {
                sobregiro -= cantidad;
                numIngresos++;
            }
        }
        else {
            super.ingresar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Transacciones: " + (numIngresos + numRetiros));
        System.out.println("Sobregiro: " + sobregiro);
    }
}

public class M1_13_Javier_Molina_Garcia {

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
