package java.M2_05_Javier_Molina_Garcia;

public enum Numero {
    AS('A'),
    DOS('2'),
    TRES('3'),
    CUATRO('4'),
    CINCO('5'),
    SEIS('6'),
    SIETE('7'),
    SOTA('S'),
    CABALLO('C'),
    REY('R');

    private final char abreviatura;

    private Numero(char abreviatura) {
        this.abreviatura = abreviatura;
    }

    public char getAbreviatura() {
        return abreviatura;
    }

}
