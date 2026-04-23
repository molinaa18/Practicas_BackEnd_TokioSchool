package M2_04_Javier_Molina_Garcia;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread hiloProductor = new Thread(new Productor(buffer), "Productor");
        Thread hiloConsumidor = new Thread(new Consumidor(buffer), "Consumidor");

        hiloProductor.start();
        hiloConsumidor.start();
    }
}
