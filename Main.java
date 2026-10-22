public class Main {
    public static void main(String[] args) {
        probarPizzaEInterfaces();
        probarFlujoDePedido();
    }

    private static void probarPizzaEInterfaces() {
        System.out.println("========== PRUEBA DE PIZZA Y SUS INTERFACES ==========\n");

        // 1. Instanciación usando diferentes constructores
        Pizza pizza1 = new Pizza("Cuatro Quesos", 9500, 12);
        Pizza pizza2 = new Pizza(); // Valores por defecto

        System.out.println("--- Estado Inicial ---");
        System.out.println("Pizza 1: " + pizza1);
        System.out.println("Pizza 2: " + pizza2);
        System.out.println();

        // 2. Prueba de la interfaz Personalizable (con pizza1)
        System.out.println("--- Probando Interfaz Personalizable (Pizza 1) ---");
        pizza1.cambiarTamanio("Familiar");
        pizza1.agregarIngrediente("Queso Azul");
        pizza1.agregarIngrediente("Mozzarella");
        pizza1.agregarIngrediente("Parmesano");
        pizza1.agregarIngrediente("Gorgonzola");
        pizza1.agregarIngrediente("Cebolla Caramelizada");

        System.out.println("Ingredientes actuales: " + pizza1.getIngredientes());

        pizza1.quitarIngrediente("Cebolla Caramelizada");
        System.out.println("Tras quitar cebolla: " + pizza1.getIngredientes());
        System.out.println("Pizza 1 actualizada: " + pizza1);
        System.out.println();

        // 3. Prueba de la interfaz Preparable (ciclo de preparación)
        System.out.println("--- Probando Interfaz Preparable ---");
        System.out.println("¿Pizza 1 lista antes de preparar?: " + pizza1.estaListo());
        System.out.println("Tiempo estimado de cocción: " + pizza1.getTiempoCoccion() + " minutos.");

        pizza1.iniciarPreparacion();
        System.out.println("Estado actual: " + pizza1.getEstado());

        pizza1.terminarPreparacion();
        System.out.println("¿Pizza 1 lista tras hornear?: " + pizza1.estaListo());
        System.out.println("Estado final: " + pizza1.getEstado());
        System.out.println();

        // 4. Polimorfismo con las interfaces
        System.out.println("--- Demostración de Polimorfismo con Interfaces ---");
        Preparable itemPreparable = pizza2;
        Personalizable itemPersonalizable = pizza2;

        itemPersonalizable.cambiarTamanio("Individual");
        itemPersonalizable.agregarIngrediente("Jamón");
        itemPersonalizable.agregarIngrediente("Piña");

        itemPreparable.iniciarPreparacion();
        itemPreparable.terminarPreparacion();

        System.out.println("\nResultado final Pizza 2:");
        System.out.println(pizza2);
        System.out.println();
    }

    private static void probarFlujoDePedido() {
        System.out.println("========== PRUEBA DEL FLUJO COMPLETO DE UN PEDIDO ==========\n");

        // 1. Personas (jerarquía con clase abstracta)
        Cliente cliente = new Cliente("12.345.678-9", "Ana Pérez", "912345678", "ana@mail.com", "Av. Central 123");
        Repartidor repartidor = new Repartidor("98.765.432-1", "Luis Soto", "987654321", "luis@mail.com", "Moto", "abcd12");

        System.out.println("--- Polimorfismo con la clase abstracta Persona ---");
        Persona[] personas = {cliente, repartidor};
        for (Persona persona : personas) {
            System.out.println("Tipo: " + persona.getTipoPersona());
            persona.mostrarContacto();
            System.out.println("¿Teléfono válido?: " + persona.tieneTelefonoValido());
            System.out.println();
        }

        // 2. Pizzas del pedido
        Pizza margarita = new Pizza("Margarita", 8000, 10);
        margarita.agregarIngrediente("Tomate");
        margarita.agregarIngrediente("Albahaca");

        Pizza pepperoni = new Pizza("Pepperoni", 9500);
        pepperoni.cambiarTamanio("Familiar");

        // 3. Pedido
        Pedido pedido = new Pedido(1, cliente, repartidor, cliente.getDireccion());
        pedido.agregarPizza(margarita);
        pedido.agregarPizza(pepperoni);
        pedido.agregarPizza(null); // Prueba de validación: se rechaza

        System.out.println("--- Detalle del pedido ---");
        pedido.mostrarDetalle();
        System.out.println("Pizzas en el pedido: " + pedido.cuantasPizzasLleva());
        System.out.println("Total sin descuento: $" + (int) pedido.total());
        System.out.println("Total con 10% de descuento: $" + (int) pedido.total(10));
        System.out.println("Total con descuento inválido (150%): $" + (int) pedido.total(150));
        System.out.println();

        // 4. Validaciones de los setters de Pedido
        System.out.println("--- Validaciones en Pedido ---");
        pedido.setCliente(null);
        pedido.setDireccion("   ");
        System.out.println();

        // 5. Preparación, despacho y entrega
        System.out.println("--- Preparación y entrega ---");
        margarita.iniciarPreparacion();
        margarita.terminarPreparacion();
        pepperoni.iniciarPreparacion();
        pepperoni.terminarPreparacion();

        cliente.realizarPedido();
        repartidor.registrarEntrega();
    }
}