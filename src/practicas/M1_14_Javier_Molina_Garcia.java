package practicas;

import java.time.LocalDate;
import java.time.Period;


// =========================
// SUPERCLASE PERSONAL
// =========================
class Personal {

    private String nombre;
    private String dni;
    private LocalDate fechaIncorporacion;

    private int horasSemana;
    private int centimosHora;

    public Personal(String nombre, String dni, LocalDate fechaIncorporacion) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public int calcularSalario() {
        return horasSemana * centimosHora * 4;  // 4 semanas al mes
    }

    //Getters&Setters
    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }
    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }
    public int getHorasSemana() {
        return horasSemana;
    }
    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }
    public int getCentimosHora() {
        return centimosHora;
    }
    public void setCentimosHora(int centimosHora) {
        this.centimosHora = centimosHora;
    }
}



class PAS extends Personal {

    private int horasExtra = 0;
    private final int centsHoraExtra = 600; // 6 €/h

    public PAS(String nombre, String dni, LocalDate fechaIncorporacion, int horasExtra) {
        super(nombre, dni, fechaIncorporacion);
        this.horasExtra = horasExtra;
    }

    @Override
    public int calcularSalario() {
        int sueldoNormal = super.calcularSalario();
        int extra = horasExtra * centsHoraExtra;

        horasExtra = 0;

        return sueldoNormal + extra;
    }
}



class Administrativo extends PAS {

    public Administrativo(String nombre, String dni, LocalDate fechaIncorporacion, int horasExtra) {
        super(nombre, dni, fechaIncorporacion, horasExtra);

        setHorasSemana(37);
        setCentimosHora(750);
    }
}



class Informatico extends PAS {

    public Informatico(String nombre, String dni, LocalDate fechaIncorporacion, int horasExtra) {
        super(nombre, dni, fechaIncorporacion, horasExtra);

        setHorasSemana(40);
        setCentimosHora(600);
    }
}



class PDI extends Personal {

    public PDI(String nombre, String dni, LocalDate fechaIncorporacion) {
        super(nombre, dni, fechaIncorporacion);
    }
}



class Profesor extends PDI {

    public Profesor(String nombre, String dni, LocalDate fechaIncorporacion) {
        super(nombre, dni, fechaIncorporacion);

        setHorasSemana(37);
        setCentimosHora(800);
    }

    @Override
    public int calcularSalario() {
        int sueldo = super.calcularSalario();

        int antiguedad = Period.between(getFechaIncorporacion(), LocalDate.now()).getYears();
        int sexenios = Math.min(antiguedad / 6, 6);

        sueldo += sexenios * 10000;

        return sueldo;
    }
}


class Investigador extends PDI {

    public Investigador(String nombre, String dni, LocalDate fechaIncorporacion) {
        super(nombre, dni, fechaIncorporacion);

        setHorasSemana(35);
        setCentimosHora(700); // 7 €/h
    }
}



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


public class M1_14_Javier_Molina_Garcia {

    public static void main(String[] args) {

        Personal[] empleados = {
            new Administrativo("Ana", "12345678A", LocalDate.of(2015, 1, 10), 6),
            new Informatico("Luis", "12345678B", LocalDate.of(2021, 5, 3), 15),
            new Profesor("Carlos", "12345678C", LocalDate.of(2000, 3, 20)),
            new Investigador("Marta", "12345678D", LocalDate.of(2022, 11, 15))
        };

        Universidad.imprimirNominas(empleados);

        System.out.println("Presupuesto total: " + 
            (Universidad.obtenerPresupuestoTotal(empleados) / 100.0) + " €");
    }
}