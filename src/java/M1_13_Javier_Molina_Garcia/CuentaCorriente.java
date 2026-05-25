package java.M1_13_Javier_Molina_Garcia;

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
            } else {
                sobregiro -= cantidad;
                numIngresos++;
            }
        } else {
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
