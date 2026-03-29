package M2_02_Javier_Molina_Garcia;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/M2_02_Javier_Molina_Garcia/M2_02_Origen.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/M2_02_Javier_Molina_Garcia/M2_02_Destino.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.replace(' ', '-');
                bw.write(linea);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error leyendo o escribiendo el archivo: " + e.getMessage());
        }
    }
}