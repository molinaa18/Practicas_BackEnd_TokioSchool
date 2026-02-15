package practicas;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

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

public class M1_12_Javier_Molina_Garcia {

    public static void main(String[] args) {
        Bag bolsa = new Bag();

        bolsa.add("Manzana");
        bolsa.add("Pera");
        bolsa.add("Plátano");
        bolsa.add("Naranja");

        System.out.println("Tamaño inicial de la bolsa: " + bolsa.size());

        System.out.println("Elemento extraído: " + bolsa.extract());
        System.out.println("Elemento extraído: " + bolsa.extract());

        System.out.println("Tamaño final de la bolsa: " + bolsa.size());

        System.out.println("¿Contiene 'Pera'? " + bolsa.contains("Pera"));
        System.out.println("¿Está vacía? " + bolsa.isEmpty());
    }
}
