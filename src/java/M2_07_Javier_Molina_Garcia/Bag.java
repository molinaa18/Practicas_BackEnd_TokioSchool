package M2_07_Javier_Molina_Garcia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
//Se implementa Iterable.
public class Bag<T> implements Iterable<T> {
    private final List<T> elementos;
    private final Random random;

    public Bag() {
        this.elementos = new ArrayList<>();
        this.random = new Random();
    }

    public void add(T item) {
        elementos.add(item);
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

    /*
    El enunciado de la practica no pide usar estos metodos que estaban anterioremente.
    Quedan como comentario por si fuera necesario reincorporarlos.

    public void clear() {
        elementos.clear();
    }
    public boolean contains(T element) {
        return elementos.contains(element);
    }

     */

    //Iterable requiere un Iterator. Lo desarrollo en la clase privada BagIterator.
    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    //Una clase interna para que pueda leer la List de "elementos", pero privada para evitar acceso y manipulacion externa.
    private class BagIterator implements Iterator<T> {
        private int indiceActual = 0; // Indice del iterador

        @Override
        public boolean hasNext() {
            // Hay un siguiente elemento si el indice actual no ha superado el tamaño de la bolsa
            return indiceActual < elementos.size();
        }

        @Override
        public T next() {
            // Excepción en caso de que no haya mas elementos
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la bolsa.");
            }

            // Uso el getter para acceder a elementos
            T elemento = elementos.get(indiceActual);

            indiceActual++;

            return elemento;
        }
    }
}