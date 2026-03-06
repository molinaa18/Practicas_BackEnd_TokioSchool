package M1_15_Javier_Molina_Garcia;

import java.util.List;

public class OrdNumIncPal extends AlgoritmoOrdenacion {

    @Override
    public void ordenar(List listaCartas) {

        for (int i = 0; i < listaCartas.size() - 1; i++) {
            for (int j = 0; j < listaCartas.size() - i - 1; j++) {

                Carta c1 = (Carta) listaCartas.get(j);
                Carta c2 = (Carta) listaCartas.get(j + 1);

                int num1 = valorNumero(c1);
                int num2 = valorNumero(c2);

                // Ordenar por número ascendente
                if (num1 > num2) {
                    intercambiar(listaCartas, j, j + 1);
                }
                else if (num1 == num2) {
                    // Si el número es igual, ordenar por palo ascendente (alfabético)
                    if (valorPalo(c1) > valorPalo(c2)) {
                        intercambiar(listaCartas, j, j + 1);
                    }
                }
            }
        }
    }

    private void intercambiar(List lista, int i, int j) {
        Object aux = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, aux);
    }

    private int valorNumero(Carta c) {
        switch (c.getNumero()) {
            case "AS": return 1;
            case "DOS": return 2;
            case "TRES": return 3;
            case "CUATRO": return 4;
            case "CINCO": return 5;
            case "SEIS": return 6;
            case "SIETE": return 7;
            case "SOTA": return 10;
            case "CABALLO": return 11;
            case "REY": return 12;
        }
        return -1;
    }

    private int valorPalo(Carta c) {
        // Orden alfabético ascendente:
        // BASTOS (1), COPAS (2), ESPADAS (3), OROS (4)
        switch (c.getPalo()) {
            case "BASTOS": return 1;
            case "COPAS": return 2;
            case "ESPADAS": return 3;
            case "OROS": return 4;
        }
        return -1;
    }
}