package M1_17_Javier_Molina_Garcia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Mazo {

    private List<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
    }

    public void ordena() {
        Collections.sort(cartas);
    }

    public void ordena(Comparator<Carta> comparator) {
        Collections.sort(cartas, comparator);
    }

    public Carta getCarta(int posicion) {
        return cartas.get(posicion);
    }

    public void insertarCarta(int posicion, Carta carta) {
        List<Carta> aux = new ArrayList<>();

        for (int i = cartas.size() - 1; i >= posicion; i--) {
            aux.add(cartas.remove(i));
        }

        cartas.add(carta);

        for (int i = aux.size() - 1; i >= 0; i--) {
            cartas.add(aux.get(i));
        }
    }

    public Carta extraerCarta(int posicion) {
        return cartas.remove(posicion);
    }

    public Carta extraerCarta() {
        return cartas.remove(cartas.size() - 1);
    }

    public void anadirCarta(Carta carta) {
        cartas.add(carta);
    }

    public int numCartas() {
        return cartas.size();
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    @Override
    public String toString() {
        return "" + cartas;
    }
}