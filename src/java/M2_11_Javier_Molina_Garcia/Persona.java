package M2_11_Javier_Molina_Garcia;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Persona {
    private String nombre;
    private String id;
    private String correo;

    //Constructor
    public Persona(String nombre, String id, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
    }

    //Getters&Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Patrón de expresión regular para validar nombres.
     * Utiliza propiedades Unicode para soportar cualquier letra de cualquier alfabeto,
     * incluyendo tildes y la 'ñ'. También permite espacios, guiones y apóstrofes.
     */
    private static final Pattern PATRON_NOMBRE = Pattern.compile("^[\\p{L} '-]+$");

    /**
     * Patrón de expresión regular para validar el formato de DNI o NIE.
     * Soporta el formato de DNI (8 dígitos seguidos de una letra) y
     * el formato de NIE (una letra inicial X, Y o Z, 7 dígitos y una letra final).
     */
    private static final Pattern PATRON_ID = Pattern.compile("([0-9]{8}|[XYZxyz][0-9]{7})[a-zA-Z]");

    /**
     * Patrón de expresión regular para validar direcciones de correo electrónico.
     * Asegura un formato estándar que incluye un nombre de usuario, el símbolo '@'
     * y un dominio válido.
     */
    private static final Pattern PATRON_CORREO = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})$");

    /**
     * Valida los datos actuales de la persona (nombre, id y correo) evaluándolos
     * contra sus respectivos patrones de expresión regular.
     *
     * @return Una lista de {@code String} que contiene los nombres de los campos que
     *         no cumplen con el formato establecido ("Nombre", "ID" o "Correo electrónico").
     *         Si todos los datos son correctos, devuelve una lista vacía.
     */
    public List<String> validarDatos() {
        // Creo una lista que almacena los errores
        List<String> errores = new ArrayList<>();

        // Validacion de nombre
        if (!PATRON_NOMBRE.matcher(this.nombre).matches()) {
            errores.add("Nombre");
        }

        // Validacion del ID
        if (!PATRON_ID.matcher(this.id).matches()) {
            errores.add("ID");
        }

        // Validacion del Correo Electronico
        if (!PATRON_CORREO.matcher(this.correo).matches()) {
            errores.add("Correo electrónico");
        }

        return errores;
    }
}