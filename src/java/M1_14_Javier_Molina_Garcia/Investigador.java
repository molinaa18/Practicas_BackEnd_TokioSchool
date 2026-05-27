package M1_14_Javier_Molina_Garcia;

import java.time.LocalDate;

class Investigador extends PDI {

    public Investigador(String nombre, String dni, LocalDate fechaIncorporacion) {
        super(nombre, dni, fechaIncorporacion);

        setHorasSemana(35);
        setCentimosHora(700); // 7 €/h
    }
}
