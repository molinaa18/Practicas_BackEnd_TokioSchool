package M2_04_Javier_Molina_Garcia;

import java.util.Random;

public class Productor implements Runnable {
    private final Buffer buffer;
    private final Random random = new Random();
    private int contador = 0;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int valor = ++contador;
                buffer.producir(valor);
                Thread.sleep(random.nextInt(1500) + 500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
