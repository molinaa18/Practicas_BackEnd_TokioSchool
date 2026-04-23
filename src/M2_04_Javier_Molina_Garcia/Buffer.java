package M2_04_Javier_Molina_Garcia;

import java.util.LinkedList;

public class Buffer {
    private static final int CAPACIDAD = 5;
    private final LinkedList<Integer> lista = new LinkedList<>();

    public synchronized void producir(int valor) throws InterruptedException {
        while (lista.size() == CAPACIDAD) {
            wait();
        }
        lista.addLast(valor);
        System.out.println("Producido: " + valor + " | Buffer: " + lista.size() + "/" + CAPACIDAD);
        notifyAll();
    }

    public synchronized int consumir() throws InterruptedException {
        while (lista.isEmpty()) {
            wait();
        }
        int valor = lista.removeFirst();
        System.out.println("Consumido: " + valor + " | Buffer: " + lista.size() + "/" + CAPACIDAD);
        notifyAll();
        return valor;
    }
}
