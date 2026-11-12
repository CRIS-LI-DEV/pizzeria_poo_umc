public class Main {
    public static void main(String[] args) {
      //  probarPizzaEInterfaces();
        probarFlujoDePedido();
    }

    private static void probarPizzaEInterfaces() {
        System.out.println("========== PRUEBA DE PIZZA Y SUS INTERFACES ==========\n");

        Pizza pizza1 = new Pizza("Cuatro Quesos", 9500, 12);
        Pizza pizza2 = new Pizza();

        System.out.println("--- Estado Inicial ---");
        System.out.println("Pizza 1: " + pizza1);
        System.out.println("Pizza 2: " + pizza2);
        System.out.println();

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

        System.out.println("--- Probando Interfaz Preparable ---");
        System.out.println("¿Pizza 1 lista antes de preparar?: " + pizza1.estaListo());
        System.out.println("Tiempo estimado de cocción: " + pizza1.getTiempoCoccion() + " minutos.");

        pizza1.iniciarPreparacion();
        System.out.println("Estado actual: " + pizza1.getEstado());

        pizza1.terminarPreparacion();
        System.out.println("¿Pizza 1 lista tras hornear?: " + pizza1.estaListo());
        System.out.println("Estado final: " + pizza1.getEstado());
        System.out.println();

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

        // Productos del pedido (incluyendo polimorfismo con Bebida, Pizza y PaloDeAjo)
        Pizza margarita = new Pizza("Margarita", 8000, 10);
        margarita.agregarIngrediente("Tomate");
        margarita.agregarIngrediente("Albahaca");

        Pizza pepperoni = new Pizza("Pepperoni", 9500);
        pepperoni.cambiarTamanio("Familiar");
       
        PaloDeAjo paloAjo1 = new PaloDeAjo("Traducional", 2500);
        Bebida bebida = new Bebida("Coca-Cola", 2000, Bebida.TamanioBebida.FAMILIAR);

        // Creación del Objeto de Valor Dirección
        Direccion direccionEnvio = new Direccion("Av. Central", "123", "Viña del Mar");

        // Pedido (ahora recibe la instancia de Direccion)
        Pedido pedido = new Pedido(1, cliente, repartidor, direccionEnvio);
        pedido.agregarItem(margarita);
        pedido.agregarItem(pepperoni);
        pedido.agregarItem(bebida);
        pedido.agregarItem(paloAjo1);
        pedido.agregarItem(null); // Prueba de validación: se rechaza

        System.out.println("--- Detalle del pedido ---");
        System.out.println("ID Pedido: " + pedido.getIdPedido());
        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("Repartidor: " + pedido.getRepartidor().getNombre());
        System.out.println("Dirección: " + pedido.getDireccion());
        System.out.println("Productos ordenados (" + pedido.cantidadItems() + "):");
        
        for (ItemPedido item : pedido.getItems()) {
            System.out.println("  - " + item);
        }
        System.out.println("Total sin descuento: $" + (int) pedido.total());
        System.out.println("Total con 10% de descuento : $" + (int) pedido.total(new DescuentoPorcentaje(10)));
        pedido.imprimirBoletaFinal(new DescuentoPorcentaje(10));
        System.out.println();

        System.out.println("--- Validaciones en Pedido ---");
        pedido.setCliente(null);
        pedido.setDireccion(null);
        System.out.println();

        System.out.println("--- Preparación y entrega ---");
        margarita.iniciarPreparacion();
        margarita.terminarPreparacion();
        pepperoni.iniciarPreparacion();
        pepperoni.terminarPreparacion();

        paloAjo1.iniciarPreparacion();
        paloAjo1.terminarPreparacion();

        cliente.realizarPedido();
        repartidor.registrarEntrega();
    }
}