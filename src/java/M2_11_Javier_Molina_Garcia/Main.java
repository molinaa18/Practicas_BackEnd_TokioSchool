package M2_11_Javier_Molina_Garcia;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Paco Perez", "11111111A", "pacoperez@miaumail.com"));
        personas.add(new Persona("N0mbre Fals0", "X2222222B", "nombrefalso@miaumail.com"));
        personas.add(new Persona("Javier Molina", "33333333C", "javiermolina@miaumail.com"));
        personas.add(new Persona("Denei Equivocado", "4444444D", "deneiequivocado@miaumail.com"));
        personas.add(new Persona("Idymeil Fallido", "E5555555E", "m@ailf@allido@miaumail.es"));

        System.out.println("Inicio del programa.\n" +
                "Se mostrarán en pantalla los errores de formato en la información de las personas:");

        boolean hayErrores = false;
        for (Persona persona : personas) {
            List<String> camposIncorrectos = persona.validarDatos();

            if (!camposIncorrectos.isEmpty()) {
                hayErrores = true;
                System.out.println(persona.getNombre() + ":");
                for (String error : camposIncorrectos) {
                    System.out.println("  - " + error);
                }
                System.out.println("..................");
            }
        }
        if (!hayErrores) {
            System.out.println("Todos los datos de la colección son válidos.");
        }

        System.out.println("Fin del programa.");
    }
}
