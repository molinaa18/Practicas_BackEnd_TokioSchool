package M2_06_Javier_Molina_Garcia;

public class Main {
    public static void main(String[] args) {

        Bag<String> bolsa = new Bag<>();

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
        bolsa.clear();
        System.out.println("Vaciando bolsa...");
        System.out.println("¿Está vacía? " + bolsa.isEmpty());

    }
}