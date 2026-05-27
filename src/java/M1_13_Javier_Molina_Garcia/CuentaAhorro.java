package M1_13_Javier_Molina_Garcia;

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
