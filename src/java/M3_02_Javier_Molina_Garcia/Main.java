package M3_02_Javier_Molina_Garcia;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ejecutar la interfaz en el hilo de eventos de Swing (EDT)
        SwingUtilities.invokeLater(() -> {
            // 1. Se instancia el Modelo (Lógica matemática)
            CalculadoraModelo modelo = new CalculadoraModelo();

            // 2. Se instancia la Vista (Nuestra ventana real con los botones)
            CalculadoraVista vista = new CalculadoraVista();

            // 3. Se instancia el Controlador y le pasamos sus dos dependencias
            CalculadoraControlador controlador = new CalculadoraControlador(vista, modelo);

            // 4. Conectamos los botones de la vista al controlador
            vista.setControlador(controlador);

            // 5. Se hace visible la Vista
            vista.setVisible(true);
        });
    }
}