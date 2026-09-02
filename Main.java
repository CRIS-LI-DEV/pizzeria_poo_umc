public class Main {
    public static void main(String[] args) {
        // Se instancia un objeto de la clase Pizza pasando los atributos al constructor
        Pizza miPizza = new Pizza("Pepperoni Especial", "Familiar", 12990.0);

        // Se invoca el método de la clase para imprimir los datos en la consola
        miPizza.mostrarInfo();

        System.out.println("hice un cambio");
        
        Persona p1 = new Persona("12.345.678-9", "  Carlos Muñoz  ", "987654321", "carlos@example.com");
        p1.mostrarContacto();
        System.out.println("Teléfono válido: " + p1.tieneTelefonoValido());
    }
}