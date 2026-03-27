package M2_01_Javier_Molina_Garcia;

import java.util.Arrays;

public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private String potencia;
    private String velocidadMaxima;
    private Chasis chasis;
    private Rueda[] ruedas;

    public class Chasis {
        private String material;
        private String peso;
        public Chasis(String material, String peso) {
            this.material = material;
            this.peso = peso;
        }
        @Override
        public String toString() {
            return "Chasis{" +
                    "material='" + material +
                    "', peso='" + peso +
                    "'}";
        }
    }

    public class Rueda {
        String medida;
        String tipo;
        String marca;
        String modelo;
        public Rueda(String medida, String tipo, String marca, String modelo) {
            this.medida = medida;
            this.tipo = tipo;
            this.marca = marca;
            this.modelo = modelo;
        }
        @Override
        public String toString() {
            return "Rueda{" +
                    "medida='" + medida +
                    "', tipo='" + tipo +
                    "', marca='" + marca +
                    "', modelo='" + modelo +
                    "'}";
        }
    }

    public Coche(String matricula, String marca, String modelo, String potencia, String velocidadMaxima) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.velocidadMaxima = velocidadMaxima;
        this.ruedas = new Rueda[4];
    }

    public void setChasis(Chasis chasis) {
        this.chasis = chasis;
    }
    public void setRueda(int posicion, Rueda rueda) {
        this.ruedas[posicion] = rueda;
    }
    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
            return "Coche{" + "\n" +
                    "      Matricula='" + matricula + "'" + "\n" +
                    "      Marca='" + marca + "'" + "\n" +
                    "      Modelo='" + modelo + "'" + "\n" +
                    "      Velocidad máxima='" + velocidadMaxima + "'" + "\n" +
                    "      Potencia='" + potencia + "'" + "\n" +
                    "      Chasis=" + chasis + "'" + "\n" +
                    "      Ruedas=" + Arrays.toString(ruedas) + "'" + "\n" +
                    "}";
    }
}
