package M1_12_Javier_Molina_Garcia;

public class Main {

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
