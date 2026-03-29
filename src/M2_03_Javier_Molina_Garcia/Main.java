package M2_03_Javier_Molina_Garcia;

import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        String path = "src/M2_03_Javier_Molina_Garcia/TextFile.txt";
        String tmpPath = "src/M2_03_Javier_Molina_Garcia/TextFile_tmp.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < 3; i++) bw.write("1");
            for (int i = 0; i < 6; i++) bw.write("2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Contenido inicial del archivo:");
        mostrarArchivo(path);

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tmpPath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.replace("2", "3");
                bw.write(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.move(Paths.get(tmpPath), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Contenido tras sustituir 2 por 3:");
        mostrarArchivo(path);
    }

    private static void mostrarArchivo(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}