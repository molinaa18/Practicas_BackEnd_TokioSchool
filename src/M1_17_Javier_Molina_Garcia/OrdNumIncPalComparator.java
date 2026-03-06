package M1_17_Javier_Molina_Garcia;

import java.util.Comparator;

public class OrdNumIncPalComparator implements Comparator<Carta> {

    @Override
    public int compare(Carta c1, Carta c2) {
        int posNum1 = posicionNumero(c1.getNumero());
        int posNum2 = posicionNumero(c2.getNumero());

        if (posNum1 != posNum2) {
            return posNum1 - posNum2;
        }

        int posPalo1 = posicionPalo(c1.getPalo());
        int posPalo2 = posicionPalo(c2.getPalo());

        return posPalo1 - posPalo2;
    }

    private int posicionPalo(String palo) {
        for (int i = 0; i < Baraja.palos.length; i++) {
            if (Baraja.palos[i].equals(palo)) {
                return i;
            }
        }
        return -1;
    }

    private int posicionNumero(String numero) {
        for (int i = 0; i < Baraja.numeros.length; i++) {
            if (Baraja.numeros[i].equals(numero)) {
                return i;
            }
        }
        return -1;
    }
}