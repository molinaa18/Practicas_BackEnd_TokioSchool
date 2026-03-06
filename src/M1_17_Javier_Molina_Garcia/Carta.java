package M1_17_Javier_Molina_Garcia;


public class Carta implements Comparable<Carta>  {
	
	private final String numero;
    private final String palo;

    public Carta(String numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }
    String getNumero() {
        return numero;
    }
    public String getPalo() {
        return palo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 47 * hash + (this.palo != null ? this.palo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.palo != other.palo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numero + " " + palo;
    }

    @Override
    public int compareTo(Carta other) {

        int posPaloThis = posicionPalo(this.palo);
        int posPaloOther = posicionPalo(other.palo);

        if (posPaloThis != posPaloOther) {
            return posPaloThis - posPaloOther;
        }

        int posNumThis = posicionNumero(this.numero);
        int posNumOther = posicionNumero(other.numero);

        return posNumThis - posNumOther;
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



