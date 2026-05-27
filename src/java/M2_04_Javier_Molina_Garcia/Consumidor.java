package M2_04_Javier_Molina_Garcia;

import java.util.Random;

public class Consumidor implements Runnable {
    private final Buffer buffer;
    private final Random random = new Random();

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int valor = buffer.consumir();
                Thread.sleep(random.nextInt(1500) + 500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
