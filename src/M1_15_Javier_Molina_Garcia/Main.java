package M1_15_Javier_Molina_Garcia;

public class Main {

	public static void main(String[] args) {
		
		Baraja baraja = new Baraja();
        Mazo mazo = baraja.getMazo();
        System.out.println(mazo.toString());

        mazo.setAlgoritmo(new OrdPalNumInc());
        mazo.ordenar();
        System.out.println(mazo.toString());

        mazo.setAlgoritmo(new OrdPalNumDec());
        mazo.ordenar();
        System.out.println(mazo.toString());
        
        mazo.setAlgoritmo(new OrdNumIncPal());
        mazo.ordenar();
        System.out.println(mazo.toString()); 
	}

}
