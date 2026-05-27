package M2_06_Javier_Molina_Garcia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag<T> {
    private final List<T> elementos;
    private final Random random;

    public Bag() {
        this.elementos = new ArrayList<>();
        this.random = new Random();
    }

    public void add(T item) {
        elementos.add(item);
    }

    public void clear() {
        elementos.clear();
    }

    public boolean contains(T element) {
        return elementos.contains(element);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }

    public T extract() {
        if (elementos.isEmpty()) {
            return null;
        }
        int indice = random.nextInt(elementos.size());
        return elementos.remove(indice);
    }
}