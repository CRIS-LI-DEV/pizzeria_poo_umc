public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos Cliente y Repartidor
        Cliente cliente = new Cliente("18.456.789-0", "Matias Silva", "987654321", "matias@mail.com", "Av. Libertad 1250, Viña del Mar");
        Repartidor repartidor = new Repartidor("15.123.456-7", "Andrés Morales", "912345678", "andres@mail.com", "Moto Honda CB125", "AB-1234");

        // 2. Creamos el pedido asociando a ambos
        Pedido pedido = new Pedido(cliente, repartidor, cliente.getDireccion());

        // 3. Agregamos pizzas al pedido
        pedido.agregarPizza(new Pizza("Napolitana Familiar", 10990));
        pedido.agregarPizza(new Pizza("Pepperoni Mediana", 8990));
        pedido.agregarPizza(new Pizza("Cuatro Quesos Individual", 6490));

        // 4. Mostramos información en consola
        pedido.mostrarDetalle();

        System.out.println("Pizzas que lleva el pedido: " + pedido.cuantasPizzasLleva());
        System.out.println("Total a pagar (sin dcto):   $" + (int) pedido.total());
        System.out.println("Total con 15% de descuento: $" + (int) pedido.total(15));

        System.out.println();
        cliente.realizarPedido();
        repartidor.registrarEntrega();
    }
}