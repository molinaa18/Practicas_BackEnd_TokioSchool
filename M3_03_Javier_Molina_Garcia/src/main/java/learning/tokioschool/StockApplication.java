package learning.tokioschool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal que actúa como punto de entrada de la aplicación JavaFX.
 * Es la encargada de cargar la Vista (archivo FXML) y configurar el escenario principal (Stage).
 */
public class StockApplication extends Application {

    /**
     * Metodo principal que inicializa y muestra la interfaz gráfica.
     *
     * @param stage El escenario principal (ventana) proporcionado por JavaFX.
     * @throws IOException Si ocurre un error al intentar localizar o cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Carga el archivo visual FXML desde la carpeta resources
        FXMLLoader fxmlLoader = new FXMLLoader(StockApplication.class.getResource("stock-view.fxml"));

        // Crea la escena con un tamaño inicial de 600x400 píxeles
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setMinWidth(600);
        stage.setMinHeight(400);

        // Configura el título de la ventana y la muestra
        stage.setTitle("Control de Stock - Almacén");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo de lanzamiento estándar de la aplicación Java.
     * Delega el arranque al ciclo de vida de JavaFX.
     *
     * @param args Argumentos pasados por la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        launch();
    }
}