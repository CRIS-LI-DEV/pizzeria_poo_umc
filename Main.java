public class Main {
    public static void main(String[] args) {
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
        pizza1.agregarIngrediente("Cebolla Caramelizada"); // Agregamos un extra

        System.out.println("Ingredientes actuales: " + pizza1.getIngredientes());

        // Quitamos un ingrediente
        pizza1.quitarIngrediente("Cebolla Caramelizada");
        System.out.println("Tras quitar cebolla: " + pizza1.getIngredientes());
        System.out.println("Pizza 1 actualizada: " + pizza1);
        System.out.println();

        // 3. Prueba de la interfaz Preparable (Ciclo de preparación)
        System.out.println("--- Probando Interfaz Preparable ---");
        System.out.println("¿Pizza 1 lista antes de preparar?: " + pizza1.estaListo());
        System.out.println("Tiempo estimado de cocción: " + pizza1.getTiempoCoccion() + " minutos.");

        // Iniciar
        pizza1.iniciarPreparacion();
        System.out.println("Estado actual: " + pizza1.getEstado());

        // Terminar
        pizza1.terminarPreparacion();
        System.out.println("¿Pizza 1 lista tras hornear?: " + pizza1.estaListo());
        System.out.println("Estado final: " + pizza1.getEstado());
        System.out.println();

        // 4. Polimorfismo con las Interfaces
        System.out.println("--- Demostración de Polimorfismo ---");
        Preparable itemPreparable = pizza2;
        Personalizable itemPersonalizable = pizza2;

        itemPersonalizable.cambiarTamanio("Individual");
        itemPersonalizable.agregarIngrediente("Jamón");
        itemPersonalizable.agregarIngrediente("Piña");

        itemPreparable.iniciarPreparacion();
        itemPreparable.terminarPreparacion();

        System.out.println("\nResultado final Pizza 2:");
        System.out.println(pizza2);
    }
}