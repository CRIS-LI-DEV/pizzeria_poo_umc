import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// SRP: Pedido coordina el carrito y ciclo de vida de la orden, delegando descuentos y emisión de boleta.
// DIP: Depende de la abstracción ItemPedido y recibe EstrategiaDescuento por inyección de dependencias.
public class Pedido {
    private final int id;

    // RELACIÓN: Asociación — Pedido está vinculado obligatoriamente a un Cliente existente desde su creación.
    private final Cliente cliente;

    // RELACIÓN: Agregación — Repartidor existe independientemente y se asigna opcionalmente al despachar.
    private Repartidor repartidor;

    // RELACIÓN: Agregación — Pedido agrupa ítems creados externamente bajo el contrato ItemPedido.
    private final List<ItemPedido> items;

    // RELACIÓN: Composición — Pedido crea y controla el ciclo de vida interno de su propia Boleta.
    private Boleta boleta;

    public Pedido(int id, Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Un pedido requiere un cliente asociado.");
        }
        this.id = id;
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemPedido item) {
        if (item != null) {
            this.items.add(item);
        }
    }

    // Agregación diferenciada: el repartidor se asigna en una etapa posterior (despacho).
    public void asignarRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    // Protección de estado mutable (Capítulo 4)
    public List<ItemPedido> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public Cliente getCliente() { return cliente; }
    public Repartidor getRepartidor() { return repartidor; }
    public Boleta getBoleta() { return boleta; }

    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (ItemPedido item : items) {
            subtotal += item.getPrecio();
        }
        return subtotal;
    }

    // RELACIÓN: Dependencia — Pedido utiliza temporalmente EstrategiaDescuento como parámetro sin almacenarla.
    public double calcularTotal(EstrategiaDescuento estrategia) {
        EstrategiaDescuento politica = (estrategia != null) ? estrategia : new SinDescuento();
        double subtotal = calcularSubtotal();
        return subtotal - politica.calcularDescuento(subtotal);
    }

    // Composición: la Boleta nace dentro de Pedido al confirmar el pago.
    public void confirmarPago(EstrategiaDescuento estrategia) {
        EstrategiaDescuento politica = (estrategia != null) ? estrategia : new SinDescuento();
        double totalFinal = calcularTotal(politica);
        this.boleta = new Boleta(this.id);
        System.out.println("=== RESUMEN PEDIDO #" + id + " ===");
        System.out.println("Cliente: " + cliente);
        System.out.println("Repartidor: " + (repartidor != null ? repartidor : "Retiro en local / Pendiente"));
        System.out.println("Política aplicada: " + politica.getDescripcionDescuento());
        this.boleta.mostrarBoleta(totalFinal);
    }
}