package M2_01_Javier_Molina_Garcia;

public class Main {
    public static void main(String[] args) {
        Coche coche1 = new Coche("1234-ABC", "Toyota", "Corolla", "122 CV", "180km/h");
        Coche.Chasis chasis1 = coche1.new Chasis("acero", "280 kg");
        coche1.setChasis(chasis1);

        Coche.Rueda[] ruedas1 = new Coche.Rueda[4];
        ruedas1[0] = coche1.new Rueda("205/55 R16", "seco", "Michelin", "Primacy 4");
        ruedas1[1] = coche1.new Rueda("205/55 R16", "seco", "Michelin", "Primacy 4");
        ruedas1[2] = coche1.new Rueda("205/55 R16", "seco", "Michelin", "Primacy 4");
        ruedas1[3] = coche1.new Rueda("205/55 R16", "seco", "Michelin", "Primacy 4");
        coche1.setRuedas(ruedas1);


        Coche coche2 = new Coche("5678-DEF", "BMW", "320d", "190 CV", "235km/h");
        Coche.Chasis chasis2 = coche2.new Chasis("aluminio", "255 kg");
        coche2.setChasis(chasis2);
        coche2.setRueda(0, coche2.new Rueda("225/45 R18", "lluvia", "Pirelli", "Cinturato P7"));
        coche2.setRueda(1, coche2.new Rueda("225/45 R18", "lluvia", "Pirelli", "Cinturato P7"));
        coche2.setRueda(2, coche2.new Rueda("225/45 R18", "lluvia", "Pirelli", "Cinturato P7"));
        coche2.setRueda(3, coche2.new Rueda("225/45 R18", "lluvia", "Pirelli", "Cinturato P7"));
        System.out.println(coche1);
        System.out.println(coche2);
    }
}