package M2_10_Javier_Molina_Garcia;

public class Main {

    public static void main(String[] args) {

        System.out.println("Parte 1: StringBuilder");

        // 1. Creo el StringBuilder con la cadena y mostrarla
        StringBuilder sBuilder = new StringBuilder("Hay coches");
        System.out.println("1- Cadena inicial: " + sBuilder);

        // 2. Muestro su capacidad y longitud iniciales
        System.out.println("2- Capacidad inicial: " + sBuilder.capacity() + " -- " + "Longitud inicial: " + sBuilder.length());

        // 3. Modifico la cadena a "Hay coches en el desguace" y mostrarla
        sBuilder.append(" en el desguace");
        System.out.println("3- Cadena modificada (append): " + sBuilder);

        // 4. Modifico la cadena a "Hay más de 1000 coches en el desguace" (1000 almacenado en un int)
        int cantidad = 1000;
        //El 4 es la posición previa a la modificación de la cadena.
        sBuilder.insert(4, "más de " + cantidad + " ");
        System.out.println("4- Cadena modificada (insert): " + sBuilder);

        // 5. 4 últimos caracteres almacenados y mostrados en consola
        String ultimosCuatroSb = sBuilder.substring(sBuilder.length() - 4);
        System.out.println("5- Últimos 4 caracteres almacenados: " + ultimosCuatroSb);

        // 6. Muestro capacidad y longitud finales
        System.out.println("6- Capacidad final: " + sBuilder.capacity() + " -- " + "Longitud final: " + sBuilder.length());

        System.out.println("................" + "\n");

        System.out.println("Parte 2: StringBuffer");

        //En esta práctica, el comportamiento en la segunda parte no difiere. Por lo que el código es casi idéntico

        StringBuffer sBuffer = new StringBuffer("Hay coches");
        System.out.println("1- Cadena inicial: " + sBuffer);

        System.out.println("2- Capacidad inicial: " + sBuilder.capacity() + " -- " + "Longitud inicial: " + sBuilder.length());

        sBuffer.append(" en el desguace");
        System.out.println("3- Cadena modificada (append): " + sBuffer);

        int cantidadBf = 1000;
        sBuffer.insert(4, "más de " + cantidadBf + " ");
        System.out.println("4- Cadena modificada (insert): " + sBuffer);

        String ultimosCuatroSbf = sBuffer.substring(sBuffer.length() - 4);
        System.out.println("5- Últimos 4 caracteres almacenados: " + ultimosCuatroSbf);

        System.out.println("6- Capacidad final: " + sBuilder.capacity() + " -- " + "Longitud final: " + sBuilder.length());

    }
}
