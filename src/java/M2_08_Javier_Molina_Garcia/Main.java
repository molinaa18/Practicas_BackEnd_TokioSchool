package M2_08_Javier_Molina_Garcia;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Perro miPerro = new Perro("Sanxe");

        // Defino funcion getName. Utilizo lambdaXX como nombre para diferenciarlo mejor.
        Function<Perro, String> lambdaGetName = (perro) -> perro.getName();
        // Defino funcion getInitial
        Function<String, String> lambdaGetInitial = (texto) -> String.valueOf(texto.charAt(0));


        // Defino la lambda que usa el metodo andThen, aprovechando las previas getName y getInitial.
        Function<Perro, String> lambdaAndThen = lambdaGetName.andThen(lambdaGetInitial);
        // Prueba ejecutando la lambdaAndThen a través del metodo apply
        System.out.println("Resultado usando andThen: " + lambdaAndThen.apply(miPerro));

        // Defino la lambda que usa el metodo compose, aprovechando las previas getName y getInitial.
        Function<Perro, String> lambdaCompose = lambdaGetInitial.compose(lambdaGetName);
        // Prueba ejecutando la lambdaCompose a través del metodo apply
        System.out.println("Resultado usando compose: " + lambdaCompose.apply(miPerro));
    }
}