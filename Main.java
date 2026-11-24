public class Main {
    public static void main(String[] args) {
        // 1. Asociación: Cliente y Dirección existen independientemente
        Direccion dirCliente = new Direccion("Av. Libertad", "1240", "Viña del Mar");
        Cliente cliente = new Cliente("18.456.789-2", "Cristián Lillo", "+56912345678", "cristian@correo.cl", dirCliente);

        // 2. Creación de Pedido asociado al Cliente (Issue 2)
        Pedido pedido = new Pedido(101, cliente);

        // 3. Agregación y Polimorfismo mediante interfaz ItemPedido (Cap. 5 y 6)
        ItemPedido pizza = new Pizza("Pizza Pepperoni Familiar", 12990);
        ItemPedido palos = new PaloDeAjo("Palos de Ajo con Queso", 3990);
        ItemPedido bebida = new Bebida("Coca-Cola", 2500, Bebida.TamanioBebida.FAMILIAR);

        pedido.agregarItem(pizza);
        pedido.agregarItem(palos);
        pedido.agregarItem(bebida);

        // 4. Desacoplamiento DIP: Pizza y PaloDeAjo usan Preparable sin acoplarse entre sí (Issue 1)
        Preparable prepPizza = (Preparable) pizza;
        Preparable prepPalos = (Preparable) palos;
        prepPizza.avanzarEstado();
        prepPalos.avanzarEstado();
        System.out.println("Estado cocina -> " + pizza + " | " + palos);

        // 5. Agregación en despacho: se asigna Repartidor después de crear el pedido (Issue 2)
        Repartidor repartidor = new Repartidor("19.876.543-1", "Diego Becerra", "+56987654321", "diego@correo.cl", "Moto Honda");
        pedido.asignarRepartidor(repartidor);

        // 6. Dependencia, OCP y Composición (Boleta interna)
        EstrategiaDescuento descuento = new DescuentoPorcentaje(15.0);
        pedido.confirmarPago(descuento);
    }
}