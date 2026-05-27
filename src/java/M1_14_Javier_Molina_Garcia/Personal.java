package M1_14_Javier_Molina_Garcia;

import java.time.LocalDate;

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
