package M1_14_Javier_Molina_Garcia;

class Universidad {

    public static void imprimirNominas(Personal[] listaPersonal) {

        for (Personal p : listaPersonal) {

            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Categoría: " + p.getClass().getSimpleName());

            double sueldoEuros = p.calcularSalario() / 100.0;

            System.out.println("Sueldo mensual: " + sueldoEuros + " €");
            System.out.println("-----------------------------");
        }
    }


    public static int obtenerPresupuestoTotal(Personal[] listaPersonal) {
        int total = 0;

        for (Personal p : listaPersonal) {
            total += p.calcularSalario();
        }
        return total;
    }
}
