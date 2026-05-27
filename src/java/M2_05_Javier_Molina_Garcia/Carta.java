package M2_05_Javier_Molina_Garcia;

public class Carta {

    private final Palo palo;
    private final Numero numero;

    public Carta(Numero numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Palo getPalo() {
        return palo;
    }

    public Numero getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "" + numero.getAbreviatura() + palo.getAbreviatura();
    }

}
