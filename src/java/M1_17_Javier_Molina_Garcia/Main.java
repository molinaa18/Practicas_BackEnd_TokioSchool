package M1_17_Javier_Molina_Garcia;

public class Main {

    public static void main(String[] args) {

        Baraja baraja = new Baraja();
        Mazo mazo = baraja.getMazo();

        System.out.println(mazo.toString());

        
        mazo.ordena();
        System.out.println(mazo.toString());

        mazo.ordena(new OrdNumIncPalComparator());
        System.out.println(mazo.toString());
    }
}