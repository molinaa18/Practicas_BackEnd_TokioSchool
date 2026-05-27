package M2_05_Javier_Molina_Garcia;

public enum Palo {
    ESPADAS('E'),
    COPAS('C'),
    BASTOS('B'),
    OROS('O');

    private final char abreviatura;

    private Palo(char abreviatura) {
        this.abreviatura = abreviatura;
    }

    public char getAbreviatura() {
        return abreviatura;
    }

}
