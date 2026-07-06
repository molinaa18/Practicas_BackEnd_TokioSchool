package M3_02_Javier_Molina_Garcia;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Componente Controlador de la arquitectura MVC para la aplicación Calculadora Tokio.
 * <p>
 * Actúa como el puente operacional entre la interfaz gráfica ({@link CalculadoraVista})
 * y el motor de cálculo ({@link CalculadoraModelo}). Implementa la interfaz {@link ActionListener}
 * para centralizar y despachar de forma unificada los eventos de clic de todos los botones,
 * además de gestionar de forma aislada el estado de la memoria de la aplicación.
 * </p>
 */
public class CalculadoraControlador implements ActionListener {

    // Referencias a la Vista y al Modelo
    private CalculadoraVista vista;
    private CalculadoraModelo modelo;

    /**
     * Variable de estado que actúa como memoria interna.
     * Almacena temporalmente el contenido del display.
     */
    private String memoria = "";

    /**
     * Constructor que enlaza el Controlador con la Vista y el Modelo.
     */
    public CalculadoraControlador(CalculadoraVista vista, CalculadoraModelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    /**
     * Método centralizado para escuchar TODOS los botones de la calculadora.
     * Evalúa qué botón se ha pulsado basándose en el texto del mismo.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton origen = (JButton) e.getSource();
        String comando = origen.getText();

        switch (comando) {
            case "=":
                calcularResultado();
                break;
            case "Limpiar":
                vista.setDisplayTexto("");
                break;
            case "Guardar":
                memoria = vista.getDisplayTexto();
                break;
            case "Recuper...":
                vista.setDisplayTexto(memoria);
                break;
            default:
                // Si es un número u operador aritmético, lo concatenamos al display
                String textoActual = vista.getDisplayTexto();
                vista.setDisplayTexto(textoActual + comando);
                break;
        }
    }

    /**
     * Lee la expresión matemática actual de la Vista, delega su cálculo
     * al Modelo y formatea la salida para enviarla de vuelta a la Vista.
     */
    private void calcularResultado() {
        try {
            // 1. Leer de la vista
            String expresion = vista.getDisplayTexto();

            // 2. Calcular usando el modelo
            double resultado = modelo.evaluar(expresion);

            // 3. Formatear y enviar de vuelta a la vista
            if (resultado == (long) resultado) {
                vista.setDisplayTexto(String.format("%d", (long) resultado));
            } else {
                vista.setDisplayTexto(String.format("%s", resultado));
            }
        } catch (Exception ex) {
            // Si el modelo falla por sintaxis incorrecta, avisamos a la vista
            vista.setDisplayTexto("Error");
        }
    }
}