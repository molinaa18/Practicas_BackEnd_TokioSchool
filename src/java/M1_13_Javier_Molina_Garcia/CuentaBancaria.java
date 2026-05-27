package M1_13_Javier_Molina_Garcia;

class CuentaBancaria {
    protected float saldo;
    protected int numIngresos = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    /**
     * Constructor
     */
    public CuentaBancaria(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }


    /**
     * Getters&Setters
     */
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
        saldo += Math.round((saldo * tasaMensual) * 100f) / 100f;
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
