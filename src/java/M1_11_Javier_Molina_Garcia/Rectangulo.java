package java.M1_11_Javier_Molina_Garcia;

class Rectangulo {
    int base;
    int altura;

    public Rectangulo(int b, int h) {
        this.base = Math.abs(b);
        this.altura = Math.abs(h);
    }

    public Rectangulo() {
        this(2, 1);
    }

    public boolean esCuadrado() {
        return base == altura;
    }

    public int area() {
        return base * altura;
    }

    public int perimetro() {
        return 2 * (base + altura);
    }

    public void gira() {
        int baseCopia = base;
        base = altura;
        altura = baseCopia;
    }
}
