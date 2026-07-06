package M3_02_Javier_Molina_Garcia;

/**
 * Componente Modelo de la arquitectura MVC para la aplicación Calculadora Tokio.
 * <p>
 * Esta clase se encarga exclusivamente de la lógica de negocio matemática del sistema.
 * Implementa un Analizador Sintáctico Descendente Recursivo (Recursive Descent Parser)
 * que procesa cadenas de texto como expresiones matemáticas, respetando la jerarquía de
 * operadores estándar (multiplicación y división evaluadas antes que la suma y la resta).
 * </p>
 */
public class CalculadoraModelo {

    /** Índice que rastrea la posición actual dentro de la cadena de texto. */
    private int pos = -1;

    /** Representación en código numérico (ASCII) del carácter que se analiza actualmente. */
    private int ch;

    /** La expresión matemática a evaluar (ej. "2+3*4"). */
    private String str;

    /**
     * Evalúa una expresión matemática en formato de cadena de texto respetando
     * la jerarquía de operadores (multiplicación/división antes que suma/resta).
     * <p>
     * Utiliza un Analizador Sintáctico Descendente Recursivo (Recursive Descent Parser).
     * </p>
     *
     * @param expresion La expresión matemática a evaluar.
     * @return El resultado numérico de la evaluación como {@code double}.
     * @throws RuntimeException Si la expresión contiene errores de sintaxis.
     */
    public double evaluar(String expresion) {
        this.str = expresion;
        this.pos = -1; // Reiniciamos el estado para cada nueva evaluación
        return parse();
    }

    /**
     * Avanza el puntero a la siguiente posición de la cadena y actualiza el carácter actual.
     * <p>
     * Si el puntero alcanza el final de la cadena de texto, asigna el valor {@code -1}
     * a la variable {@code ch} para indicar que no hay más datos por leer.
     * </p>
     */
    private void nextChar() {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    /**
     * Comprueba si el carácter actual coincide con un símbolo esperado y, de ser así,
     * lo "consume" avanzando a la siguiente posición.
     *
     * @param charToEat El código numérico (ASCII) del carácter esperado (ej. '+' o '*').
     * @return {@code true} si el carácter coincidió y fue consumido; {@code false} en caso contrario.
     */
    private boolean eat(int charToEat) {
        while (ch == ' ') nextChar(); // Filtro limpiador de espacios
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }

    /**
     * Método principal que desencadena el análisis y validación final.
     *
     * @return El resultado final de toda la expresión matemática.
     * @throws RuntimeException Si al terminar la evaluación el puntero no ha llegado
     * al final de la cadena, indicando que hay caracteres inválidos.
     */
    private double parse() {
        nextChar();
        double x = parseExpression();
        if (pos < str.length()) {
            throw new RuntimeException("Carácter inesperado: " + (char)ch);
        }
        return x;
    }

    /**
     * <b>Nivel 1 (Prioridad Baja):</b> Analiza y evalúa sumas y restas.
     * <p>
     * Antes de sumar o restar, delega imperativamente en {@code parseTerm()}
     * para asegurar que cualquier multiplicación o división se resuelva primero.
     * </p>
     */
    private double parseExpression() {
        double x = parseTerm();
        for (;;) {
            if      (eat('+')) x += parseTerm(); // Suma
            else if (eat('-')) x -= parseTerm(); // Resta
            else return x;
        }
    }

    /**
     * <b>Nivel 2 (Prioridad Media):</b> Analiza y evalúa multiplicaciones y divisiones.
     * <p>
     * Antes de multiplicar o dividir, delega en {@code parseFactor()} para extraer
     * los números base puros del texto.
     * </p>
     */
    private double parseTerm() {
        double x = parseFactor();
        for (;;) {
            if      (eat('*')) x *= parseFactor(); // Multiplicación
            else if (eat('/')) x /= parseFactor(); // División
            else return x;
        }
    }

    /**
     * <b>Nivel 3 (Prioridad Alta):</b> Extrae números y gestiona signos unarios.
     * <p>
     * Captura los caracteres numéricos y puntos decimales, transformándolos a {@code double}.
     * También detecta recursivamente los números negativos explícitos.
     * </p>
     */
    private double parseFactor() {
        if (eat('+')) return parseFactor(); // Signo unario positivo
        if (eat('-')) return -parseFactor(); // Signo unario negativo

        double x;
        int startPos = this.pos;
        if ((ch >= '0' && ch <= '9') || ch == '.') {
            // Iteración para formar el número completo
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            x = Double.parseDouble(str.substring(startPos, this.pos));
        } else {
            throw new RuntimeException("Carácter inesperado: " + (char)ch);
        }
        return x;
    }
}