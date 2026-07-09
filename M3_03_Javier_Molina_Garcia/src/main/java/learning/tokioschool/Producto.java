package learning.tokioschool;

/**
 * Representa un producto dentro del sistema de control de stock del almacén.
 * Esta clase actúa como el Modelo dentro del patrón MVC.
 * * @author Javier Molina Garcia
 */
public class Producto {

    private String identificador;
    private String nombre;
    private int stock;

    /**
     * Constructor para inicializar un nuevo Producto con todos sus datos.
     *
     * @param identificador El código único del producto.
     * @param nombre        El nombre descriptivo del producto.
     * @param stock         La cantidad inicial de unidades en el almacén.
     */
    public Producto(String identificador, String nombre, int stock) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.stock = stock;
    }

    //Getters&Setters
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}