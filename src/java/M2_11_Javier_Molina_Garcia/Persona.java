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

    // Defino los patrones como constantes para evitar compilacion con cada ejecucion del metodo
    private static final Pattern PATRON_NOMBRE = Pattern.compile("[A-Za-z\\s]+");
    // Validacion apta para DNI o NIE, diferente formato
    private static final Pattern PATRON_ID = Pattern.compile("([0-9]{8}|[XYZxyz][0-9]{7})[a-zA-Z]");
    private static final Pattern PATRON_CORREO = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})$");


    // Metodo de validacion de datos
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
