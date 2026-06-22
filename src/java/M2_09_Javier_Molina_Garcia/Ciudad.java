package M2_09_Javier_Molina_Garcia;

public class Ciudad {
    private final String nombre;
    private final String provincia;
    private final int habitantes;

    public Ciudad(String nombre, String provincia, int habitantes) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.habitantes = habitantes;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getProvincia() {
        return provincia;
    }
    public int getHabitantes() {
        return habitantes;
    }

}
