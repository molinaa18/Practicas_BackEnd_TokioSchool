package M1_12_Javier_Molina_Garcia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Bag {
    private List<Object> elementos;
    private Random random;

    public Bag() {
        elementos = new ArrayList<>();
        random = new Random();
    }

    public boolean add(Object e) {
        return elementos.add(e);
    }

    public void clear() {
        elementos.clear();
    }

    public boolean contains(Object o) {
        return elementos.contains(o);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }

    public Object extract() {
        if (elementos.isEmpty()) {
            return null;
        }
        int indice = random.nextInt(elementos.size());
        return elementos.remove(indice);
    }
}
