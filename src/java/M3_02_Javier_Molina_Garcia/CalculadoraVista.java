package M3_02_Javier_Molina_Garcia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Ventana principal de la aplicación Calculadora Tokio.
 * <p>
 * Esta clase hereda de {@link JFrame} para construir una interfaz gráfica
 * de escritorio utilizando la biblioteca Swing. Implementa el patrón de diseño
 * visual dividiendo el espacio en zonas (Norte para el display, Centro para el
 * teclado numérico y Este para las acciones de memoria).
 * </p>
 */
public class CalculadoraVista extends JFrame {

    /**
     * Pantalla principal (display) de la calculadora.
     */
    private JTextField display;

    /**
     * Lista para almacenar todos los botones de la interfaz.
     * Esto facilita asignarles el ActionListener (Controlador) más adelante.
     */
    private List<JButton> listaBotones;

    /**
     * Constructor de la clase.
     */
    public CalculadoraVista() {
        listaBotones = new ArrayList<>();

        // 1. Aplicar el estilo visual (Look & Feel) ANTES de crear nada
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. Configuración del contenedor principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(20, 20));
        panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));

        // 3. Creación y configuración de la pantalla (Display)
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(450, 50));
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        panelPrincipal.add(display, BorderLayout.NORTH);

        // 4. Creación del teclado numérico y operadores básicos
        JPanel panelTeclado = new JPanel();
        panelTeclado.setLayout(new GridLayout(4, 4, 15, 15));

        String[] textosBotones = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "0", ".", "=", "/"
        };

        for (String texto : textosBotones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 16));
            panelTeclado.add(boton);
            listaBotones.add(boton);
        }
        panelPrincipal.add(panelTeclado, BorderLayout.CENTER);

        // 5. Creación del panel lateral para operaciones de memoria
        JPanel panelAcciones = crearPanelAcciones();
        panelPrincipal.add(panelAcciones, BorderLayout.EAST);

        // =========================================================
        // 6. CONFIGURACIÓN FINAL DE LA VENTANA (SIEMPRE AL FINAL)
        // =========================================================
        setContentPane(panelPrincipal); // Metemos todo el contenido
        setTitle("Calculadora Tokio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack(); // MÁGIA: Obliga a Swing a calcular y distribuir los tamaños de todo

        setSize(500, 400); // Forzamos nuestro tamaño deseado
        setLocationRelativeTo(null); // Ahora sí, centramos la ventana sabiendo su tamaño real
        setResizable(false); // Bloqueamos el tamaño
    }

    /**
     * Crea el panel lateral con los botones de memoria.
     */
    private JPanel crearPanelAcciones() {
        JPanel panelAcciones = new JPanel();
        panelAcciones.setLayout(new GridLayout(3, 1, 15, 25));
        panelAcciones.setPreferredSize(new Dimension(120, 0));

        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnRecuperar = new JButton("Recuper...");

        Font fontAcciones = new Font("Arial", Font.BOLD, 14);
        btnLimpiar.setFont(fontAcciones);
        btnGuardar.setFont(fontAcciones);
        btnRecuperar.setFont(fontAcciones);

        // Añadimos los botones al panel
        panelAcciones.add(btnLimpiar);
        panelAcciones.add(btnGuardar);
        panelAcciones.add(btnRecuperar);

        // También los guardamos en la lista de botones general
        listaBotones.add(btnLimpiar);
        listaBotones.add(btnGuardar);
        listaBotones.add(btnRecuperar);

        return panelAcciones;
    }

    // =========================================================
    // MÉTODOS DE COMUNICACIÓN CON EL CONTROLADOR (GETTERS/SETTERS)
    // =========================================================

    /**
     * Recorre todos los botones creados y les asigna el controlador
     * encargado de escuchar los clics.
     * @param controlador El objeto que implementa ActionListener.
     */
    public void setControlador(ActionListener controlador) {
        for (JButton boton : listaBotones) {
            boton.addActionListener(controlador);
        }
    }

    /**
     * Devuelve el texto actual mostrado en la pantalla de la calculadora.
     */
    public String getDisplayTexto() {
        return display.getText();
    }

    /**
     * Modifica el texto que se muestra en la pantalla de la calculadora.
     * @param texto El nuevo texto a mostrar.
     */
    public void setDisplayTexto(String texto) {
        display.setText(texto);
    }
}