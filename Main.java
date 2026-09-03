public class Main {
    public static void main(String[] args) {
        
        Pizza miPizza = new Pizza("Pepperoni Especial", "Familiar", 12990.0);

      
        miPizza.mostrarInfo();

        System.out.println("hice un cambio");

        Persona p1 = new Persona("12.345.678-9", "  Carlos Muñoz  ", "987654321", "carlos@example.com");
        p1.mostrarContacto();
        System.out.println("Teléfono válido: " + p1.tieneTelefonoValido());

        Repartidor r1 = new Repartidor("11.222.333-4", "Diego Becerra", "912345678", "diego@umc.com", "Moto", "AB-1234");
        r1.mostrarContacto();
        r1.registrarEntrega();
    }
}