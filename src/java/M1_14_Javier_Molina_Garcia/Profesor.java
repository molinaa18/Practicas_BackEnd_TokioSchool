package M1_14_Javier_Molina_Garcia;

import java.time.LocalDate;
import java.time.Period;

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
