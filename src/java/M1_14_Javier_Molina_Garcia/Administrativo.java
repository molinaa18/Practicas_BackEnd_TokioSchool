package M1_14_Javier_Molina_Garcia;

import java.time.LocalDate;

class Administrativo extends PAS {

    public Administrativo(String nombre, String dni, LocalDate fechaIncorporacion, int horasExtra) {
        super(nombre, dni, fechaIncorporacion, horasExtra);

        setHorasSemana(37);
        setCentimosHora(750);
    }
}