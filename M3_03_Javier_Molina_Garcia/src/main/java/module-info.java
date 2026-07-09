module learning.tokioschool {
    requires javafx.controls;
    requires javafx.fxml;

    // Esto permite que JavaFX acceda a tus clases y al controlador
    opens learning.tokioschool to javafx.fxml;
    exports learning.tokioschool;
}