package java.M1_10_Javier_Molina_Garcia;

class Persona {

    String nombre;
    String apellido;
    String dni;
    int aNacimiento;

    public Persona(String nombre, String apellido, String dni, int aNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.aNacimiento = aNacimiento;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Año de nacimiento: " + aNacimiento);
    }
}
