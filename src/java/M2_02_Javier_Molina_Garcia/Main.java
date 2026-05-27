package M2_02_Javier_Molina_Garcia;

import java.io.*;

public class Main {

    public void procesarFichero() {
        // Rutas según las buenas prácticas
        String rutaOrigen = "/M2_02/Origen.txt";
        String rutaDestino = "src/results/M2_02_Destino.txt"; // Se creará en la raíz del proyecto

        // Uso de Try-with-resources para cerrar automáticamente todos los flujos
        try (
                // Flujo de lectura (desde resources)
                InputStream is = getClass().getResourceAsStream(rutaOrigen)
        ) {
            // Validación de seguridad por si el archivo origen no existe
            if (is == null) {
                System.err.println("Error: No se encontró el archivo origen en: " + rutaOrigen);
                return;
            }

            // Encadenamos los flujos de lectura y escritura de caracteres
            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDestino))
            ) {
                String linea;
                boolean primeraLinea = true;

                // Leemos línea a línea
                while ((linea = reader.readLine()) != null) {
                    // Si no es la primera línea, añadimos el salto de línea en el destino
                    if (!primeraLinea) {
                        writer.newLine();
                    }
                    primeraLinea = false;

                    // Transformación: Reemplazamos todos los espacios por guiones
                    String lineaModificada = linea.replace(" ", "-");

                    // Escribimos la línea modificada en el archivo destino
                    writer.write(lineaModificada);
                }

                System.out.println("¡Proceso completado con éxito!");
                System.out.println("El archivo modificado se ha guardado en: " + rutaDestino);

            }

        } catch (Exception e) {
            System.err.println("Ocurrió un error durante el proceso: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().procesarFichero();
    }
}