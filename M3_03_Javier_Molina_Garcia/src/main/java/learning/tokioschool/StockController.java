package learning.tokioschool;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controlador de la interfaz gráfica para la gestión del control de stock.
 * Se encarga de la lógica de negocio asociada a la vista (FXML), coordinando
 * las acciones de agregar, modificar y validar los productos en el almacén.
 * <p>
 * Actúa como el Controlador (C) dentro del patrón de arquitectura MVC.
 * </p>
 *
 */
public class StockController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtStock;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Integer> colStock;

    /**
     * Lista observable que almacena los productos y notifica automáticamente
     * a la TableView ante cualquier cambio (inserción, modificación o actualización).
     */
    private final ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    /**
     * Metodo de inicialización automática del ciclo de vida de JavaFX.
     * Configura el mapeo de las columnas de la tabla con los atributos del modelo Producto
     * y añade un escuchador para cargar los datos en el formulario cuando se selecciona una fila.
     */
    @FXML
    public void initialize() {
        // Enlazar las columnas con las propiedades correspondientes de la clase Producto
        colId.setCellValueFactory(new PropertyValueFactory<>("identificador"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        // Asignar la lista de datos a la tabla de la interfaz
        tablaProductos.setItems(listaProductos);

        // Escuchador (Listener) para detectar la selección de una fila en la tabla
        tablaProductos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Copiar los valores del elemento seleccionado a los campos de texto
                txtId.setText(newValue.getIdentificador());
                txtNombre.setText(newValue.getNombre());
                txtStock.setText(String.valueOf(newValue.getStock()));

                // Deshabilitar el ID para impedir su edición al modificar un registro existente
                txtId.setDisable(true);
            }
        });
    }

    /**
     * Gestiona la acción asociada al botón "Agregar".
     * Valida que los campos no estén vacíos, que el stock sea un valor numérico entero no negativo
     * y garantiza que el identificador introducido sea único en el sistema.
     */
    @FXML
    private void agregarProducto() {
        // Se utiliza trim() para eliminar espacios antes/despues y evitar errores inesperados
        String idString = txtId.getText().trim();
        String nombreString = txtNombre.getText().trim();
        String stockString = txtStock.getText().trim();

        // 1. Validación de campos vacíos
        if (idString.isEmpty() || nombreString.isEmpty() || stockString.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor, rellene todos los campos (Identificador, Nombre y Stock).");
            return;
        }

        // 2. Validación del formato del campo 'stockInt'
        int stockInt;
        try {
            stockInt = Integer.parseInt(stockString);
            if (stockInt < 0) {
                mostrarAlerta("Stock inválido", "La cantidad en stockInt no puede ser un número negativo.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Formato incorrecto", "El campo Stock debe contener únicamente números enteros.");
            return;
        }

        // 3. Validación de que el id es único y no se repite
        for (Producto producto : listaProductos) {
            if (producto.getIdentificador().equalsIgnoreCase(idString)) {
                mostrarAlerta("Identificador duplicado", "Ya existe un producto registrado con el ID: " + idString);
                return;
            }
        }

        // 4. Inserción del nuevo producto y restablecimiento del formulario
        listaProductos.add(new Producto(idString, nombreString, stockInt));
        limpiarCampos();
    }

    /**
     * Gestiona la acción asociada al botón "Modificar".
     * Comprueba si hay una fila activa en la tabla, valida las modificaciones
     * realizadas sobre el nombre y el stock, y actualiza visualmente el registro.
     */
    @FXML
    private void modificarProducto() {
        // Obtener el objeto Producto actualmente seleccionado en la TableView
        Producto productoSeleccionado = tablaProductos.getSelectionModel().getSelectedItem();

        if (productoSeleccionado == null) {
            mostrarAlerta("Sin selección", "Debe seleccionar un producto de la tabla para poder modificarlo.");
            return;
        }

        String nombre = txtNombre.getText().trim();
        String stockStr = txtStock.getText().trim();

        // 1. Validación de campos vacíos
        if (nombre.isEmpty() || stockStr.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Los campos Nombre y Stock no pueden quedar vacíos.");
            return;
        }

        // 2. Validación del formato numérico del stock modificado
        int stock;
        try {
            stock = Integer.parseInt(stockStr);
            if (stock < 0) {
                mostrarAlerta("Stock inválido", "La cantidad en stock no puede ser un número negativo.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Formato incorrecto", "El campo Stock debe contener únicamente números enteros.");
            return;
        }

        // 3. Actualizar los datos del objeto del modelo
        productoSeleccionado.setNombre(nombre);
        productoSeleccionado.setStock(stock);

        // Forzar a la tabla a refrescar los cambios visualmente
        tablaProductos.refresh();

        // 4. Limpiar el formulario y reactivar el campo ID para futuras inserciones
        limpiarCampos();
        txtId.setDisable(false);
    }

    /**
     * Borra el contenido de todos los campos de texto del formulario
     * y remueve cualquier selección activa de la tabla.
     */
    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtStock.clear();
        tablaProductos.getSelectionModel().clearSelection();
    }

    /**
     * Muestra una ventana emergente de aviso (Alert) integrada para notificar
     * errores de validación o advertencias del sistema al usuario.
     *
     * @param titulo  El título de la ventana de diálogo.
     * @param mensaje El contenido explicativo del problema detectado.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}