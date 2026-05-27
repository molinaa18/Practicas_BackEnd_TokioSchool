package M1_14_Javier_Molina_Garcia;

import java.time.LocalDate;

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
