package M1_14_Javier_Molina_Garcia;

import java.time.LocalDate;

class Informatico extends PAS {

    public Informatico(String nombre, String dni, LocalDate fechaIncorporacion, int horasExtra) {
        super(nombre, dni, fechaIncorporacion, horasExtra);

        setHorasSemana(40);
        setCentimosHora(600);
    }
}
